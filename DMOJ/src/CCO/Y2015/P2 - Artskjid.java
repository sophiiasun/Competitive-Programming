package CCO.Y2015;

import java.io.*;
import java.util.*;

public class P2_Artskjid {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, adj[][], dp[][];

    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt(); adj = new int[n][n]; dp=new int[n][1<<n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], (int)-1e9);
        for(int i=1; i<=m; i++) {
            int u = readInt(), v = readInt(), w = readInt();
            adj[u][v] = w;
        }
        System.out.println( run(0, 1) );
    }

    static int run(int u, int mask) {
        if(u == n-1) return 0;
        if(dp[u][mask] > 0) return dp[u][mask];
        for(int v=1; v<n; v++) {
            if (adj[u][v] > 0 && (mask & 1 << v) == 0)
                dp[u][mask] = Math.max(dp[u][mask], adj[u][v] + run(v, mask | 1 << v));
        }
        return dp[u][mask];
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}