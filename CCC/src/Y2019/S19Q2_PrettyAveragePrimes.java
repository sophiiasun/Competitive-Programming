package Y2019;

import java.util.*;

public class S19Q2_PrettyAveragePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int[] val = new int[T];
        int max = 0;
        for (int t = 0; t < T; t++) {
            val[t] = sc.nextInt();
            if (val[t] > max)
                max = val[t];
        }
        boolean[] prime = new boolean[max<<1];
        list.add(2); prime[2] = true;
        list.add(3); prime[3] = true;
        list.add(5); prime[5] = true;
        list.add(7); prime[7] = true;
        list.add(11); prime[11] = true;
        list.add(13); prime[13] = true;
        for (int i = 17; i < max<<1; i+=2) {
            boolean isPrime = true;
            for (int j = 0; list.get(j) <= (int)Math.sqrt(i); j++) {
                if (i % list.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
                prime[i] = true;
            }
        }
        for (int t = 0; t < T; t++) {
            for (int i = val[t]; i >= 0; i--) {
                int up = (val[t]<<1)-i;
                if (prime[i] && prime[up]) {
                    System.out.println(i + " " + up);
                    break;
                }
            }
        }

    }
}
