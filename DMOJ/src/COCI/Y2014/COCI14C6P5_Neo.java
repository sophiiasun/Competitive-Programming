package COCI.Y2014;

import java.util.*;
import java.io.*;

public class COCI14C6P5_Neo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int h[];

    public static void main(String[] args) throws IOException {
        int R = readInt(), C = readInt(), a[][] = new int[R][C], ans = 0; h = new int[C];
        for (int i = 0; i < R; i++) { for (int j = 0; j < C; j++) a[i][j] = readInt(); }
        for (int i = 0; i < R-1; i++) {
            for (int j = 0; j < C-1; j++) {
                h[j] = (a[i][j] + a[i+1][j+1] <= a[i+1][j] + a[i][j+1]) ? h[j] + 1 : 0;
            }
            ans = Math.max(ans, getMax());
        }
        System.out.println(ans);
    }

    static int getMax() {
        Stack<Integer> stk = new Stack<>(); int a = 0;
        for (int i = 0; i < h.length; i++) {
            while (!stk.isEmpty() && h[i] <= h[stk.peek()]) {
                int idx = stk.pop(), l = stk.isEmpty() ? -1 : stk.peek();
                a = Math.max(a, (i-l) * (h[idx]+1));
            }
            stk.push(i);
        }
        int n = h.length;
        while (!stk.isEmpty()) {
            int idx = stk.pop(), l = stk.isEmpty() ? -1 : stk.peek();
            a = Math.max(a, (n-l) * (h[idx]+1));
        }
        return a;
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
