import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt();
        C[] a = new C[M];
        for (int i = 0; i < M; i++) a[i] = new C(readInt(), readInt(), readLine());
        int Y = readInt();
        for (int i = 0; i < M; i++) {
            if (a[i].b == Y) System.out.println(a[i].s);
        }
    }

    static class C {
        int a, b; String s;
        C (int aa, int bb, String ss) { a = aa; b = bb; s = ss; }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}