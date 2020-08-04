package COCI.Y2008;

import java.util.*;
import java.io.*;

public class COCI08C3P6_Najkraci {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, mod = (int)1e9+7;
    static long cnt[];
    static ArrayList<C> adj[];

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); cnt = new long[M+1];
    }

    static class C{
        int a, b, c;
        C(int aa, int bb, int cc) { a = aa; b = bb; c = cc; }
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
