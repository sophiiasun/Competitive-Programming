package Algorithms;

import java.util.*;

public class BFS_AllDepth {
    public static int N = 12;
    public static LinkedList<Integer>[] aEdges;
    public static int[][] aDepth;
    public static boolean[] aVisited;
    public static Queue<Integer> oNodes;

    public static void main(String[] args) {
        Scanner oIn = new Scanner(System.in);
        aVisited = new boolean[N];
        aDepth = new int[N][2];
        oNodes = new LinkedList();
        aEdges = new LinkedList[N];
        for(int i = 0; i < N; i++)
        {
            aEdges[i] = new LinkedList<Integer>();
            aDepth[i][0] = i;
        }
        populateEdges();

        System.out.println("Please enter the start point: ");
        int iS = oIn.nextInt() - 1;
        populateShortPath(iS);

        printDepth(iS);
    }

    public static void populateShortPath(int iS) {
        oNodes.add(iS);
        aDepth[iS][1] = 0;

        while (!oNodes.isEmpty()) {
            int iSrc = oNodes.poll();
            aVisited[iSrc] = true;
            for(int i = 0; i < aEdges[iSrc].size(); i++) {
                int iNext = aEdges[iSrc].get(i);
                if(aVisited[iNext] == false && !oNodes.contains(iNext)) {
                    oNodes.add(iNext);
                    aDepth[iNext][1] = aDepth[iSrc][1] + 1;
                }
            }
        }
    }

    public static void printDepth(int iS) {
        System.out.println("Start point is " + iS);
        int iCur = 1;
        Arrays.sort(aDepth, (r1, r2) -> r1[1] - r2[1]);

        System.out.print("Depth " + iCur + ": ");
        for(int i = 1; i < N; i++) {
            if(aDepth[i][1] == iCur)
                System.out.print((aDepth[i][0] + 1) + ",");
            else {
                System.out.println("");
                iCur = aDepth[i][1];
                System.out.print("Depth " + iCur + ": ");
                System.out.print((aDepth[i][0] + 1) + ",");
            }
        }
        System.out.println("");
    }

    public static void populateEdges() {
        aEdges[0].add(1);
        aEdges[1].add(0);
        aEdges[0].add(2);
        aEdges[2].add(0);
        aEdges[0].add(3);
        aEdges[3].add(0);

        aEdges[1].add(4);
        aEdges[4].add(1);
        aEdges[1].add(5);
        aEdges[5].add(1);

        aEdges[3].add(6);
        aEdges[6].add(3);
        aEdges[3].add(7);
        aEdges[7].add(3);

        aEdges[4].add(8);
        aEdges[8].add(4);
        aEdges[4].add(9);
        aEdges[9].add(4);

        aEdges[6].add(10);
        aEdges[10].add(6);
        aEdges[6].add(11);
        aEdges[11].add(6);
    }
}
