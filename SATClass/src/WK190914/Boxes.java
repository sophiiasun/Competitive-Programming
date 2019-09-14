package WK190914;

import java.util.*;

public class Boxes { //must input N, then height, then width, then depth

    private static int N;
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));

        int cnt = arr[N-1][0];
        int marker = N-2;
        for(int i = N-1; i >= 0; i--) {
            marker = chkHWD(i, marker);
            if (marker == i)
                cnt += arr[marker][0];
        }
        System.out.print(cnt);
    }

    private static int chkHWD (int i, int marker) {
        if (arr[i][0] < arr[marker][0]) {
            if (arr[i][1] < arr[marker][1]) {
                if (arr[i][2] < arr[marker][2]) {
                    arr[marker][0] = arr[i][0];
                    arr[marker][1] = arr[i][1];
                    arr[marker][2] = arr[i][2];
                    marker = i;
                }
            }
        }
        return marker;
    }

}
