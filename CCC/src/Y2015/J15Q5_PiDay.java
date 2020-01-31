package Y2015;

import java.util.*;

public class J15Q5_PiDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[K];
        int counter = 0;
        if (K == 1){
            System.out.println("1");
            System.exit(0);
        }
        for (int i = 1; i < N/K; i++) {
            boolean inOrder = true;
            for (int j = 1; j < K-i; j++)
                arr[j] = i;

            for (int j = K-1; j < K; j++)
                arr[j] = N;
            while(inOrder) {

            }
        }
    }
}

