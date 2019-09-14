package WK190914;

import java.util.*;

public class BoxesNew {

    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));

        int[] counter = new int[N];
        counter[0] = 1;
        for(int i = 1; i < N; i++) {

        }
    }

    private static int getLargestStack(int N) {
        int max;
        while ()
    }

}
