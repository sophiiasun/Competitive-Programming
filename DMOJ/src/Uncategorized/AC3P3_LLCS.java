package Uncategorized;

// Lexicographical Largest Common Subsequence

import java.util.*;
import java.io.*;

public class AC3P3_LLCS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(); char[] a = readLine().toCharArray(), b = readLine().toCharArray();
        int al = a.length, bl = b.length, dp[][] = new int[2][bl+1], pos = 0; // a as row, b as col
        for (int i = 1; i <= al; i++, pos^=1) {
            int tmp = pos^1;
            for (int j = 1; j <= bl; j++) {
//                if (a[i] == b[j])
            }
        }
        Stack<Character> stk = new Stack<>();
        while (true) {

        }
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
