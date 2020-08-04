package CCC.Y2019;

import java.util.Scanner;

public class J19Q1_WinningScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) arr[i] = sc.nextInt();
        int a = (arr[0]<<1) + arr[0] + (arr[1]<<1) + arr[2];
        int b = (arr[3]<<1) + arr[3] + (arr[4]<<1) + arr[5];
        if (a>b) System.out.println("A");
        else if (b>a) System.out.println("B");
        else System.out.println("T");
    }
}
