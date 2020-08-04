package CCC.Y2019;

import java.util.*;
import java.io.*;

public class S19Q4_Tourism {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, dp[], pma[], sma[];

    public static void main(String[] args) throws IOException {
        N = readInt(); K = readInt(); dp = new int[N+1]; pma = new int[N+1]; sma = new int[N+1];

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
