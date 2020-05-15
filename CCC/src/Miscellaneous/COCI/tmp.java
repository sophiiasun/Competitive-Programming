package Miscellaneous.COCI;

import java.util.*;
import java.io.*;

public class tmp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R, C;
    static char[][] map; static int[][] arr; static boolean[][] vis;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt();
        map = new char[R][C]; arr = new int[R][C]; vis = new boolean[R][C];
        String in; int[] start = new int[2];
        for (int i = 0; i < R; i++) {
            in = next(); Arrays.fill(arr[i], Integer.MAX_VALUE);
            for (int j = 0; j < C; j++) {
                map[i][j] = in.charAt(j);
                if (map[i][j] == '*') {
                    queue.add(new int[]{i, j}); vis[i][j] = true; arr[i][j] = 0;
                } else if (map[i][j] == 'S') {
                    start[0] = i; start[1] = j;
                }
            }
        }
        doBFS();
        queue.clear(); queue.add(new int[]{start[0], start[1], 0});
        for (int i = 0; i < R; i++) Arrays.fill(vis[i], false);
        vis[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (map[r][c] == 'D') {
                System.out.println(curr[2]); System.exit(0);
            }
            if (r-1>=0 && !vis[r-1][c] && curr[2]+1<arr[r-1][c] && map[r-1][c]!='X') {
                queue.add(new int[]{r-1, c, curr[2]+1}); vis[r-1][c] = true;
            } if (r+1<R && !vis[r+1][c] && curr[2]+1<arr[r+1][c] && map[r+1][c]!='X') {
                queue.add(new int[]{r+1, c, curr[2]+1}); vis[r+1][c] = true;
            } if (c-1>=0 && !vis[r][c-1] && curr[2]+1<arr[r][c-1] && map[r][c-1]!='X') {
                queue.add(new int[]{r, c-1, curr[2]+1}); vis[r][c-1] = true;
            } if (c+1<C && !vis[r][c+1] && curr[2]+1<arr[r][c+1] && map[r][c+1]!='X') {
                queue.add(new int[]{r, c+1, curr[2]+1}); vis[r][c+1] = true;
            }
        }
        System.out.println("KAKTUS");
    }

    static void doBFS() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r-1>=0 && !vis[r-1][c] && map[r-1][c]!='X' && map[r-1][c]!='D') {
                arr[r - 1][c] = Math.min(arr[r - 1][c], arr[r][c] + 1);
                queue.add(new int[]{r-1, c}); vis[r-1][c] = true;
            } if (r+1<R && !vis[r+1][c] && map[r+1][c]!='X' && map[r+1][c]!='D') {
                arr[r + 1][c] = Math.min(arr[r + 1][c], arr[r][c] + 1);
                queue.add(new int[]{r+1, c}); vis[r+1][c] = true;
            } if (c-1>=0 && !vis[r][c-1] && map[r][c-1]!='X' && map[r][c-1]!='D') {
                arr[r][c - 1] = Math.min(arr[r][c - 1], arr[r][c] + 1);
                queue.add(new int[]{r, c-1}); vis[r][c-1] = true;
            } if (c+1<C && !vis[r][c+1] && map[r][c+1]!='X' && map[r][c+1]!='D') {
                arr[r][c + 1] = Math.min(arr[r][c + 1], arr[r][c] + 1);
                queue.add(new int[]{r, c+1}); vis[r][c+1] = true;
            }
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
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
