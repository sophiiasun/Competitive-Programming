package COCI.Y2007;

import java.io.*;
import java.util.*;

public class COCI07_Zapis {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), arr[] = new int[N], mat[][] = new int[N][N]; String in = readLine();
        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            if (in.charAt(i)=='(') arr[i] = -1;
            else if (in.charAt(i)==')') arr[i] = 1;
            else if (in.charAt(i)=='[') arr[i] = -2;
            else if (in.charAt(i)==']') arr[i] = 2;
            else if (in.charAt(i)=='{') arr[i] = -3;
            else if (in.charAt(i)=='}') arr[i] = 3;
            else arr[i] = 0;
        } int c, mod=1000000; // 6 ZEROS
        long tmp;
        for (int i = 1; i < N; i+=2) {
            for (int j = 0; j < N-i; j++) {
                c = i + j;
                if (arr[c] >= 0) {
                    if (arr[j]<arr[c] && (arr[j]+arr[c]==0 || arr[j]*arr[c]==0)) mat[j][c]=1;
                    else if (arr[j]==0 && arr[c]==0) mat[j][c]=3;
                    for (int k = c-1; k >= j; k-=2) {
                        tmp = mat[k][c]%mod;
                        if (k+1 < c-1) tmp = (tmp*dp[k+1][c-1])%mod;
                        if (k>j) tmp = (tmp*dp[j][k-1])%mod;
                        dp[j][c] = (dp[j][c]+tmp)%mod;
                    }
                }
            }
        }

        long n = dp[0][N-1];
        if (n>=100000) System.out.println(String.format("%05d", n%100000));
        else System.out.println(n);
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
