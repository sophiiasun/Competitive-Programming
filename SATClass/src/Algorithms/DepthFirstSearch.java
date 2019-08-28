package Algorithms;

import java.util.*;

public class DepthFirstSearch {

    static LinkedList<Integer>[] aEdge;
    static boolean[] aVisited;

    public static void main(String[] args) {
        int N = 9;
        aVisited = new boolean[N];
        aEdge = new LinkedList[N];
        for (int i = 0; i < N; i++) aEdge[i] = new LinkedList<>();
        addEdges(0, 1); //Edges connect back and forth (edge from 1 to 0, and 0 to 1)
        addEdges(0, 2);
        addEdges(1, 4);
        addEdges(4, 5);
        addEdges(2, 3);
        addEdges(3, 5);
        addEdges(5, 8);
        addEdges(7, 8);
        addEdges(2, 6);

        if (isConnected())
            System.out.println("Connected");
        else
            System.out.println("Not Connected");

//        System.out.println(Arrays.toString(aEdge));

    }

    static boolean isConnected() {
        boolean bRet = true;
        Arrays.fill(aVisited, false);
        doDFS(0);
        for (int i = 0; i < aVisited.length; i++) {
            if (!aVisited[i]) {
                bRet = false;
                break;
            }
        }
        return bRet;
    }

    static void doDFS(int iN) {
        aVisited[iN] = true;
        for (int i = 0; i < aEdge[iN].size(); i++) {
            int iNext = aEdge[iN].get(i);
            if (!aVisited[iNext])
                doDFS(iNext);
        }
    }

    static void addEdges(int iS, int iE) {
        aEdge[iS].add(iE);
        aEdge[iE].add(iS);
    }
}
