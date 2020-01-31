package Y2013;

import java.util.*;

public class S13Q5_V2 {
    static int N;
    static int[] cost;
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        cost = new int[Math.max(4, N+1)];
        cost[1] = 0;
        cost[2] = 1;
        primes.add(2);

        int sqrt = (int) Math.sqrt(N);
        boolean isPrime;
        for (int num = 3, tsqrt = 0, c = 0; num <= sqrt; num+=2) {
            isPrime = true;
            tsqrt = (int) Math.sqrt(num);
            for (int pi = 0; primes.get(pi) <= tsqrt; pi++) {
                if(num % primes.get(pi) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primes.add(num);
                c = num-1;
                for (int m = num - 1, pi = 0; m!=1;){
                    if (m % primes.get(pi) == 0){
                         m /= primes.get(pi);
                         c += cost[primes.get(pi)];
                    } else
                        pi++;
                }
                cost[num] = c;
            }
        }

        int c = 0, pi = 0;
        while (N != 1) {
            sqrt = (int) Math.sqrt(N);
            pi = 0;
            while (pi < primes.size() && primes.get(pi) <= sqrt && N!=1) {
                if (N % primes.get(pi) == 0) {
                    N /= primes.get(pi);
                    c += cost[primes.get(pi)];
                } else
                    pi++;
            }
            if (N != 1) {
                N--;
                c += N;
            }
        }

        System.out.println(c);
    }
}
