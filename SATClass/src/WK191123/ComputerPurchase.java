package WK191123;

import java.util.*;

public class ComputerPurchase {
    static int N;
    static String[] name;
    static int[][] arr;
    static String str1, str2;
    public static void main(String[] args) {
        run();
        if (str1 != null)
            System.out.println(str1);
        if (str2 != null)
            System.out.println(str2);
    }
    static void run(){
        int max = 0;
        String last;
        int N, R, S, D; //ram, speed, drive
        String B; // brand
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N == 0)
            System.exit(1);
        for (int i = 0; i < N; i++) {
            B = sc.next();
            if (N == 1) {
                System.out.println(B);
                System.exit(1);
            }
            R = sc.nextInt();
            S = sc.nextInt();
            D = sc.nextInt();
            int tmp = (R<<1) + (S<<1) + S + D;
            if (tmp > max) {
                last = str1;
                str1 = B;
                str2 = last;
                max = tmp;
            } else if (tmp == max) {
                if(B.charAt(0) < str1.charAt(0)) {
                    str2 = str1;
                    str1 = name[i];
                }
            }
        }
    }
}
