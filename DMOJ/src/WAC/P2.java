package WAC;

import java.util.*;
import java.io.*;

public class P2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), Q = readInt(), a[] = new int[N+1], dif[] = new int[N+1];
        C que[] = new C[N];
        HashMap<Integer, ArrayList<C>> map = new HashMap<>();
        for (int i = N; i > 0; i--) { a[i] = readInt(); dif[i] = a[i] - a[0]; }
        for (int i = 0, x, y; i < Q; i++) {
            x = readInt(); y = readInt();
            if (!map.containsKey(y)) map.put()
        }
        Arrays.sort(que, (C x, C y)->(x.b - y.b));
        for (int i = 0; i < N; i++) {
            
        }
    }

    static class C implements Comparable<C> {
        int a, b, p, ans;
        C (int nn, int cc, int pp) { a = nn; b = cc; p = pp; }
        public int compareTo(C o) { return p - o.p; }
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
