package WK191005;

import java.util.*;

public class CowDance2 {
    static int N;
    static int[] move;
    static boolean[] bA; //tracks whether or not the position has a cow after move
    static boolean[] pos; //tracks whether or not the position has a cow prior to move
    public static void main(String[] args) { // no need to track movement of cows. use bln arr to track whether or not a cow stands in a certain position
        init();
        run();
    }

    static void run() {
        //tC tracks the number of empty spaces
        int tC = 0;
        int cnt;
        do {
            System.out.println(Arrays.toString(bA));
            cnt = tC;
            tC = 0;
            Arrays.fill(bA, false);
            for (int i = 0; i < N; i++) {
                if (pos[i]) { //if there are cows in that position, then proceed to switch
                    bA[move[i] - 1] = true; //new position now has cows
                }
            }
            pos = Arrays.copyOf(bA, bA.length);
            for (int i = 0; i < N; i++) {
                if (pos[i])
                    tC++;
            }
            System.out.println("run");
        } while (tC != cnt);
        System.out.println(tC);
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        move = new int[N];
        bA = new boolean[N];
        pos = new boolean[N];
        for (int i = 0; i < N; i++) {
            move[i] = sc.nextInt();
            bA[i] = true;
            pos[i] = true;
        }
    }
}
