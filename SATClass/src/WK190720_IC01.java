import java.util.*;

public class WK190720_IC01 {

    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt();
    private static int C = sc.nextInt();
    private static int[][] cord = new int[N][3];
    private static ArrayList<int[]> link = new ArrayList<>();
    private static int[] aParent = new int[N];
    private static int Total = 0;
    private static int testCnt = 0;

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            cord[i][0] = sc.nextInt();
            cord[i][1] = sc.nextInt();
        }
        long n = System.nanoTime();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double Dis = getDis(cord[i][0], cord[j][0], cord[i][1], cord[j][1]);
                if (Dis >= C) {
                    link.add(new int[]{i, j, (int) Dis});
                    testCnt++;
                }
            }
        }
        Collections.sort(link, (int[] a, int[] b) -> a[2] - b[2]);
        long e = System.nanoTime();
        System.out.println("Cost: " + doDSU());
        System.out.println("Time: " + (e - n));
    }

    private static int doDSU() {
        int cnt = 0;
        for (int i = 0; i < aParent.length; i++) aParent[i] = i;
        for (int i = 0; i < link.size(); i++) {
            if (aParent[link.get(i)[0]] == aParent[link.get(i)[1]]) continue;
            else {
                Total += link.get(i)[2];
                mergeSet(link.get(i)[0], link.get(i)[1]);
                cnt++;
            }
            if (cnt == N - 1) break;
            if (i % 1000 == 0) System.out.println(testCnt + " : " + i);
        }
        System.out.println();
        return Total;
    }

    private static void mergeSet(int A, int B) {
        int temp = aParent[A];
        for (int i = 0; i < aParent.length; i++) {
            if (aParent[i] == temp) aParent[i] = aParent[B];
        }
    }

    private static double getDis(int X1, int X2, int Y1, int Y2) {
        double Dis = Math.pow((X1 - X2), 2) + Math.pow((Y1 - Y2), 2);
        return Dis;
    }
}