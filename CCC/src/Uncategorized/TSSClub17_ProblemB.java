package Uncategorized;

import java.util.*;
import java.io.*;

public class TSSClub17_ProblemB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int r = 1414215;

    public static void main(String[] args) throws IOException {
        int N = readInt(), Q = readInt(), a[] = new int[r], x, y, tmp;
        for (int i = 0; i < N; i++) {
            x = readInt(); y = readInt();
            tmp = (int)Math.ceil(Math.sqrt((long)x*x + (long)y*y));
            a[tmp]++;
        }
        for (int i = 1; i < r; i++) {
            a[i] += a[i-1];
        }
        for (int i = 0; i < Q; i++) {
            x = readInt();
            System.out.println(a[x]);
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
}
