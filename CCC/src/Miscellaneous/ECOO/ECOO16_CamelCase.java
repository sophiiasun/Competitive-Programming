package Miscellaneous.ECOO;

import java.util.*;
import java.io.*;

public class ECOO16_CamelCase {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(); Set<String> dict = new TreeSet<>();
        for (int i = 0; i < N; i++) dict.add(br.readLine());
        for (int t = 0; t < 10; t++) {
            String s = br.readLine(); int[] dp = new int[s.length()+1];
            Arrays.fill(dp, Integer.MAX_VALUE/2); dp[s.length()] = 0;
            for (int i = s.length()-1; i >= 0; i--) {
                for (int j=i+1; j <= s.length(); j++) {
                    if (dict.contains(s.substring(i, j)))
                        dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
            System.out.println(dp[0]-1);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
