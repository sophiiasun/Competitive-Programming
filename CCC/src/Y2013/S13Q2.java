package Y2013;

import java.util.*;

public class S13Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int tmp = 0;
        int counter = 0;
        for (int i = 0; i < N+3; i++) {
            if (i < 4) {
                tmp+=arr[i];
            } else if (i <= N) {
                tmp += arr[i];
                tmp -= arr[i-4];
            } else {
                tmp -= arr[i-4];
            }
            if (tmp > W) {
                System.out.println(counter);
                System.exit(0);
            } else
                counter++;
        }
        System.out.println(N);
    }
}
