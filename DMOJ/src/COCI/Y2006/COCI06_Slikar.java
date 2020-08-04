package COCI.Y2006;

import java.util.*;
import java.io.*;

public class COCI06_Slikar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R, C, arr[][], sr, sc;
    static char map[][];

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt(); map = new char[R][C]; arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String in = readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = in.charAt(j);
                if (map[i][j] == 'S') { sr = i; sc = j; map[i][j] = '.'; }
            }
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') bfs(i, j);
            }
        }

        Queue<P> q = new LinkedList<>();
        q.add(new P(sr, sc, 0));
        while (!q.isEmpty()) {
            P p = q.poll();
            if (map[p.r][p.c] == 'D') { System.out.println(p.d); return; }
            if (p.r+1<R && map[p.r+1][p.c]!='X' && p.d + 1 < arr[p.r+1][p.c]) {
                arr[p.r+1][p.c] = p.d + 1; q.add(new P(p.r+1, p.c, p.d + 1));
            } if (p.r-1>=0 && map[p.r-1][p.c]!='X' && p.d + 1 < arr[p.r-1][p.c]) {
                arr[p.r-1][p.c] = p.d + 1; q.add(new P(p.r-1, p.c, p.d + 1));
            } if (p.c+1<C && map[p.r][p.c+1]!='X' && p.d + 1 < arr[p.r][p.c+1]) {
                arr[p.r][p.c+1] = p.d + 1; q.add(new P(p.r, p.c+1, p.d + 1));
            } if (p.c-1>=0 && map[p.r][p.c-1]!='X' && p.d + 1 < arr[p.r][p.c-1]) {
                arr[p.r][p.c-1] = p.d + 1; q.add(new P(p.r, p.c-1, p.d + 1));
            }
        }

        System.out.println("KAKTUS");
    }

    static void bfs(int r, int c) {
        Queue<P> q = new LinkedList<>();
        q.add(new P(r, c, 0));
        arr[r][c] = 0;
        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.r+1<R && map[p.r+1][p.c]=='.' && arr[p.r+1][p.c] > p.d + 1) {
                arr[p.r+1][p.c] = p.d + 1; q.add(new P(p.r+1, p.c, p.d + 1));
            } if (p.r-1>=0 && map[p.r-1][p.c]=='.' && arr[p.r-1][p.c] > p.d + 1) {
                arr[p.r-1][p.c] = p.d + 1; q.add(new P(p.r-1, p.c, p.d + 1));
            } if (p.c+1<C && map[p.r][p.c+1]=='.' && arr[p.r][p.c+1] > p.d + 1) {
                arr[p.r][p.c+1] = p.d + 1; q.add(new P(p.r, p.c+1, p.d + 1));
            } if (p.c-1>=0 && map[p.r][p.c-1]=='.' && arr[p.r][p.c-1] > p.d + 1) {
                arr[p.r][p.c-1] = p.d + 1; q.add(new P(p.r, p.c-1, p.d + 1));
            }
        }
    }

    static class P {
        int r, c, d;
        P (int rr, int cc, int dd) { r = rr; c = cc; d = dd; }
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
