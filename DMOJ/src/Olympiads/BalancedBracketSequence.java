package Olympiads;

import java.util.*;
import java.io.*;

public class BalancedBracketSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] arr = readLine().toCharArray();
        int[][] dp = new int[arr.length][arr.length]; int c;
        for (int i = 0; i < arr.length; i++) dp[i][i] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                c = i+j;
                dp[j][c] = Integer.MAX_VALUE;
                for (int k = j; k < c; k++) {
                    dp[j][c] = Math.min(dp[j][c], dp[j][k] + dp[k+1][c]);
                }
            }
        }
        System.out.println(dp[0][arr.length-1]);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
