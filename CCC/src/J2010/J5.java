package J2010;

import java.util.*;

public class J5 {
    static int XS, YS, XE, YE;
    static int[] addX = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] addY = {-1, 1, 2, 2, 1, -1, -2, -2};
    static Queue<ArrayList<int[]>> q;
    static int[][] map = new int[8][8];

    public static void main(String[] args) {
        init();
        if (XS == XE && YS == YE)
            System.out.println(0);
        else
            run();
    }

    static void run(){
        int counter = 1;
        q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{XS, YS});
        q.add(list);
        while (!q.isEmpty()) {
            list = new ArrayList<>();
            ArrayList<int[]> next = q.poll();
            for (int[] arr : next) {
                for (int i = 0; i < 8; i++)
                    updateVal(arr[0] + addX[i], arr[1] + addY[i], counter, list);
            }
            counter++;
            q.add(list);
        }
    }

    static void updateVal(int iX, int iY, int iC, ArrayList<int[]> add){
        if (iX >= 0 && iX < 8 && iY>=0 && iY<8) {
            if (iX == XE && iY == YE) {
                System.out.println(iC);
                System.exit(0);
            } else if (map[iX][iY]  == 0) {
                add.add(new int[]{iX, iY});
                map[iX][iY] = iC;
            }
        }
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        XS = sc.nextInt() - 1;
        YS = sc.nextInt() - 1;
        XE = sc.nextInt() - 1;
        YE = sc.nextInt() - 1;
        map[XS][YS] = -1;
    }
}
