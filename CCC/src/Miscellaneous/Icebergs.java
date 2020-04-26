package Miscellaneous;

import java.util.*;

public class Icebergs {

    static Queue<int[]> queue;
    static boolean[][] vis;
    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        int bR = sc.nextInt(), bC = sc.nextInt();
        map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String in = sc.next();
            for (int j = 0; j < C; j++)
                map[i][j] = in.charAt(j) == '.';
        }
        for (int i = 0; i < bR; i++) {
            for (int j = 0; j < bC; j++) {
                if (!map[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        queue = new LinkedList<>();
        vis = new boolean[R][C];
        vis[bR-1][bC-1] = true;
        queue.add(new int[]{bR-1, bC-1, 0}); // r, c, distance
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == R-1 && curr[1] == C-1) {
                System.out.println(curr[2]);
                System.exit(0);
            }
            int r = curr[0], c = curr[1];
            if (r+1<R && map[r+1][c] && !vis[r+1][c]) {
                int tmpR = r+1; boolean pass = true;
                for (int i = c; i > c - bC && i>=0; i--) {
                    if (!map[tmpR][i]) {
                        pass = false; vis[tmpR][i] = true; break; } }
                if (pass) queue.add(new int[]{tmpR, c, curr[2]+1});
            }
            if (r-bR>=0 && map[r-bR][c] && !vis[r-1][c]) {
                int tmpR = r-bR; boolean pass = true;
                for (int i = c; i > c - bC && i>=0; i--) {
                    if (!map[tmpR][i]) {
                        pass = false; vis[tmpR][i] = true; break; } }
                if (pass) queue.add(new int[]{tmpR, c, curr[2]+1});
            }
            if (c+1<C && map[r][c+1] && !vis[r][c+1]) {
                int tmpC = c+1; boolean pass = true;
                for (int i = r; i > r-bR && i>=0; i--) {
                    if (!map[i][tmpC]) {
                        pass = false; vis[i][tmpC] = true; break; } }
                if (pass) queue.add(new int[]{r, tmpC, curr[2]+1});
            }
            if (c-bC>=0 && map[r][c-bC] && !vis[r][c-1]) {
                int tmpC = c-bC; boolean pass = true;
                for (int i = r; i > r-bR && i>=0; i--) {
                    if (!map[i][tmpC]) {
                        pass = false; vis[i][tmpC] = true; break; } }
                if (pass) queue.add(new int[]{r, tmpC, curr[2]+1});
            }
        }
        System.out.println(-1);
    }

}
