package Algorithms.Search;

import java.util.*;

public class Kruskal {
    public static LinkedList<int[]> oEdge;
    public static int[] aParent;
    public static int Total=0;
    public static int cntEdge;
    public static int N = 9;

    public static void main(String[] args) {
        aParent = new int[N];

        oEdge = new LinkedList<int[]>();
        oEdge.add(new int[] {0, 1, 4});
        oEdge.add(new int[] {1, 2, 8});
        oEdge.add(new int[] {2, 3, 7});
        oEdge.add(new int[] {3, 4, 9});
        oEdge.add(new int[] {4, 5, 10});
        oEdge.add(new int[] {5, 6, 2});
        oEdge.add(new int[] {6, 7, 1});
        oEdge.add(new int[] {7, 0, 8});
        oEdge.add(new int[] {0, 1, 4});
        oEdge.add(new int[] {1, 7, 11});
        oEdge.add(new int[] {7, 8, 7});
        oEdge.add(new int[] {2, 8, 2});
        oEdge.add(new int[] {8, 6, 6});
        oEdge.add(new int[] {3, 5, 14});
        oEdge.add(new int[] {5, 8, 4});
        Collections.sort(oEdge, (int[] a, int[]b) -> a[2] - b[2]);

        doDsu();

        System.out.println("Connected? " + isConnected());
        System.out.println(Total);
        System.out.println(cntEdge);

    }

    public static void doDsu() {
        cntEdge = 0;
        for(int i = 0; i < aParent.length; i++) {
            aParent[i] = i;
        }
        for(int i = 0; i < oEdge.size(); i++) {
            if(aParent[oEdge.get(i)[0]] == aParent[oEdge.get(i)[1]]) continue;
            else {
                Total += oEdge.get(i)[2];
                mergeSets(oEdge.get(i)[0], oEdge.get(i)[1]);
                cntEdge++;
            }
            if(cntEdge == N-1) break;
        }
    }

    public static void mergeSets(int iA, int iB) {
        if(aParent[iA] != aParent[iB]) {
            int iAp = aParent[iA];
            for(int i = 0; i < aParent.length; i++) {
                if(aParent[i] == iAp)
                    aParent[i] = aParent[iB];
            }
        }
    }

    public static boolean isConnected() {
        boolean bRet = true;
        int iP = aParent[0];
        for(int i = 1; i < aParent.length; i++) {
            if(aParent[i] != iP) {
                bRet = false;
                break;
            }
        }
        return bRet;
    }
}
