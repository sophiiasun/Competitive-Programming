package CCC.Y2009;

import java.util.*;
import java.io.*;

public class S09Q5_Wireless {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, K, difA[][];
    static Point[] loc;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); K = readInt(); loc = new Point[K];
        int a, b;
        for (int i = 0; i < K; i++) {
            a = readInt(); b = readInt();
            loc[i] = new Point(b - 1,  a - 1, readInt(), readInt());
        }
        difA = new int[N][M];
        for (int i = 0; i < K; i++) {
            checkArea(loc[i]);
        }
        int max = 0; int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0)
                    difA[i][j] += difA[i][j-1];
                if (difA[i][j] > max) {
                    max = difA[i][j];
                    cnt = 1;
                } else if (difA[i][j] == max)
                    cnt++;
            }
        }
        System.out.println(max);
        System.out.println(cnt);
    }

    static void checkArea(Point P) {
        int dis; int C;
        for (int i = 0; i <= P.rad; i++) { //i is for r
            if (i == 0) dis = P.rad; // diameter
            else if (i == P.rad) dis = 0;
            else dis = (int) Math.floor(Math.sqrt(P.rad * P.rad - i*i)); //distance from c (pythagorean theorum)
            C = P.c - dis;
            if (P.c - dis < 0) C = 0;
            if (P.r + i < N) { //row below
                difA[P.r + i][C] += P.bit;
                if (P.c + dis + 1 < M) difA[P.r + i][P.c + dis + 1] -= P.bit;
            }
            if (i == 0) continue;
            if (P.r - i >= 0) { //row above
                difA[P.r - i][C] += P.bit;
                if (P.c + dis + 1 < M) difA[P.r - i][P.c + dis + 1] -= P.bit;
            }
        }
    }

    static class Point{
        int r; int c;
        int rad; int bit;
        Point(int pr, int pc, int prad, int pbit){
            r = pr; c = pc;
            rad = prad; bit = pbit;
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
