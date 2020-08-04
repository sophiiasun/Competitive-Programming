package WK190831;

import java.util.*;

public class TheMaze {

    private static Scanner sc = new Scanner(System.in);
    private static int R = sc.nextInt(), C = sc.nextInt();

    public static void main(String[] args) {
        char[][] grid = new char[R][C];
        int[] S = new int[2];
        int[] E = new int[2];
        for(int i = 0; i < R; i++) {
            String get = sc.next();
            for(int j = 0; j < C; j++) {
                grid[i][j] = get.charAt(j);
                if(grid[i][j] == 'S') {
                    S[0] = i;
                    S[1] = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'E') {
                    E[0] = i;
                    E[1] = j;
                    grid[i][j] = '.';
                }
            }
        }

        for(int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println(floodFill(S[0], S[1], E, grid));

    }

    private static boolean floodFill(int r, int c, int[] E, char[][] grid) {
        if (grid[r][c] != '.')
            return false;
        else {
            Queue<int[]> qFill = new LinkedList<>();
            qFill.add(new int[]{r, c});
            grid[r][c] = 'A';
            while (!qFill.isEmpty()) {
                int[] temp = qFill.poll();
                if (temp[0] + 1 < R) {
                    if (grid[temp[0] + 1][temp[1]] == '.') {
                        grid[temp[0] + 1][temp[1]] = 'A';
                        qFill.add(new int[]{temp[0] + 1, temp[1]});
                    }
                }
                if (temp[0] - 1 >= 0) {
                    if (grid[temp[0] - 1][temp[1]] == '.') {
                        grid[temp[0] - 1][temp[1]] = 'A';
                        qFill.add(new int[]{temp[0] - 1, temp[1]});
                    }
                }
                if (temp[1] + 1 < C) {
                    if (grid[temp[0]][temp[1] + 1] == '.') {
                        grid[temp[0]][temp[1] + 1] = 'A';
                        qFill.add(new int[]{temp[0], temp[1] + 1});
                    }
                }
                if (temp[1] - 1 >= 0) {
                    if (grid[temp[0]][temp[1] - 1] == '.') {
                        grid[temp[0]][temp[1] - 1] = 'A';
                        qFill.add(new int[]{temp[0], temp[1] - 1});
                    }
                }
            }
            if (E[0] + 1 < R) {
                return grid[E[0] + 1][E[1]] == 'A';
            } else if (E[0] - 1 >= 0) {
                return grid[E[0] - 1][E[1]] == 'A';
            } else if (E[1] + 1 < C) {
                return grid[E[0]][E[1] + 1] == 'A';
            } else if (E[1] - 1 >= 0) {
                return grid[E[0]][E[1] - 1] == 'A';
            }
        }
        return false;
    }
}
