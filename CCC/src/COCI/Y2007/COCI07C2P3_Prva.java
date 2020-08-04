package COCI.Y2007;

import java.util.*;
import java.io.*;

public class COCI07C2P3_Prva {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M;
    static char[][] a;
    static String ans="zzzzzzzzzzzzzzzzzzzz";

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); a = new char[N][];
        for (int i = 0; i < N; i++) a[i] = readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == '#') continue;
                if (val(i+1, j) && !val(i-1, j)) run(i, j, 1, 0);
//                else if (val(i-1, j) && !val(i+1, j)) run(i, j, -1, 0);
                if (val(i, j+1) && !val(i, j-1)) run(i, j, 0, 1);
//                else if (val(i, j-1) && !val(i, j+1)) run(i, j, 0, -1);
            }
        }
        System.out.println(ans);
    }

    static void run (int r, int c, int x, int y) {
        String tmp = "" + (char)a[r][c];
        while (val(r+=x, c+=y)) { tmp += (char)a[r][c]; }
        if (comp(tmp, ans)) ans = tmp;
    }

    static boolean comp (String a, String b) {
//        String a = x.length() < y.length() ? x : y;
//        String b = x.length() < y.length() ? y : x;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) < b.charAt(i)) return true;
            else if (a.charAt(i) > b.charAt(i)) return false;
        }
        return a.length() < b.length();
    }

    static boolean val(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && a[r][c] != '#';
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
