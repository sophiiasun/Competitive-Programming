package CCO.Y2012;

import java.util.*;
import java.io.*;

public class P3_MhocskianLanguages {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R1, R2;
    static boolean[][] r1 = new boolean[26][26];
    static ArrayList<C>[] r2 = new ArrayList[26];
    static int dp[][][];
    static String str;

    public static void main(String[] args) throws IOException {
        int V = readInt(), T = readInt(), Q;
        char v[] = new char[V], t[] = new char[T];
        for (int i = 0; i < V; i++) v[i] = readCharacter();
        for (int i = 0; i < T; i++) t[i] = readCharacter();
        R1 = readInt();
        for (int i = 0; i < R1; i++) r1[readCharacter()-'A'][readCharacter()-'a'] = true;
        R2 = readInt();
        for (int i = 0; i < 26; i++) r2[i] = new ArrayList<>();
        for (int i = 0; i < R2; i++) r2[readCharacter()-'A'].add(new C(readCharacter()-'A', readCharacter()-'A'));
        Q = readInt();
        dp = new int[31][31][27];
        for (int q = 0; q < Q; q++) {
            str = "." + readLine();
            fill();
            System.out.println((run(1, str.length()-1, v[0]-'A')) ? 1 : 0);
        }
    }

    static void fill() {
        for (int i = 0; i < 31; i++) { for (int j = 0; j < 31; j++) Arrays.fill(dp[i][j], -1); }
    }

    static boolean run (int pf, int pb, int cur) {
        if (pf == pb) return r1[str.charAt(pf)-'a'][cur];
        if (dp[pf][pb][cur] != -1) return dp[pf][pb][cur] == 1;
        for (int i = pf; i < pb; i++) {
            for (C j : r2[cur]) {
                if (run(pf, i, j.a) && run(i+1, pb, j.b)) { dp[pf][pb][cur] = 1; return true; }
            }
        }
        dp[pf][pb][cur] = 0;
        return false;
    }

    static class C {
        int a, b;
        C (int aa, int bb) { a = aa; b = bb; }
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
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
}
