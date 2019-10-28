package S2018;

import java.util.*;

public class Q3 {
    static int N, M;
    static char[][] arr;
    static int[][] data;
    static int[] start;
    static boolean[] loop; //U-D-L-R
    public static void main(String[] args) {
        init();
        run();
        out();
    }
    static void run() {
        Queue<int[]> aQ = new LinkedList<>();
        if (data[start[0]][start[1]] == 0)
            aQ.add(new int[]{start[0], start[1]});
        while(!aQ.isEmpty()) {
            int[] tmp = aQ.poll();
            loop = new boolean[4];
            int[] get = chkSurrounding(tmp[0]-1, tmp[1]);
            if (get != null) {
                data[get[0]][get[1]] = data[tmp[0]][tmp[1]] + 1;
                aQ.add(new int[]{get[0], get[1]});
            }
            loop = new boolean[4];
            get = chkSurrounding(tmp[0]+1, tmp[1]);
            if (get != null) {
                data[get[0]][get[1]] = data[tmp[0]][tmp[1]] + 1;
                aQ.add(new int[]{get[0], get[1]});
            }
            loop = new boolean[4];
            get = chkSurrounding(tmp[0], tmp[1]-1);
            if (get != null) {
                data[get[0]][get[1]] = data[tmp[0]][tmp[1]] + 1;
                aQ.add(new int[]{get[0], get[1]});
            }
            loop = new boolean[4];
            get = chkSurrounding(tmp[0], tmp[1]+1);
            if (get != null) {
                data[get[0]][get[1]] = data[tmp[0]][tmp[1]] + 1;
                aQ.add(new int[]{get[0], get[1]});
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == '.' && data[i][j] == 0)
                    data[i][j] = -1;
            }
        }
    }
    static int[] chkSurrounding(int r, int c) {
        if (r >= N || c >= M || r < 0 || c < 0)
            return null;
        if (arr[r][c] == '.' && data[r][c] == 0)
            return new int[]{r, c};
        if (arr[r][c] == 'U') {
            if (loop[0])
                return null;
            loop[0] = true;
            return chkSurrounding(r-1, c);
        } else if (arr[r][c] == 'D') {
            if (loop[1])
                return null;
            loop[1] = true;
            return chkSurrounding(r+1, c);
        } else if (arr[r][c] == 'L') {
            if (loop[2])
                return null;
            loop[2] = true;
            return chkSurrounding(r, c-1);
        } else if (arr[r][c] == 'R') {
            if (loop[3])
                return null;
            loop[3] = true;
            return chkSurrounding(r, c+1);
        }
        return null;
    }
    static void out() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == start[0] && j == start[1])
                    continue;
                if (data[i][j] != 0)
                    System.out.println(data[i][j]);
            }
        }
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        arr = new char[N][M];
        data = new int[N][M];
        start = new int[2];
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < M; j++) {
                char tmpC = tmp.charAt(j);
                arr[i][j] = tmpC;
                if (tmpC == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'C')
                    camera(i, j);
            }
        }
    }
    static void camera(int R, int C) {
        for(int r = R - 1; r >= 0 && arr[r][C] != 'W'; r--)
            chkCam(r, C);
        for(int r = R + 1; r < N && arr[r][C] != 'W'; r++)
            chkCam(r, C);
        for(int c = C - 1; c >= 0 && arr[R][c] != 'W'; c--)
            chkCam(R, c);
        for(int c = C + 1; c < M && arr[R][c] != 'W'; c++)
            chkCam(R, c);
    }
    static void chkCam(int R, int C) {
        if (arr[R][C] == '.' || arr[R][C] == 'S') {
            arr[R][C] = 'c';
            data[R][C] = -1;
        }
    }
}
