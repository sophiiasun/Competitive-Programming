package WK190615;

import java.util.*;

public class MoocastDSU {

    public static Scanner sc = new Scanner(System.in);
    public static int N = sc.nextInt();
    public static int[][] cord = new int[N][2];
    public static int[] pow;
    public static LinkedList<int[]> link;
    public static int[] aParent = new int[N];
    public static int[] aSize = new int[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            cord[i][0] = sc.nextInt();
            cord[i][1] = sc.nextInt();
            pow[i] = sc.nextInt();
        }
        link = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            for (int j =0 ;j < N; j++) {
                if (j == i) continue;
                if (getDis(cord[i][0], cord[i][1], cord[j][0], cord[j][1]) <= pow[i]) {
                    link.add(new int[] {i, j});
                }
            }
        }


    }

    public static void doDSU(){
        int iComp = aParent.length;
        for (int i = 0; i<aParent.length; i++) {
            aParent[i] = i;
            aSize[i] = 1;
        }
        for(int i = 0; i<link.size(); i++) {
            mergeSets(link.get(i)[0], link.get(i)[1]);
        }
    }

    public static void mergeSets(int A, int B) {
        if(aParent[A] != aParent[B]) {
            int Ap = aParent[A], Bp = aParent[B];
            aSize[Bp] += aSize[Ap];
            aSize[Ap] = 0;
            for (int i = 0; i<N; i++) {
                if(aParent[i] == Ap) {
                    aParent[i] = aParent[B];
                }
            }
        }
    }

    static boolean isConnected() {
        boolean cnct = true;
        int par = aParent[0];
        for(int i = 0; i<N; i++) {
            if(par!=aParent[i]) {
                cnct = false;
                break;
            }
        }
        return cnct;
    }

    static double getDis(int X1, int Y1, int X2, int Y2) {
        double Dis = Math.sqrt(Math.pow((Y2 - Y1), 2) + Math.pow((X2 - X1), 2));
        return Dis;
    }

}
