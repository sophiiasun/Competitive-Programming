package WK190615;

import java.util.*;

public class test {
    public static LinkedList<Integer>[] aEdge;
    public static int N;
    public static boolean[] aVisited;
    public static int[][] mCows;
    public static int[] aRange;

    public static void main(String[] args) {
        Scanner oIn = new Scanner(System.in);
        N = oIn.nextInt();
        aEdge = new LinkedList[N];
        for(int i = 0; i < N; i++)
            aEdge[i] = new LinkedList<Integer>();
        aRange = new int[N];
        mCows = new int[N][2];
        aVisited = new boolean[N];

        for(int i = 0; i < N; i++) {
            mCows[i][0] = oIn.nextInt();
            mCows[i][1] = oIn.nextInt();
            aRange[i] = oIn.nextInt();
        }

        buildEdges();

        int iMost = 0, iCurr = 0;
        for(int i = 0; i < N; i++) {
            Arrays.fill(aVisited, false);
            iCurr = findConnected(i);
            if(iMost < iCurr)
                iMost = iCurr;
        }
        System.out.println(Arrays.toString(aEdge));
        System.out.println(iMost);
    }

    public static int findConnected(int iS) {
        int iRet = 1, iNext = 0;
        aVisited[iS] = true;
        for(int i = 0; i < aEdge[iS].size(); i++) {
            iNext = aEdge[iS].get(i);
            if(!aVisited[iNext])
                iRet += findConnected(iNext);
        }
        return iRet;
    }

    public static void buildEdges() {
        for(int i = 0; i < N; i++) {
            int iRange = aRange[i];
            for(int j = 0; j < N; j++) {
                if(i != j && calcDist(i, j) <= iRange)
                    aEdge[i].add(j);
            }
        }
    }

    public static double calcDist(int iS, int iE) {
        double dRet = Math.sqrt(Math.pow(mCows[iS][0] - mCows[iE][0], 2) + Math.pow(mCows[iS][1] - mCows[iE][1], 2));
        return dRet;
    }
}