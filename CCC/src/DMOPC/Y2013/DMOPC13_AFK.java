package DMOPC.Y2013;

import java.util.*;

public class DMOPC13_AFK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int C = sc.nextInt(), R = sc.nextInt();
            char[][] arr = new char[R][C];
            int startR = 0, startC = 0;
            for (int i = 0; i < R; i++) {
                String in = sc.next();
                for (int j = 0; j < C; j++) {
                    arr[i][j] = in.charAt(j);
                    if (arr[i][j] == 'C') {
                        startR = i; startC = j;
                    }
                }
            }

            System.out.println(doBFS(arr, startR, startC, R, C));
        }
    }

    static String doBFS(char[][] arr, int startR, int startC, int R, int C){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];
        vis[startR][startC] = true;
        queue.add(new int[]{startR, startC, 0});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (arr[r][c]=='W')
                return Integer.toString(curr[2]);
            if (curr[2] < 59) {
                if (r + 1 < R && !vis[r + 1][c] && arr[r + 1][c] != 'X') {
                    queue.add(new int[]{r + 1, c, curr[2] + 1});
                    vis[r + 1][c] = true;
                }
                if (r - 1 >= 0 && !vis[r - 1][c] && arr[r - 1][c] != 'X') {
                    queue.add(new int[]{r - 1, c, curr[2] + 1});
                    vis[r - 1][c] = true;
                }
                if (c + 1 < C && !vis[r][c + 1] && arr[r][c + 1] != 'X') {
                    queue.add(new int[]{r, c + 1, curr[2] + 1});
                    vis[r][c + 1] = true;
                }
                if (c - 1 >= 0 && !vis[r][c - 1] && arr[r][c - 1] != 'X') {
                    queue.add(new int[]{r, c - 1, curr[2] + 1});
                    vis[r][c - 1] = true;
                }
            }
        }
        return "#notworth";
    }
}
