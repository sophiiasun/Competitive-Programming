package Algorithms.Search;

import java.util.*;

public class DisjointSetUnion {
    public static LinkedList<int[]> oEdge;
    public static int[] aParent;
    public static int[] aSizes;
    public static int iComp;

    public static void main(String[] args) {
        int N = 9;
        aParent = new int[N];
        aSizes = new int[N];

        oEdge = new LinkedList<int[]>();
        oEdge.add(new int[] {0, 1});
        oEdge.add(new int[] {0, 2});
        oEdge.add(new int[] {1, 4});
        oEdge.add(new int[] {4, 5});
        oEdge.add(new int[] {2, 3});
        oEdge.add(new int[] {3, 5});
        oEdge.add(new int[] {5, 8});

        doDsu();

        System.out.println("Connected? " + isConnected());
        System.out.println("Num of Components: " + iComp);
        printComp();
    }

    public static void doDsu() {
        iComp = aParent.length;
        for(int i = 0; i < aParent.length; i++) {
            aParent[i] = i;
            aSizes[i] = 1;
        }

        for(int i = 0; i < oEdge.size(); i++)
            mergeSets(oEdge.get(i)[0], oEdge.get(i)[1]);
    }

    public static void mergeSets(int iA, int iB) {
        if(aParent[iA] != aParent[iB]) {
            iComp--;
            int iAp = aParent[iA];
            int iBp = aParent[iB];
            aSizes[iBp] += aSizes[iAp];
            aSizes[iAp] = 0;
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

    public static void printComp() {
        HashSet<Integer> oPar = new HashSet<Integer>();
        for(int i = 0; i < aParent.length; i++)
            oPar.add(aParent[i]);

        for(int iP : oPar) {
            System.out.print("Parent " + iP + "'s " + aSizes[iP] + " components: ");
            for(int i = 0; i < aParent.length; i++) {
                if(aParent[i] == iP)
                    System.out.print(i + ",");
            }
            System.out.println("");
        }
    }
}
