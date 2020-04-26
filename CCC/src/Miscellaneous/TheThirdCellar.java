package Miscellaneous;

import java.util.*;

public class TheThirdCellar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2]; // Ranges
//        int largest = 0;
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
//            if (arr[i][1] > largest)
//                largest = arr[i][1];
        }
        ArrayList<Integer> list = new ArrayList<>(); // Contains all primes
        boolean[] prime = new boolean[1000001]; // True if index is prime
        list.add(2); prime[2] = true;
        list.add(3); prime[3] = true;
        list.add(5); prime[5] = true;
        list.add(7); prime[7] = true;
        list.add(11); prime[11] = true;
        list.add(13); prime[13] = true;
        list.add(17); prime[17] = true;
        for (int i = 19; i <= 1000000; i+=2) {
            int sqrt = (int)Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 0; list.get(j) <= sqrt; j++) {
                if (i % list.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                list.add(i);
                prime[i] = true;
            }
        }
        for (int t = 0; t < N; t++) {
            int counter = 0;
            for (int i = arr[t][0]; i <= arr[t][1]; i++) {
                if (prime[i])
                    counter++;
            }
            System.out.println(counter);
        }
    }
}
