package CCC.Y2018;

import java.util.Scanner;

public class J18Q1_TelemarketerOrNot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) arr[i] = sc.nextInt();
        System.out.println((arr[0] < 8 || arr[3] < 8 || arr[1] != arr[2] ? "answer" : "ignore"));
    }
}
