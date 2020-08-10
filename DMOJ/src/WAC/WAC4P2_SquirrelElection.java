package WAC;

import java.util.*;
import java.io.*;

public class WAC4P2_SquirrelElection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), pos=0, tot=0; C a[] = new C[N+1];
        for (int i = 1; i <= N; i++) { a[i] = new C(readInt()/2+1, readInt()); tot += a[i].p; }
        int dp[][] = new int[2][tot+1], hlf = (tot>>1) + 1, min=Integer.MAX_VALUE; a[0] = new C(0, 0);
//        Arrays.sort(a);
        for (int i = 1, tmp; i <= N; i++, pos^=1) {
            tmp = pos^1;
            for (int j = 0; j <= tot; j++) {
                if (j < a[i].v) dp[pos][j] = dp[tmp][j];
                else dp[pos][j] = Math.max(dp[tmp][j], dp[tmp][j-a[i].v] + a[i].p);
                if (dp[pos][j] >= hlf) min = Math.min(min, j);
            }
        }
        System.out.println(min);
    }

    static class C implements Comparable<C> {
        int v, p;
        C (int vv, int pp) { v = vv; p = pp;}
        public int compareTo(C o) { return v - o.v; }
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
