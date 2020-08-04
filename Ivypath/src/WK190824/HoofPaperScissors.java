package WK190824;

import java.util.*;

public class HoofPaperScissors {
    private static Scanner sc;
    private static int N;
    private static char[] arr;
    private static int[][] set1;
    private static int[][] set2;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N];
        getInput();
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(set1[i]) + " : " + Arrays.toString(set2[i]));
        }
        System.out.println(getMax());
    }

    private static int getMax() {
        int iRet = 0;
        for (int i = 0; i < N; i++) {
            if (set1[i][0] + set2[i][0] > iRet)
                iRet = set1[i][0] + set2[i][0];
            if (set1[i][1] + set2[i][1] > iRet)
                iRet = set1[i][1] + set2[i][1];
            if (set1[i][2] + set2[i][2] > iRet)
                iRet = set1[i][1] + set2[i][2];
        }
        return iRet;
    }

    private static void getInput() {
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next().charAt(0);
        }
        set1 = new int[N][3];
        if (arr[0] == 'R') set1[0][0] = 1;
        if (arr[0] == 'P') set1[0][1] = 1;
        if (arr[0] == 'S') set1[0][2] = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] == 'R') {
                set1[i][0] = set1[i - 1][0] + 1;
                set1[i][1] = set1[i - 1][1];
                set1[i][2] = set1[i - 1][2];
            } else if (arr[i] == 'P') {
                set1[i][0] = set1[i - 1][0];
                set1[i][1] = set1[i - 1][1] + 1;
                set1[i][2] = set1[i - 1][2];
            } else if (arr[i] == 'S') {
                set1[i][0] = set1[i - 1][0];
                set1[i][1] = set1[i - 1][1];
                set1[i][2] = set1[i - 1][2] + 1;
            }
        }
        set2 = new int[N][3];
        if (arr[N - 1] == 'R') set2[0][0] = 1;
        if (arr[N - 1] == 'P') set2[0][1] = 1;
        if (arr[N - 1] == 'S') set2[0][2] = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] == 'R') {
                set2[i][0] = set2[i + 1][0] + 1;
                set2[i][1] = set2[i + 1][1];
                set2[i][2] = set2[i + 1][2];
            } else if (arr[i] == 'P') {
                set2[i][0] = set2[i + 1][0];
                set2[i][1] = set2[i + 1][1] + 1;
                set2[i][2] = set2[i + 1][2];
            } else if (arr[i] == 'S') {
                set2[i][0] = set2[i + 1][0];
                set2[i][1] = set2[i + 1][1];
                set2[i][2] = set2[i + 1][2] + 1;
            }
        }
    }
}
