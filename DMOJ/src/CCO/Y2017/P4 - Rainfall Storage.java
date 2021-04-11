package CCO.Y2017;

import java.util.*;
import java.io.*;

public class P4_RainfallStorage {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a[] = new int[N], max = 0, tmp = 0, a2[] = new int[55], pos = 0;
        if (N == 2) { System.out.println(0); return; }
        for (int i = 0; i < N; i++) { a[i] = readInt(); max += a[i]; }
        Arrays.sort(a);
        max = (N-1) * a[N-2] - (max - a[N-1] - a[N-2]);
        boolean dp[][] = new boolean[2][max+1];
        dp[0][0] = dp[1][0] = true; a2[tmp++] = a[N-2];
        for (int i = N-3; i >= 0; i--, pos^=1) {
            for (int j = 1; j <= max; j++) {
                dp[pos^1][j] |= dp[pos][j];
                if (!dp[pos][j]) {
                    for (int k = 0; k < tmp; k++) {
                        int d = a2[k] - a[i];
                        if (j >= d && dp[pos][j-d]) { dp[pos^1][j] = true; break; }
                    }
                }
            }
            if (a[i] != a2[tmp-1]) a2[tmp++] = a[i];
        }

        for (int i = 0; i <= max; i++) {
            if (dp[pos][i]) System.out.print(i + " ");
        } System.out.println();
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
