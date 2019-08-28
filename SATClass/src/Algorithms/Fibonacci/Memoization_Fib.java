package Algorithms.Fibonacci;

import java.util.*;

public class Memoization_Fib {
    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt();
    private static long[] aFib = new long[N + 1];

    public static void main(String[] args) {
        aFib[0] = 1;
        aFib[1] = 1;
        System.out.println(calcFib(N));
    }

    public static long calcFib(int iU) {
        if(iU == 1 || iU == 2)
            return 1;
        else{
            if(aFib[iU] != 0)
                return aFib[iU];
            else {
                aFib[iU] = calcFib(iU-1) + calcFib(iU - 2);
                return aFib[iU];
            }
        }
    }
}
