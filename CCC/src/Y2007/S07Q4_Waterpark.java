package Y2007;

import java.util.*;

public class S07Q4_Waterpark {
    static int N;
    static ArrayList<Integer>[] map;
    static int counter;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new ArrayList[N];
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        int a = sc.nextInt()-1, b = sc.nextInt()-1;
        while (a != -1 && b != -1) {
            map[a].add(b);
            a = sc.nextInt()-1;
            b = sc.nextInt()-1;
        }

        arr = new int[N];
        doDFS(0);
        System.out.println(counter);
    }

    static void doDFS(int curr){
        if (curr == N-1) {
            counter++;
            arr[curr]++;
        } else {
            for (int i : map[curr]) {
                if (arr[i] > 0) {
                    counter += arr[i];
                    arr[curr] += arr[i];
                } else
                    doDFS(i);
            }
        }
    }
}
