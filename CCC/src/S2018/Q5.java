package S2018;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Q5 {
    static int N, M, P, Q;
    static int[] aPar; // Parent array
    static LinkedList<int[]> aLink = new LinkedList<>(); // Stores three values: [start location, end location, cost]
    // to find number to subtract: P - city number - 1
    static int cnt = 0; // stores the number of edges created
    static int total = 0; // the total cost of all passages
    static int cost = 0; //the cost of passages created

    //P is flights between cities
    //Q is portals between planets
    public static void main(String[] args) {
        init();
        run();
        out();
    }
    static void run() {
        for (int i = 0; i < aLink.size(); i++) {
            if (aPar[aLink.get(i)[0]] == aPar[aLink.get(i)[1]])
                continue;
            else {
                cost += aLink.get(i)[2];
                mergeSets(aLink.get(i)[0], aLink.get(i)[1]);
                cnt++;
            }
            if (cnt == N * M - 1)
                break;
        }
    }
    static void mergeSets(int a, int b) { // sends in two city numbers
        //change parent node of b-set to parent node of a-set
        //leave rest as is
        int bP = aPar[b];
        for (int i = 0; i < N * M; i++) {
            if (aPar[i] == bP)
                aPar[i] = aPar[a];
        }
    }
    static void out() {
        System.out.println(total -cost);
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        Q = sc.nextInt();
        aPar = new int[N * M];
        for (int i = 0; i < N*M; i++)
            aPar[i] = i;
        // Planet number * P - P = first city of planet
        // Planet number * P - 1 = last city of planet
        // Planet number * P - (P - city number) = last city of planet
        for (int i = 1; i <= P; i++) { //i == run cycle, total of P flights per planet
            int tmp1 = sc.nextInt(); //city numbers
            int tmp2 = sc.nextInt();
            int tmp3 = sc.nextInt();
            for (int j = 1; j <= N; j++) { // j = planet number
                aLink.add(new int[]{(j * M - (M - tmp1)) - 1, (j * M - (M - tmp2)) - 1, tmp3});
                total+=tmp3;
            }
        }
        for (int i = P + 1; i <= P + Q; i++) { //i == run cycle, total of Q portals in universe between planets
            int tmp1 = sc.nextInt(); // planet number
            int tmp2 = sc.nextInt();
            int tmp3 = sc.nextInt();
            for (int j = 1; j <= M; j++) {// j = city number
                aLink.add(new int[]{(tmp1 * M - (M - j)) - 1, (tmp2 * M - (M - j)) - 1, tmp3});
                total+=tmp3;
            }
        }
        Collections.sort(aLink, (int[] a, int[] b) -> a[2] - b[2]);
    }
}
