package WK190615;

import java.util.*;

public class MoocastDFS {
    public static LinkedList<Integer>[] link;          //LinkedList<int[]>
    public static Scanner sc = new Scanner(System.in);
    public static int N = sc.nextInt();
    public static int[][] cord = new int[N][2];
    public static int[] pow = new int[N];
    public static boolean[] aVisited;

    public static void main(String[] args) {
        link = new LinkedList[N];
        aVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            cord[i][0] = sc.nextInt();
            cord[i][1] = sc.nextInt();
            pow[i] = sc.nextInt();
            link[i] = new LinkedList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                double Dis = getDis(cord[i][0], cord[i][1], cord[j][0], cord[j][1]);
                if (Dis <= pow[i]) link[i].add(j);
                if (Dis <= pow[j]) link[j].add(i);
            }
        }
        int max = 0, iNext;
        for (int i = 0; i < N; i++) {
            iNext = cntConnected(i);
            if (iNext > max) max = iNext;
        }
        System.out.println(Arrays.toString(link));
        System.out.println(max);
    }

    static double getDis(int X1, int Y1, int X2, int Y2) {
        double Dis = Math.sqrt(Math.pow((Y2 - Y1), 2) + Math.pow((X2 - X1), 2));
        return Dis;
    }

    static int cntConnected(int N) {
        int cnt = 0;
        Arrays.fill(aVisited, false);
        doDFS(N);
        for (int i = 0; i < aVisited.length; i++) {
            if (aVisited[i]) cnt++;
        }
        return cnt;
    }

    static void doDFS(int N) {
        aVisited[N] = true;
        for (int i = 0; i < link[N].size(); i++) {
            int temp = link[N].get(i);
            if (!aVisited[temp])
                doDFS(temp);
        }
    }
}