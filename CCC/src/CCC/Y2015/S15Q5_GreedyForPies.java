package CCC.Y2015;

import java.util.*;
import java.io.*;

public class S15Q5_GreedyForPies {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, an[], am[], dp[][][][];

    public static void main(String[] args) throws IOException {
        N = readInt(); an = new int[N+1];
        for (int i = 1; i <= N; i++) an[i] = readInt();
        M = readInt(); am = new int[M+1];
        for (int i = 1; i <= M; i++) am[i] = readInt();
        Arrays.sort(am);
        dp = new int[N+3][2][M+3][M+3];
        fill();
        System.out.println(run(1, 0, 1, M));
    }

    static int run (int pos, int taken, int pf, int pb) {
//        System.out.println(pos + " " + pf + " " + pb);
        if (dp[pos][taken][pf][pb] != -1) return dp[pos][taken][pf][pb];
        int ret;
        if (pos == N + 1) {
            if (pf <= pb) { // still more pies = still more chance to use as fillers and take
                if (taken == 0) ret = am[pb] + run(pos, 1, pf, pb - 1);
                else ret = run(pos, 0, pf+1, pb);
            } else ret = 0;
        } else {
            if (taken == 1) { // prev was taken
                ret = run(pos + 1, 0, pf, pb); // skip curr
                if (pf <= pb) ret = Math.max(ret, run(pos, 0, pf + 1, pb)); // use filler
            } else { // prev not taken
                ret = Math.max(an[pos] + run(pos + 1, 1, pf, pb), run(pos + 1, 0, pf, pb)); // take curr
                if (pf <= pb) ret = Math.max(ret, am[pb] + run(pos, 1, pf, pb - 1)); // use filler
            }
        }
        return dp[pos][taken][pf][pb] = ret;
    }

    static void fill (){
        for (int i = 0 ; i <= N + 2; i++) {
            for (int j = 0; j <= M + 2; j++) {
                Arrays.fill(dp[i][0][j], -1);
                Arrays.fill(dp[i][1][j], -1);
            }
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
