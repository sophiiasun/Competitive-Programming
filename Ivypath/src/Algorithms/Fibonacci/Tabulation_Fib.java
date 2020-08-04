package Algorithms.Fibonacci;

import java.util.*;

public class Tabulation_Fib {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] aFib = new long[N + 1];
        aFib[0] = 1;
        aFib[1] = 1;
        for(int i = 2; i <= N; i++) {
            aFib[i] = aFib[i-1] + aFib[i-2];
        }
        System.out.println(aFib[N - 1]);
    }
}
