package CCC;

import java.util.*;
import java.io.*;

public class CCO {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, L, pf, pb;
    static long arr[], dp[], dq[];

    public static void main(String[] args) throws IOException {
        N = readInt(); L = readInt();  pf = pb = 1;
        arr = new long[N+1]; dp = new long[N+1]; dq = new long[N+2];

    }

    static void calc (long m, long n) {
        int a = (int)m, b = (int)n;

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
