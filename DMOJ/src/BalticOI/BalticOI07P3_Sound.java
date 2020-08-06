package BalticOI;

import java.util.*;
import java.io.*;

public class BalticOI07P3_Sound {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), c = readInt();
        Deque<C> min = new LinkedList<>(), max = new LinkedList<>();
        boolean flag = false;
        for (int i = 1, x; i <= n; i++) {
            x = readInt();
            while (!min.isEmpty() && i - min.peekFirst().i > m) min.pollFirst();
            while (!max.isEmpty() && i - max.peekFirst().i > m) max.pollFirst();
            while (!min.isEmpty() && min.peekLast().n >= x) min.pollLast();
            while (!max.isEmpty() && max.peekLast().n <= x) max.pollLast();
            min.addLast(new C(i, x)); max.addLast(new C(i, x));
            if (i >= m && max.peekFirst().n - min.peekFirst().n <= c) { flag = true; System.out.println(i - m + 1); }
        }
        if (!flag) System.out.println("NONE");
    }

    static class C {
        int i, n;
        C (int ii, int nn) { i = ii; n = nn; }
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
