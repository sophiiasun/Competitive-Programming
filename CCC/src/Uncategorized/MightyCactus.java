package Uncategorized;

import java.util.*;
import java.io.*;

public class MightyCactus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        double N = readInt(); int M = readInt(), K = readInt(), end=0;
        double dmg[] = new double[200010];
        C ak[] = new C[K];
        for (int i = 0; i < K; i++) ak[i] = new C(readInt(), 1.0-(readInt()/100.0));
        for (int i = 0, x, y, z; i < M; i++) {
            x = readInt(); y = readInt(); z = readInt();
            dmg[x] += z; dmg[x+y] -= z; end = Math.max(end, x+y);
        }
        for (int i = 0; i <= end; i++) {
            double taken = dmg[i] += i > 0 ? dmg[i-1] : 0; // build prefix
            for (int j = 0; j < K; j++) {
                taken = Math.min(taken, Math.max(0.0, dmg[i]-ak[j].t)*ak[j].a);
            }
            N -= taken;
        }
        System.out.println(N > 0 ?  String.format("%.2f", N) : "Act Like A Cactus.");
    }

    static class D{
        int s, t, z;
        D(int ss, int tt, int zz) { s = ss; t = tt; z = zz; }
    }

    static class C{
        int t; double a;
        C (int tt, double aa) { t = tt; a = aa; }
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
