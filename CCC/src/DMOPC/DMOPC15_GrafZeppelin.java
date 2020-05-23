package DMOPC;

import java.util.*;
import java.io.*;

public class DMOPC15_GrafZeppelin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), K = readInt(), a, b;
        BitSet[] ori = new BitSet[N+1];
        BitSet[] bs = new BitSet[N+1];
        BitSet[] tmp = new BitSet[N+1];
        for (int i = 1; i <= N; i++) {
            ori[i] = new BitSet(N+1);
            bs[i] = new BitSet(N+1);
            tmp[i] = new BitSet(N+1);
        }
        for (int i = 0; i < M; i++) { // Initialize BitSets
            a = readInt(); b = readInt();
            bs[a].set(b, true); bs[b].set(a, true);
            ori[a].set(b, true); ori[b].set(a, true);
            tmp[a].set(b, true); tmp[b].set(a, true);
        }
        for (int i = 1; i < K; i++) { // Loop through K times for K distance
            for (int j = 1; j <= N; j++) { // N^2 Comparisons
                for (int p = 1; p <= N; p++) {
                    if (bs[j].get(p)) tmp[j].or(ori[p]);
                }
                bs[j].or(tmp[j]);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (bs[i].get(i)) System.out.println(bs[i].cardinality());
            else System.out.println(bs[i].cardinality()+1);
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
