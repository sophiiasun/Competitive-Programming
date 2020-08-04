package VM7WC;

import java.util.*;
import java.io.*;

public class VM7WC15_2Gold_UnitingTheEarthEmpire {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), pf = 1, pb = 1, q[] = new int[N+2], c[] = new int[N+1];
        long ans = 0, a[] = new long[N+1];
        for (int i = 1; i <= N; i++) { a[i] = readLong(); c[i] = 1; }
        for (int i = 1; i <= N; i++) {
            while (pf < pb && a[q[pb]] <= a[i]) {
                ans += c[q[pb]];
                if (a[i] == a[q[pb]]) c[i] += c[q[pb]];
                pb--;
            }
            if (pf < pb) ans++;
            q[++pb] = i;
        }
        System.out.println(ans);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
