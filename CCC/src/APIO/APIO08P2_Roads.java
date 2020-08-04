package APIO;

import java.util.*;
import java.io.*;

public class APIO08P2_Roads {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, K, p[], total = 0, cobble = 0;
    static boolean mustCobble[];
    static ArrayList<C> out = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); K = readInt(); p = new int[N+1];
        C a[] = new C[M+1]; mustCobble = new boolean[N+1];
        for (int i = 1; i <= N; i++) p[i] = i;
        for (int i = 1, pf=1, pb=M, x, y, z; i <= M; i++) { // front of a[] is cobble
            x = readInt(); y = readInt(); z = readInt();
            if (z==0) a[pf++] = new C(x, y, z);
            else a[pb--] = new C(x, y, z);
        }
        int pos = 1;
        for (int i = M; i > 0; i--) {
            int t1 = find(a[i].a), t2 = find(a[i].b);
            if (t1 == t2) continue;
            p[t1] = t2; total++;
            if (a[i].c == 0) {
                cobble++;
                C tmp = a[pos]; a[pos++] = a[i]; a[i] = tmp; // put mandatory cobble at front of array
            }
        }
        if (cobble > K || total < N-1) { System.out.println("no solution"); return; }
        for (int i = 1; i <= N; i++) p[i] = i; cobble = total = 0;
        for (int i = 1; i <= M && total < N-1; i++) {
            int t1 = find(a[i].a), t2 = find(a[i].b);
            if (t1 == t2) continue;
            if (cobble < K || a[i].c == 1) {
                p[t1] = t2; total++;
                if (a[i].c == 0) cobble++;
                out.add(a[i]);
            }
        }
        if (cobble != K || total < N-1) { System.out.println("no solution"); return; }
        for (C c : out) System.out.println(c.a + " " + c.b + " " + c.c);
    }

    static int find(int cur) {
        return p[cur] = cur == p[cur] ? p[cur] : find(p[cur]);
    }

    static class C {
        int a, b, c;
        C (int aa, int bb, int cc) { a = aa; b = bb; c = cc; }
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
