package Uncategorized;

import java.util.*;
import java.io.*;

public class DigitProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, expect, dp[][][][] = new int[1002][1<<10][2][2], mod = (int)1e9+7;
    static char[] s;

    public static void main(String[] args) throws IOException {
        N = readInt();
        for (int i = 1; i <= N; i++) expect |= 1<<readInt();
        s = readLine().toCharArray();
        System.out.println(run(0, 0, 1, 1) + (expect==1 ? 1 : 0));
    }

    static int run(int pos, int mask, int lmt, int zero) {
        int ret = dp[pos][mask][lmt][zero];
        if (ret != -1) return ret;
        if (pos == s.length) { return (mask & expect) == expect ? 1 : 0; }
        int v = s[pos], bound = lmt==1 ? v : 9; ret = 0;
        for (int i = 0; i <= bound; i++) {
//            ret += run(pos+1, (zero!=0 && i==0)?mask:mask, mask|1<<i, lmt==1 && i==v, zero==1 && i==0);
            ret %= mod;
        }
        return ret;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
