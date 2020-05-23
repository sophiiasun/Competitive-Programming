package DMOPC;

import java.util.*;

public class DMOPC13_CrossingFIeld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[N][N];
        vis[0][0] = true;
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == N-1 && curr[1] == N-1) {
                System.out.println("yes"); System.exit(0);
            }
            int r = curr[0], c = curr[1];
            if (r + 1 < N && !vis[r+1][c] && Math.abs(arr[r+1][c]-arr[r][c]) <= H) {
                vis[r+1][c] = true;
                queue.add(new int[]{r+1, c});
            }
            if (r - 1 >= 0 && !vis[r-1][c] && Math.abs(arr[r-1][c]-arr[r][c]) <= H) {
                vis[r-1][c] = true;
                queue.add(new int[]{r-1, c});
            }
            if (c + 1 < N && !vis[r][c+1] && Math.abs(arr[r][c+1]-arr[r][c]) <= H) {
                vis[r][c+1] = true;
                queue.add(new int[]{r, c+1});
            }
            if (c - 1 >= 0 && !vis[r][c-1] && Math.abs(arr[r][c-1]-arr[r][c]) <= H) {
                vis[r][c-1] = true;
                queue.add(new int[]{r, c-1});
            }
        }
        System.out.println("no");
    }
}
