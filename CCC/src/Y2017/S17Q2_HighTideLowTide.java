package Y2017;

import java.util.*;

public class S17Q2_HighTideLowTide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int mid = (int)Math.round(0.5 * N);
        StringBuilder sb = new StringBuilder();
        for (int i = mid, j = mid + 1; j <= N; i--, j++)
            sb.append(arr[i] + " " + arr[j] + " ");
        if (N % 2 == 0)
            sb.setLength(sb.length()-1);
        else
            sb.append(arr[1]);
        System.out.println(sb);
    }
}
