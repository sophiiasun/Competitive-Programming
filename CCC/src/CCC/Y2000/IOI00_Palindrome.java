package CCC.Y2000;

import java.util.*;
import java.io.*;

public class IOI00_Palindrome {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), dp[][] = new int[2][N];
        char[] s = readLine().toCharArray();
        int pre = 0, cur = 1;
        for (int i = N-2; i>=0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (s[i] == s[j]) dp[cur][j] = dp[pre][j-1];
                else dp[cur][j] = 1 + Math.min(dp[cur][j-1], dp[pre][j]);
            }
            int tmp = pre; pre = cur; cur = tmp;
        }
        System.out.println(dp[pre][N-1]);
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
