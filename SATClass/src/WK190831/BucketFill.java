package WK190831;

import java.util.*;

public class        BucketFill {

    static private Queue<int[]> qChg = new LinkedList<>();
    static private Scanner sc = new Scanner(System.in);
    static private int r = sc.nextInt();
    static private int c = sc.nextInt();
    static private int rS = sc.nextInt();
    static private int cS = sc.nextInt();

    public static void main(String[] args) {
        char newC = sc.next().charAt(0);
        char[][] grid = new char[r][c];
        sc.nextLine();
        for(int i = 0; i < r; i++) {
            String temp = sc.nextLine();
            for(int j = 0; j < c; j++)
                grid[i][j] = temp.charAt(j);
            System.out.println(Arrays.toString(grid[i]));
        }
        floodFill(rS, cS, grid[rS][cS], newC, grid);
        System.out.println("==============================================");
        for(int i = 0; i < r; i++) {
            String out = Arrays.toString(grid[i]);
            System.out.println(out);
        }
    }

    private static void floodFill(int iR, int iC, char oldC, char newC, char[][] grid) {
        if (grid[iR][iC] != oldC)
            return;
        else {
            qChg.add(new int[]{rS, cS});
            while (!qChg.isEmpty()) {
                int[] temp = qChg.poll();
                if(temp[0] - 1 >= 0) {
                    if (grid[temp[0] - 1][temp[1]] == oldC) {
                        grid[temp[0] - 1][temp[1]] = newC;
                        qChg.add(new int[]{temp[0] - 1, temp[1]});
                    }
                }
                if(temp[0] + 1 < r) {
                    if (grid[temp[0] + 1][temp[1]] == oldC) {
                        grid[temp[0] + 1][temp[1]] = newC;
                        qChg.add(new int[]{temp[0] + 1, temp[1]});
                    }
                }
                if(temp[1] - 1 >= 0) {
                    if (grid[temp[0]][temp[1] - 1] == oldC) {
                        grid[temp[0]][temp[1] - 1] = newC;
                        qChg.add(new int[]{temp[0], temp[1] - 1});
                    }
                }
                if(temp[1] + 1 < c) {
                    if (grid[temp[0]][temp[1] + 1] == oldC) {
                        grid[temp[0]][temp[1] + 1] = newC;
                        qChg.add(new int[]{temp[0], temp[1] + 1});
                    }
                }
            }
        }
    }
}
