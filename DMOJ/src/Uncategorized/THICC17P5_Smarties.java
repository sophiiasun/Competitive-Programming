package Uncategorized;

import java.util.*;
import java.io.*;

public class THICC17P5_Smarties {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), a[] = new int[N]; long ans = 0;
        BitSet bs = new BitSet(N);
        for (int i = 0; i < N; i++) a[i] = readInt();
        for (int i = K; i < N; i++) {
            for (int j = 0; j <= i-K; j++) {
                bs.set(a[j]);
                if (bs.cardinality() >= K) ans++;
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
