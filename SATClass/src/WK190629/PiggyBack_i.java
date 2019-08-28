package WK190629;

import java.util.*;

public class PiggyBack_i {
//iS = integer starting point
//iE = integer exit point
    private static Scanner sc = new Scanner(System.in);
    private static int B = sc.nextInt();
    private static int E = sc.nextInt();
    private static int P = sc.nextInt();
    private static int N = sc.nextInt();
    private static int M = sc.nextInt();
    private static int[][] cord = new int[M][2];
    private static Queue<Integer> aQue = new LinkedList<Integer>();
    private static LinkedList<Integer>[] aLink = new LinkedList[N];
    private static boolean[] aVisited = new boolean[N];
    private static int[] aDepth = new int[N];

    public static void main(String[] args) {
        for(int i = 0; i < M; i++) {
            cord[i][0] = sc.nextInt();
            cord[i][1] = sc.nextInt();
        }
        for(int i = 0; i < cord.length; i++) {
            aLink[i] = new LinkedList<>();
            aLink[cord[i][0]].add(cord[i][1]);
            aLink[cord[i][1]].add(cord[i][0]);
        }

    }

    private static void doBFS(int iS) {
        Arrays.fill(aVisited, false);
        aQue.clear();
        aQue.add(iS);
        aDepth[iS] = 0;
        int iSrc;
        while (!aQue.isEmpty()) {
            iSrc = aQue.poll();
            aVisited[iSrc] = true;
            for(int i = 0; i < aLink[iSrc].size(); i++) {
                int iNext = aLink[iSrc].get(i);
                if(!aVisited[iNext] && !aQue.contains(iNext)) {
                    aQue.add(iNext);
                    aDepth[iNext] = aDepth[iSrc] + 1;
                }
            }
        }
    }

}
