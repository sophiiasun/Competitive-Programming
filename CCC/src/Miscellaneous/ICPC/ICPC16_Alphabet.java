package Miscellaneous.ICPC;

import java.util.*;
import java.io.*;

public class ICPC16_Alphabet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException { // a=97, z=122
        String in = " " + next();
        int[] dp = new int[27]; int max = 0;
        for (int i = 1; i < in.length(); i++) {
            int curr = in.charAt(i)-96;
            for (int j = 0; j < curr; j++)
                dp[curr] = Math.max(dp[curr], dp[j] + 1);
            if (dp[curr] > max) max = dp[curr];
        }
        System.out.println(26-max);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
