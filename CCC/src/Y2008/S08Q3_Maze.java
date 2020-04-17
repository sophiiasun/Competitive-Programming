package Y2008;

import java.util.*;

public class S08Q3_Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int R = sc.nextInt(); int C = sc.nextInt();
            char[][] map = new char[R][C];
            for (int r = 0; r < R; r++) {
                String in = sc.next();
                for (int c = 0; c < C; c++)
                    map[r][c] = in.charAt(c);
            }

            boolean found = false;

            boolean[][] visited = new boolean[R][C];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 1});
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                if (curr[0] == R-1 && curr[1] == C-1) {
                    System.out.println(curr[2]);
                    found = true;
                    break;
                }
                if (map[curr[0]][curr[1]] == '|' || map[curr[0]][curr[1]] == '+') {
                    if (curr[0]+1 < R && !visited[curr[0]+1][curr[1]] && map[curr[0]+1][curr[1]]!='*') {
                        queue.add(new int[]{curr[0]+1, curr[1], curr[2]+1});
                        visited[curr[0]+1][curr[1]] = true;
                    }
                    if (curr[0]-1 >= 0 && !visited[curr[0]-1][curr[1]] && map[curr[0]-1][curr[1]]!='*') {
                        queue.add(new int[]{curr[0]-1, curr[1], curr[2]+1});
                        visited[curr[0]-1][curr[1]] = true;
                    }
                }
                if (map[curr[0]][curr[1]] == '-' || map[curr[0]][curr[1]] == '+') {
                    if (curr[1]+1 < C && !visited[curr[0]][curr[1]+1] && map[curr[0]][curr[1]+1]!='*') {
                        queue.add(new int[]{curr[0], curr[1]+1, curr[2]+1});
                        visited[curr[0]][curr[1]+1] = true;
                    }
                    if (curr[1]-1 >= 0 && !visited[curr[0]][curr[1]-1] && map[curr[0]][curr[1]-1]!='*') {
                        queue.add(new int[]{curr[0], curr[1]-1, curr[2]+1});
                        visited[curr[0]][curr[1]-1] = true;
                    }
                }
            }
            if (!found)
                System.out.println(-1);
        }
    }
}
