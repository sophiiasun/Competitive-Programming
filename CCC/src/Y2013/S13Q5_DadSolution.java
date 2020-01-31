package Y2013;

import java.util.*;

public class S13Q5_DadSolution {
    static int N;
    static int[] costs;
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        costs = new int[Math.max(4,N + 1)];
        costs[1] = 0;
        costs[2] = 1;
        primes.add(2);

        // Find all prime factors of N and calculate cost for each prime factor
        int sqrt = (int) Math.sqrt(N);
        boolean isPrime = false;
        for (int n=3, tsqrt=0, c=0; n <=sqrt; n+=2) {
            isPrime = true;
            tsqrt = (int) Math.sqrt(n);
            for (int pi=0; primes.get(pi)<tsqrt; pi++) {
                if (n % primes.get(pi) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(n);
                c = n - 1;
                for (int m=n-1, pi=0; m!=1;) {
                    if (m % primes.get(pi) == 0) {
                        m /= primes.get(pi);
                        c += costs[primes.get(pi)];
                    } else {
                        pi++;
                    }
                }
                costs[n] = c;
            }
        }

        // Calculate cost for N
        int c = 0, pi = 0, p = 2;
        Set<Integer> set = new HashSet<>(primes);
        while (N != 1) {
            sqrt = (int) Math.sqrt(N);
            pi = 0;
            while (pi<primes.size() && primes.get(pi)<=sqrt && N!=1) {
                if (N % primes.get(pi) == 0) {
                    N /= primes.get(pi);
                    c += costs[primes.get(pi)];
                } else {
                    pi++;
                }
            }
            if (N != 1) { // Hitting a prime
                N--;
                c += N;
            }
        }
        System.out.println(c);
    }
}
