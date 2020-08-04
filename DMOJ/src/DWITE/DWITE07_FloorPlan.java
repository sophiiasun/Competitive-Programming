package DWITE;

import java.util.*;

public class DWITE07_FloorPlan {

    static int R, C;
    static int[][] arr;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); C = sc.nextInt();
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String in = sc.next();
            for (int j = 0; j < C; j++)
                arr[i][j] = in.charAt(j);
        }

        out = new int[6];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '#') {
                    queue.clear();
                    doBFS(i, j);
                }
            }
        }
        for (int i = 1; i <= 5; i++)
            System.out.println(out[i]);
    }

    static void doBFS(int inR, int inC){ //48
        queue.add(new int[]{inR, inC});
        int counter = 1;
        int val = 0;
        if (arr[inR][inC]>48 && arr[inR][inC]<54)
            val = arr[inR][inC] - 48;
        arr[inR][inC] = '#';
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r+1<R && arr[r+1][c]!='#') {
                counter++;
                queue.add(new int[]{r+1, c});
                if (arr[r+1][c] > 48 && arr[r+1][c] < 54)
                    val = arr[r+1][c] - 48;
                arr[r+1][c] = '#';
            }
            if (r-1>=0 && arr[r-1][c]!='#') {
                counter++;
                queue.add(new int[]{r-1, c});
                if (arr[r-1][c] > 48 && arr[r-1][c] < 54)
                    val = arr[r-1][c] - 48;
                arr[r-1][c] = '#';
            }
            if (c+1<C && arr[r][c+1]!='#') {
                counter++;
                queue.add(new int[]{r, c+1});
                if (arr[r][c+1] > 48 && arr[r][c+1] < 54)
                    val = arr[r][c+1] - 48;
                arr[r][c+1] = '#';
            }
            if (c-1>=0 && arr[r][c-1]!='#') {
                counter++;
                queue.add(new int[]{r, c-1});
                if (arr[r][c-1] > 48 && arr[r][c-1] < 54)
                    val = arr[r][c-1] - 48;
                arr[r][c-1] = '#';
            }
        }
        out[val] = counter;
    }
}
