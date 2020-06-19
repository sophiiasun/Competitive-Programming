package Olympiads;

import java.util.*;
import java.io.*;

public class BobsPrimeFactors {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = readInt(), max = 0, valmax = 0, idx = -1, arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = readInt(); valmax = Math.max(valmax, arr[i]);
        }
        init(arr[arr.length-1]);
        for (int i = 0; i < N; i++) {
            int tmp = find(arr[i]);
            if (tmp > max) {
                max = tmp; idx = arr[i];
            }
        }
        System.out.println(idx);
    }

    static int find (int N) {
        int max = 0;
        for (int i = 2; i <= Math.sqrt(N)+1; i++) {
            if (N % i == 0 && isPrime(i)) max = i;
        }
        return max;
    }

    static boolean isPrime (int N) {
        int lft = 0, rit = N, mid;
        while (lft <= rit) {
            mid = (lft + rit) >> 1;
            if (primes.get(mid) == N) return true;
            if (N > primes.get(mid)) lft = mid + 1;
            else rit = mid - 1;
        }
        return false;
    }

    static void init(int N) {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(29);
        for (int i = 31; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 0; j < Math.sqrt(i) && isPrime; j++) {
                if (i % primes.get(j) == 0) isPrime = false;
            }
            if (isPrime) primes.add(i);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
