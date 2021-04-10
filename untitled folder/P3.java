import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), mn = Integer.MAX_VALUE, mx = 0;
        long ans = Integer.MAX_VALUE, tmp;
//        HashMap<Integer, Integer> map = new HashMap<>();

        if (N == 1) { System.out.println("0"); return; }
        C[] vec = new C[N];
        for (int i = 0, p, w, d; i < N; i++) {
            p = readInt(); w = readInt(); d = readInt();
            vec[i] = new C(p, w, d);
            mn = Integer.min(mn, p); mx = Integer.max(mx, p);
        }
        long[] psa = new long[mx+1], sfa = new long[mx+1];
        for (C c : vec) {
            for (int i = c.p+c.d+1; i <= mx; i++) {
                psa[i] += Long.max(0, psa[i-1] + c.w);
            }
            for (int i = c.p-c.d-1; i >= mn; i--) {
                sfa[i] += Long.max(0, sfa[i+1] + c.w);
            }
        }
        for (int i = mn; i <= mx; i++) {
            ans = Long.min(ans, psa[i] + sfa[i]);
        }
        System.out.println(ans);
    }

    static class C {
        int p, w, d;
        C (int pp, int ww, int dd) { p = pp; w = ww; d = dd; }
    }


    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}