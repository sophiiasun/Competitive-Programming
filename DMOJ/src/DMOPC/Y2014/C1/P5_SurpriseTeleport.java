package DMOPC.Y2014.C1;

import java.util.*;

public class P5_SurpriseTeleport {
    static int endR, endC;
    static char[][] arr;
    static int portal = Integer.MAX_VALUE, office = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        int startR = sc.nextInt(), startC = sc.nextInt();
        endR = sc.nextInt(); endC = sc.nextInt();
        arr = new char[R][C];
        String in;
        for (int i = 0; i < R; i++) {
            in = sc.next();
            for (int j = 0; j < C; j++)
                arr[i][j] = in.charAt(j);
        }
        int T = sc.nextInt();
        for (int i = 0; i < T; i++)
            arr[sc.nextInt()][sc.nextInt()] = 'P';

        boolean[] found = new boolean[2]; //portal, office
        boolean[][] vis = new boolean[R][C];
        vis[startR][startC] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (arr[r][c] == 'P' && portal == Integer.MAX_VALUE) {
                portal = curr[2];
                found[0] = true;
            } else if (curr[0] == endR && curr[1] == endC && office == Integer.MAX_VALUE) {
                office = curr[2];
                found[1] = true;
            }
            if (found[0] && found[1])
                break;
            if (r+1<R && !vis[r+1][c] && arr[r+1][c]!='X') {
                queue.add(new int[]{r+1, c, curr[2]+1});
                vis[r+1][c] = true;
            }
            if (r-1>=0 && !vis[r-1][c] && arr[r-1][c]!='X') {
                queue.add(new int[]{r-1, c, curr[2]+1});
                vis[r-1][c] = true;
            }
            if (c+1<C && !vis[r][c+1] && arr[r][c+1]!='X') {
                queue.add(new int[]{r, c+1, curr[2]+1});
                vis[r][c+1] = true;
            }
            if (c-1>=0 && !vis[r][c-1] && arr[r][c-1]!='X') {
                queue.add(new int[]{r, c-1, curr[2]+1});
                vis[r][c-1] = true;
            }
        }

        if (office-portal >= 0 && office != Integer.MAX_VALUE && portal != Integer.MAX_VALUE)
            System.out.println(office-portal);
        else
            System.out.println(0);
    }


}
