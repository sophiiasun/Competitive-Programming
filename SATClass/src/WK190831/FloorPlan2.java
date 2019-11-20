package WK190831;

import java.util.*;

public class FloorPlan2 {
    static int R, C, F;
    static char[][] grid;
    static Queue<Point> pQ = new LinkedList<>();
    static ArrayList<Integer> size = new ArrayList<>();
    static int counter = 0;
    public static void main(String[] args) {
        init();
        run();
        System.out.println(counter + " rooms, " + F + " square metre(s) left over");
    }
    static void run(){
        for (int r = 0; r < R; r++) {
            for (int c = 0;c < C;c++) {
                if (grid[r][c] == '.')
                    floodFill(r, c);
            }
        }
        countRooms();
    }
    static void countRooms(){
        Collections.sort(size, Collections.reverseOrder());
        for (int i : size) {
            if (F >= i) {
                F -= i;
                counter++;
            }
            else break;
        }
    }
    static void floodFill(int iR, int iC){
        pQ.add(new Point(iR, iC));
        int cnt = 0;
        while (!pQ.isEmpty()) {
            Point p = pQ.poll();
            if (!p.isValid() || grid[p.r][p.c] != '.')
                continue;
            grid[p.r][p.c] = 'A';
            cnt++;
            pQ.add(new Point(p.r + 1, p.c));
            pQ.add(new Point(p.r - 1, p.c));
            pQ.add(new Point(p.r, p.c + 1));
            pQ.add(new Point(p.r, p.c - 1));
        }
        size.add(cnt);
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = sc.next();
            for (int j = 0; j<C ;j++){
                grid[i][j] = tmp.charAt(j);
            }
        }
    }
    static class Point{
        int r;
        int c;
        Point(int pr, int pc) { //p stands for perimeter
            r = pr;
            c = pc;
        }
        boolean isValid() {
            if (r >= 0 && r < R && c >= 0 && c < C)
                return true;
            else
                return false;
        }
    }
}