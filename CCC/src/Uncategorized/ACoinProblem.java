package Uncategorized;

import java.util.*;
import java.io.*;

public class ACoinProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), V = readInt(), c, l, high=0, max=0;
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = readInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new int[]{readInt(), readInt(), i});
            max = Math.max(max, list.get(i)[0]);
        }
        Collections.sort(list, (int[] a, int[]b) -> a[1]-b[1]);
        int[] dp = new int[max+1];
        Arrays.fill(dp, 100000000); dp[0] = 0;

        int[] out = new int[V];

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= max; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
            for (int j = high; j < V && list.get(j)[1]==i+1; j++) {
                out[list.get(j)[2]] = dp[list.get(j)[0]]; high++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (out[i] != 100000000) System.out.println(out[i]);
            else System.out.println(-1);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
