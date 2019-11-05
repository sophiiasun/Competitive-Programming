package S2017;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2]; //0 == team 1, 1 == team 2
        int t1 = 0, t2 = 0;
        int max = 0;
        arr[0][0] = sc.nextInt();
        for (int i = 1; i < N; i++)
            arr[i][0] = arr[i-1][0] + sc.nextInt();
        arr[0][1] = sc.nextInt();
        for (int i = 1; i < N; i++)
            arr[i][1] = arr[i-1][1] + sc.nextInt();
        for (int i = 0; i < N; i++) {
            if (arr[i][0] == arr[i][1])
                max = i + 1;
        }
        System.out.print(max);
    }
}
