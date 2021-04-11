package CCC.Y2018;

import java.util.*;
import java.io.*;

public class S18Q5_MaximumStrategiesSavings {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, P, Q, pf[], pp[];
    static long ori = 0, cost = 0;
    static ArrayList<C> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); P = readInt(); Q = readInt();
        pf = new int[M+1]; pp = new int[N+1];
        for (int i = 1, a, b, c; i <= N; i++) {
            pp[i] = i; a = readInt(); b = readInt(); c = readInt(); all.add(new C(a, b, c, 0)); ori += c * N;
        }
        for (int i = 1, a, b, c; i <= M; i++) {
            pf[i] = i; a = readInt(); b = readInt(); c = readInt(); all.add(new C(a, b, c, 1)); ori += c * M;
        }
        Collections.sort(all);
        for (C cur : all) { // check flights
            if (cur.d == 0) {
                if (findf(cur.a) == findf(cur.b)) continue;
                pf[cur.a] = findf(cur.b); cost += cur.c * N; M--;
            } else {
                if (findp(cur.a) == findp(cur.b)) continue;
                pp[cur.a] = findp(cur.b); cost += cur.c * M; N--;
            }
        }
        System.out.println(ori - cost);
    }

    static int findf (int a) { return pf[a] = a == pf[a] ? pf[a] : findf(pf[a]); }

    static int findp (int a) { return pp[a] = a == pp[a] ? pp[a] : findp(pp[a]); }

    static class C implements Comparable<C> {
        int a, b, c, d;
        C(int aa, int bb, int cc, int dd) { a = aa; b = bb; c = cc; d = dd; }
        public int compareTo(C other) { return c - other.c; }
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
