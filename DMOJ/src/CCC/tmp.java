package CCC;

import java.util.*;
import java.io.*;

public class tmp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;
    static int N, M, dis[][]; static char a[][];
    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); dis = new int[N+1][M+1];
        int R=0, C=0, r1=0, r2=0, c1=0, c2=0, dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        a = new char[N+1][M+1]; boolean be=false, bs=false;
        for (int i = 1; i <= N; i++) {
            String s = readLine();
            for (int j = 1; j <= M; j++) {
                a[i][j] = s.charAt(j-1);
                if (a[i][j] == 'P') { R = i; C = j; }
                else if (a[i][j] == 'O') { r1 = i; c1 = j; }
                else if (a[i][j] == 'X') { r2 = i; c2 = j; }
            }
        }
        Queue<C> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        q.add(new C(R, C)); dis[R][C] = 0;
        while (!q.isEmpty()) {
            C u = q.poll();
            if (a[u.r][u.c] == 'O') { bs = true; }
            if (a[u.r][u.c] == 'X') { be = true; }
            if (bs && be) break;
            for (int i = 0, r, c; i < 4; i++) {
                r = u.r + dir[i][0]; c = u.c + dir[i][1];
                if (!val(r, c)) continue;
                dis[r][c] = dis[u.r][u.c] + 1;
                q.add(new C(r, c));
            }
        }
        System.out.println(dis[r1][c1] + dis[r2][c2]);
    }

    static boolean val(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= M && a[r][c] != '#' && dis[r][c] == Integer.MAX_VALUE;
    }

    static class C {
        int r, c;
        C (int n, int m) { r = n; c = m; }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}

