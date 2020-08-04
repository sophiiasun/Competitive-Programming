package Algorithms;

import java.util.*;

public class PrimeNumber {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        arr.add(11);
        int cnt = 5;
        for (int i = 13; i < 10000; i+=2) {
            if (isPrime(i)) {
                arr.add(i);
                cnt++;
            }
        }
        System.out.println(arr);
        System.out.println(cnt);
    }
    static boolean isPrime(int N) { //return true for prime
        int mrk = (int)Math.round(Math.sqrt(N));
        for (int i = 0; arr.get(i) <= mrk; i++) {
            if (N % arr.get(i) == 0)
                return false;
        }
        return true;
    }
}
