package WK200404;

import java.util.*;

public class ZeroSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                System.out.println("0 0 0 0");
                System.exit(0);
            }
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(-1 * sum)) {
                    System.out.println(arr[i] + " " + arr[j] + " " + map.get(-1 * sum)[0] + " " + map.get(-1 * sum)[1]);
                    System.exit(0);
                } else if (!map.containsKey(sum))
                    map.put(sum, new int[]{arr[i], arr[j]});
            }
        }
        System.out.println(-1);
    }
}
