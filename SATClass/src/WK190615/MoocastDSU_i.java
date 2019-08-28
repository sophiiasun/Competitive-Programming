package WK190615;

import java.util.*;

public class MoocastDSU_i {

    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt();
    private static int[][] cord = new int[N][2];
    private static int[] pow;
    private static LinkedList<int[]> link;
    private static int[] aParent = new int[N];
    private static int[] aSize = new int[N];

    public static void main(String[] args) {
        link = new LinkedList<>();
        pow = new int[N];
        for (int i = 0; i < N; i++) {
            cord[i][0] = sc.nextInt();
            cord[i][1] = sc.nextInt();
            pow[i] = sc.nextInt();
        }
        for(int i = 0; i<N; i++) {
            for (int j =0 ;j < N; j++) {
                if (j == i) continue;
                double Dis = getDis(cord[i][0], cord[i][1], cord[j][0], cord[j][1]);
                if (Dis <= pow[i]) link.add(new int[] {i, j});
                if (Dis <= pow[j]) link.add(new int[] {j, i});
            }
        }

        doDSU();

        int max = 0, temp;
        for(int i = 0; i<N; i++) {
            temp = cntParent();
            if(temp > max) max = temp;
        }

        System.out.println(max);
    }

    public static void doDSU(){
        for (int i = 0; i<aParent.length; i++) {
            aParent[i] = i;
        }
        for(int i = 0; i < link.size(); i++) {
            mergeSets(link.get(i)[0], link.get(i)[1]);
        }
    }

    public static int cntParent(){
        int cnt = 0, marker = 0, temp;
        for(int i = 0; i<aParent.length; i++) {
            temp = aParent[i];
            if(temp != marker) marker = temp;
            for (int j = 0; j < aParent.length; j++) {
                if(aParent[j] == marker) cnt++;
            }
        }
        return cnt;
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

    static double getDis(int X1, int Y1, int X2, int Y2) {
        double Dis = Math.sqrt(Math.pow((Y2 - Y1), 2) + Math.pow((X2 - X1), 2));
        return Dis;
    }
}
