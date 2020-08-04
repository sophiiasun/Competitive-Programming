package Algorithms.Fibonacci;

import java.util.*;

public class SimpleRecursive_Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        double time = System.currentTimeMillis();
        long output = calcFib(N);
        System.out.println(output);
        System.out.println(System.currentTimeMillis()-time);
    }

    private static long calcFib(long iV) {
        if(iV == 1 || iV == 2)
            return 1;
        else
            return calcFib(iV-1) + calcFib(iV-2);
    }

}
