package Y2017;

import java.util.*;

public class S17Q2 {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int s, b; //small, big
        if (N % 2 == 0) {
            s = N/2 - 1;
            b = N/2;
        } else {
            s = N/2;
            b = N/2 + 1;
        }
        while (s >= 0 && b < N) {
            sb.append(arr[s] + " ");
            sb.append(arr[b]);
            if (b != N - 1)
                sb.append(" ");
            s--; b++;
        }
        if (N % 2 != 0 && sb.length() == 0) {
            sb.append(arr[0]);
        } else if (N % 2 != 0 && sb.length() > 0)
            sb.append(" " + arr[0]);
        System.out.println(sb);
    }
}
