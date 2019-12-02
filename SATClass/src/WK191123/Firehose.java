package WK191123;

import java.util.*;

public class Firehose {
    static int H, K;
    static int[] arr;
    static int[] dA; //contains the difference from i to i+1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        arr = new int[K];
        dA = new int[K];
        int max = 0, tmp;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if (i != 0) {
                dA[i-1] = arr[i] - arr[i-1];
            }
        }
        dA[K-1] = 1000000 - arr[K-1];
        K = sc.nextInt();
        
    }
}
