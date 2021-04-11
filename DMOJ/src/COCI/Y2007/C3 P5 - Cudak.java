package COCI.Y2007;

import java.util.*;
import java.io.*;

public class COCI07C3P5_Cudak {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static long A, B, S, dp[][][];
    static int[] a = new int[16];

    public static void main(String[] args) throws IOException {
        A = readLong(); B = readLong(); S = readLong();
        dp = new long[16][2][150];
        for (int i = 0; i < 16; i++) {
            Arrays.fill(dp[i][0], -1); Arrays.fill(dp[i][1], -1);
        }
//        for (int i = 0; i < 16; i++) {
//            for (int j = 0; j < 150; j++) {
//                Arrays.fill(dp[i][0][j], -1); Arrays.fill(dp[i][1][j], -1);
//            }
//        }
//        long tmp1 = run(B), tmp2 = run(A-1), test2 = run(12);
//        System.out.println(run(B) + " " + tmp2);
        long runa = run(A-1);
        System.out.println(run(B) - run(A-1));
        // do bin search
        long test3 = run(19);
        long pf = A, pb = B, pm, low = Long.MAX_VALUE;
        while (pf <= pb) {
            pm = (pf+pb)>>1;
            long test = run(pm);
            if (test - runa > 0) { low = pm; pb = pm - 1; }
            else pf = pm + 1;
        }
        System.out.println(low);
    }

    static long run(long val) {
        int pos = 1;
        for (int i = 0; i < 16; i++) {
            Arrays.fill(dp[i][0], -1); Arrays.fill(dp[i][1], -1);
        }
        for (; val>0; val/=10) a[pos++] = (int)(val % 10);
        return calc(--pos, 1, 0);
    }

    static long calc(int pos, int flag, int sum) {
        if (sum > S) return dp[pos][flag][sum] = 0;
        if (pos == 0) return dp[pos][flag][sum] = (sum == S ? 1:0);
        if (dp[pos][flag][sum] != -1) return dp[pos][flag][sum];
        long ret = 0L;
        int limit = flag==1 ? a[pos] : 9;
        for (int i = 0; i <= limit; i++) {
            ret += calc(pos-1, (i==limit&&flag==1) ? 1:0, sum+i);
        }
        return dp[pos][flag][sum] = ret;
    }

//    static long calc(int pos, int flag, int sum, int lmt) {
//        if (pos == 0) return sum == S ? 1:0;
//        if (dp[pos][flag][sum][lmt] != -1) return dp[pos][flag][sum][lmt];
//        long ret = 0L;
//        int limit = flag==1 ? a[pos] : 9;
//        for (int i = 0; i <= limit; i++) {
//            ret += calc(pos-1, (i==limit&&flag==1) ? 1:0, sum+i, limit);
//        }
//        return dp[pos][flag][sum][lmt] = ret;
//    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
