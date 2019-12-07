package J2010;

import java.util.*;

public class J5 {
    static int Xs, Ys, Xe, Ye;
    static int[] addX = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] addY = {-1, 1, 2, 2, 1, -1, -2, -2};
    static Queue<int[]> aQ;
    public static void main(String[] args) {
        init();
    }
    static void run(){
        int counter = 1;
        aQ = new LinkedList<>();
        aQ.add(new int[]{Xs, Ys});
        while (!aQ.isEmpty()) {
            int[] next = aQ.poll();
            for (int i = 0; i < 8; i++) {
                updateVal(next[0] + addX[i], next[1] + addY[i], counter);
            }
        }
    }
    static void updateVal(int iX, int iY, int iC){
        if (iX >= 0 && iX < 8 && iY>=0 && iY<8) {
            if (iX == Xe && iY == Ye) {
                System.out.println(iC);
            } else {
                aQ.add(new int[]{iX, iY});
            }
        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        Xs = sc.nextInt() - 1; Ys = sc.nextInt() - 1;
        Xe = sc.nextInt() - 1; Ye = sc.nextInt() - 1;
    }
}
