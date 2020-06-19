package CCC.Y2017;

import java.util.Scanner;

public class S17Q1_SumGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), max = 0, arr1[] = new int[N + 1];
        for (int i = 1; i <= N; i++) arr1[i] = sc.nextInt() + arr1[i-1];
        int b = 0;
        for (int i = 1; i <= N; i++) {
            b += sc.nextInt();
            if (b == arr1[i]) max = i;
        }
        System.out.print(max);
    }
}