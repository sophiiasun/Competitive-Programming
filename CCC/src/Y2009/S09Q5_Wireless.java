package Y2009;

import java.util.*;

public class S09Q5_Wireless {
    static int N, M, K;
    static int[][] difA;
    static Point[] loc;
    public static void main(String[] args) {
        init();
        run();
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
    static void run(){
        for (int i = 0; i < loc.length; i++) {
            checkArea(loc[i]);
        }
    }
    static void checkArea(Point P) {
        int dis; int C;
        for (int i = 0; i <= P.rad; i++) { //i is for r
            if (i == 0) {//diameter
                dis = P.rad;
            }
            else if (i == P.rad)
                dis = 0;
            else //check distance using pythagorean theorum
                dis = (int)Math.floor(Math.sqrt(P.rad * P.rad - i*i)); //distance from c
            C = P.c - dis;
            if (P.c - dis < 0) C = 0;
            if (P.r + i < N) {
                difA[P.r + i][C] += P.bit; //row below
                if (P.c + dis + 1 < M)
                    difA[P.r + i][P.c + dis + 1] -= P.bit;
            }
            if (i == 0) continue;
            if (P.r - i >= 0) {
                difA[P.r - i][C] += P.bit; //row above
                if (P.c + dis + 1 < M)
                    difA[P.r - i][P.c + dis + 1] -= P.bit;
            }
        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        loc = new Point[K];
        for (int i = 0; i < K; i++) {
            int tmpR = sc.nextInt() - 1, tmpC = sc.nextInt() - 1;
            loc[i] = new Point(tmpC, tmpR, sc.nextInt(), sc.nextInt());
        }
        difA = new int[N][M];
    }
    static class Point{
        int r; int c;
        int rad; int bit;
        Point(int pr, int pc, int prad, int pbit){
            r = pr; c = pc;
            rad = prad; bit = pbit;
        }
    }
}
