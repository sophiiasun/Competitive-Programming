package WK190831_IC;

import java.util.*;

public class FloorPlan {

    private static Scanner sc = new Scanner(System.in);
    private static int tFloor = sc.nextInt();
    private static int r = sc.nextInt(), c = sc.nextInt();
    private static Queue<int[]> qChg = new LinkedList<>();
    private static ArrayList<Integer> rmCount = new ArrayList<>();
    private static int total = 0;

    public static void main(String[] args) {
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String temp = sc.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = temp.charAt(j);
            }
        }
        int temp = countRooms(grid);
        System.out.println("Total metres: " + total);
        System.out.println(Arrays.toString(rmCount.toArray()));
        System.out.println(temp + " rooms, " + tFloor + " square metre(s) left over.");
    }

    private static int fillRooms() {
        Collections.sort(rmCount, Collections.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < rmCount.size(); i++) {
            if (tFloor - rmCount.get(i) >= 0) {
                tFloor -= rmCount.get(i);
                cnt++;
            }
            if (tFloor - rmCount.get(i) < 0)
                break;
        }
        return cnt;
    }

    private static int countRooms(char[][] grid) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                floodFill(i, j, grid);
            }
        }
        return fillRooms();
    }

    private static void floodFill(int i, int j, char[][] grid) {
        if (grid[i][j] != '.')
            return;
        else {
            int cnt = 1;
            grid[i][j] = 'A';
            qChg.add(new int[]{i, j});
            while (!qChg.isEmpty()) {
                int[] temp = qChg.poll();
                if (temp[0] - 1 >= 0) {
                    if (grid[temp[0] - 1][temp[1]] == '.') {
                        grid[temp[0] - 1][temp[1]] = 'A';
                        qChg.add(new int[]{temp[0] - 1, temp[1]});
                        cnt++;
                        total++;
                    }
                }
                if (temp[0] + 1 < r) {
                    if (grid[temp[0] + 1][temp[1]] == '.') {
                        grid[temp[0] + 1][temp[1]] = 'A';
                        qChg.add(new int[]{temp[0] + 1, temp[1]});
                        cnt++;
                        total++;
                    }
                }
                if (temp[1] + 1 < c) {
                    if (grid[temp[0]][temp[1] + 1] == '.') {
                        grid[temp[0]][temp[1] + 1] = 'A';
                        qChg.add(new int[]{temp[0], temp[1] + 1});
                        cnt++;
                        total++;
                    }
                }
                if (temp[1] - 1 >= 0) {
                    if (grid[temp[0]][temp[1] - 1] == '.') {
                        grid[temp[0]][temp[1] - 1] = 'A';
                        qChg.add(new int[]{temp[0], temp[1] - 1});
                        cnt++;
                        total++;
                    }
                }
            }
            rmCount.add(cnt);
        }
    }
}