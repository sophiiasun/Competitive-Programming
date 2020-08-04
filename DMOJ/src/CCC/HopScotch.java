package CCC;

import java.util.*;
import java.io.*;

public class HopScotch {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, S, L, LE[];
    static C a[];

    public static void main(String[] args) throws IOException {
        N = readInt(); S = Math.min(100, N); L = N / S; LE = new int[S]; a = new C[N];
        for (int i = 0; i < N; i++) { a[i] = new C(readInt()); }
        LE[S-1] = N;
        for (int i = N-1, l = S-1, e = N-1, s = e-L; i >= 0; i--) {
            if (i == s) { l--; e = s; s = l==0 ? -1: s-L; LE[l] = e; }
            a[i].lvl = l; run(i, a[i]);
        }

        int Q = readInt();
        for (int q = 0, j; q < Q; q++) {
            int x = readInt(), y = readInt();
            if (x == 1) {
                j = a[y].j;
                while (a[y].nlvl != S) { y = a[y].des; j += a[y].j; }
                System.out.println(j);
            } else {
                a[y].k = readInt(); run(y, a[y]);
                int next = a[y].lvl == 0 ? 0 : LE[a[y].lvl - 1] + 1;
                for (j = y-1; j >= next; j--) {
                    int tmp = j + a[j].k;
                    if (tmp <= y) { a[j].nlvl = a[tmp].nlvl; a[j].des = a[tmp].des; a[j].j = a[tmp].j + 1; }
                }
            }
        }
    }

    static void run (int i, C c) {
        int tmp = i + a[i].k;
        if (tmp >= N) { c.nlvl = S; c.des = N; c.j = 1; }
        else if (tmp > LE[c.lvl]) { c.nlvl = a[tmp].lvl; c.des = tmp; c.j = 1; }
        else { c.nlvl = a[tmp].nlvl; c.des = a[tmp].des; c.j = a[tmp].j + 1; }
    }

    static class C {
        int k, lvl, nlvl, des, j;
        C (int kk) { k = kk; }
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
