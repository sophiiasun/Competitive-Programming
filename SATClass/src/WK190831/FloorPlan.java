package WK190831;

import java.util.*;

public class FloorPlan {
    static Scanner sc = new Scanner(System.in);
    static int tFloor = sc.nextInt();
    static int r = sc.nextInt(), c = sc.nextInt();
    static Queue<int[]> qChg = new LinkedList<>();
    static ArrayList<Integer> rmCount = new ArrayList<>();
    static char[][] grid;

    public static void main(String[] args) {
        grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            String temp = sc.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = temp.charAt(j);
            }
        }
        int temp = countRooms();
        System.out.print(temp + " rooms, " + tFloor + " square metre(s) left over");
    }
    static int fillRooms() {
        Collections.sort(rmCount, Collections.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < rmCount.size(); i++) {
            if (tFloor >= rmCount.get(i)) {
                tFloor -= rmCount.get(i);
                cnt++;
            } else break;
        }
        return cnt;
    }
    static int countRooms() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                floodFill(i, j);
            }
        }
        return fillRooms();
    }
    static void floodFill(int i, int j) {
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
                    }
                }
                if (temp[0] + 1 < r) {
                    if (grid[temp[0] + 1][temp[1]] == '.') {
                        grid[temp[0] + 1][temp[1]] = 'A';
                        qChg.add(new int[]{temp[0] + 1, temp[1]});
                        cnt++;
                    }
                }
                if (temp[1] + 1 < c) {
                    if (grid[temp[0]][temp[1] + 1] == '.') {
                        grid[temp[0]][temp[1] + 1] = 'A';
                        qChg.add(new int[]{temp[0], temp[1] + 1});
                        cnt++;
                    }
                }
                if (temp[1] - 1 >= 0) {
                    if (grid[temp[0]][temp[1] - 1] == '.') {
                        grid[temp[0]][temp[1] - 1] = 'A';
                        qChg.add(new int[]{temp[0], temp[1] - 1});
                        cnt++;
                    }
                }
            }
            rmCount.add(cnt);
        }
    }
}