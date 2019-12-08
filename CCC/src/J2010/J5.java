package J2010;

import java.util.*;

public class J5 {
    static int Xs, Ys, Xe, Ye;
    static int[] addX = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] addY = {-1, 1, 2, 2, 1, -1, -2, -2};
    static Queue<ArrayList<int[]>> aQ;
    static int[][] map = new int[8][8];
    public static void main(String[] args) {
        init();
        if (Xs == Xe && Ys == Ye)
            System.out.println(0);
        else
            run();
    }
    static void run(){
        int counter = 1;
        aQ = new LinkedList<>();
        ArrayList<int[]> add = new ArrayList<>();
        add.add(new int[]{Xs, Ys});
        aQ.add(add);
        while (!aQ.isEmpty()) {
            add = new ArrayList<>();
            ArrayList<int[]> next = aQ.poll();
            for (int[] arr : next) {
                for (int i = 0; i < 8; i++)
                    updateVal(arr[0] + addX[i], arr[1] + addY[i], counter, add);
            }
            counter++;
            aQ.add(add);
        }
    }
    static void updateVal(int iX, int iY, int iC, ArrayList<int[]> add){
        if (iX >= 0 && iX < 8 && iY>=0 && iY<8) {
            if (iX == Xe && iY == Ye) {
                System.out.println(iC);
                System.exit(0);
            }
            else if (map[iX][iY]  == 0) {
                add.add(new int[]{iX, iY});
                map[iX][iY] = iC;
            }
        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        Xs = sc.nextInt() - 1; Ys = sc.nextInt() - 1;
        Xe = sc.nextInt() - 1; Ye = sc.nextInt() - 1;
        map[Xs][Ys] = -1;
    }
}
