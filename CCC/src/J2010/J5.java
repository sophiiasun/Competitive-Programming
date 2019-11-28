package J2010;

import java.util.*;

public class J5 {
    static Point S, E;
    static Queue<Set<Point>> pQ = new LinkedList<>();
    static Set<Point> set = new HashSet<>();
    static boolean[][] map = new boolean[8][8];
    public static void main(String[] args) {
        init();
        run();
    }
    static void run(){
        set.add(S);
        pQ.add(set);
        int cnt = 0;
        while (!pQ.isEmpty()) {
            cnt++;
            set.clear();
            Set<Point> tmp = pQ.poll();
            for (Point i : tmp) {
                if (i.r == E.r && i.c == E.r) {
                    System.out.println(cnt);
                    return;
                }
                addPoints(i);
            }
            pQ.add(set);
        }
    }
    static void addPoints(Point i){
        if (isValid(i.r - 2, i.c - 1))
            set.add(new Point(i.r - 2, i.c - 1));
        if (isValid(i.r - 2, i.c + 1))
            set.add(new Point(i.r - 2, i.c + 1));
        if (isValid(i.r - 1, i.c + 2))
            set.add(new Point(i.r - 1, i.c + 2));
        if (isValid(i.r + 1, i.c + 2))
            set.add(new Point(i.r + 1, i.c + 2));
        if (isValid(i.r + 2, i.c + 1))
            set.add(new Point(i.r + 2, i.c + 1));
        if (isValid(i.r + 2, i.c - 1))
            set.add(new Point(i.r + 2, i.c - 1));
        if (isValid(i.r + 1, i.c - 2))
            set.add(new Point(i.r + 1, i.c - 2));
        if (isValid(i.r - 1, i.c - 2))
            set.add(new Point(i.r - 1, i.c - 2));
    }
    static boolean isValid(int iR, int iC){
        if (iR >= 0 && iC < 8 && !map[iR][iC]) {
            map[iR][iC] = true;
            return true;
        }
        return false;
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        S = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
        E = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
    }
    static class Point{
        int r;
        int c;
        Point(int pr, int pc){
            r = pc;
            c = pr;
        }
    }
}
