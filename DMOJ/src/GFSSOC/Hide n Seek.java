package GFSSOC;

import java.util.*;

public class HideNSeek { //WORKING VERSION

    static int N, M, T;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); T = sc.nextInt();
        arr = new int[N][M];
        int cnt = 1;
        int[] start = new int[3];
        for (int i = 0; i < N; i++) {
            String in = sc.next();
            for (int j = 0; j < M; j++) {
                if (in.charAt(j)==46) arr[i][j] = 0;
                else if (in.charAt(j)==88) arr[i][j] = -1;
                else {
                    arr[i][j] = cnt++;
                    if (in.charAt(j)==71) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
        }
        boolean[] bool = new boolean[T+2];
        bool[arr[start[0]][start[1]]] = true;
        doBFS(start, bool, 0);
        System.out.println(min);
    }

    static void doBFS(int[] curr, boolean[] visited, int distance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(curr);
        boolean[][] vis = new boolean[N][M];
        vis[curr[0]][curr[1]] = true;
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (arr[next[0]][next[1]] > 0 && !visited[arr[next[0]][next[1]]]) {
                visited[arr[next[0]][next[1]]] = true;
                doBFS(next, visited, next[2]);
                visited[arr[next[0]][next[1]]] = false;
            }
            if (next[0] + 1 < N && !vis[next[0] + 1][next[1]] && arr[next[0] + 1][next[1]] >= 0) {
                queue.add(new int[]{next[0] + 1, next[1], next[2]+1});
                vis[next[0] + 1][next[1]] = true;
            }
            if (next[0] - 1 >= 0 && !vis[next[0] - 1][next[1]] && arr[next[0] - 1][next[1]] >= 0) {
                queue.add(new int[]{next[0] - 1, next[1], next[2]+1});
                vis[next[0] - 1][next[1]] = true;
            }
            if (next[1] + 1 < M && !vis[next[0]][next[1] + 1] && arr[next[0]][next[1] + 1] >= 0) {
                queue.add(new int[]{next[0], next[1] + 1, next[2]+1});
                vis[next[0]][next[1] + 1] = true;
            }
            if (next[1] - 1 >= 0 && !vis[next[0]][next[1] - 1] && arr[next[0]][next[1] - 1] >= 0) {
                queue.add(new int[]{next[0], next[1] - 1, next[2]+1});
                vis[next[0]][next[1] - 1] = true;
            }
            boolean tmp = true;
            for (int i = 1; i < T+2; i++) {
                if (!visited[i]) {
                    tmp = false;
                    break;
                }
            }
            if (tmp && distance < min)
                min = distance;
        }
    }
}
