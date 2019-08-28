package Algorithms.UglyNumber;

// A number is ugly if its only prime factors are 2, 3, 5

import java.util.*;

public class Simple_UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0, chk = 0;
        double time = System.nanoTime();
        do {
            chk++;
            if(chkUgly(chk))
                cnt++;
        } while(cnt != N);
        System.out.println(chk);
        System.out.println(System.nanoTime() - time);
    }

    private static boolean chkUgly(int N) {
        while(N % 2 == 0) N = N / 2;
        while(N % 3 == 0) N = N / 3;
        while(N % 5 == 0) N = N / 5;
        if(N == 1) return true;
        else return false;
    }

}
