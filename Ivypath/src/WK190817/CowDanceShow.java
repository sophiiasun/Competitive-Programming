package WK190817;

import java.util.*;

public class CowDanceShow {
    private static int N;
    private static int T;
    private static Queue<Integer> iQ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        iQ = new LinkedList<>();
        for (int i = 0; i < N; i++)
            iQ.add(sc.nextInt());
        ArrayMethod();
    }

    private static void ArrayMethod() {
        int K = N;
        for (int i = N-1; i > 0; i--) {
            int[] aStg = new int[i];
            int kTmp = 0;
            int t = 0;
            Queue<Integer> iQtmp = new LinkedList<>(iQ);
            for(int j = 0; j < i; j++) {
                aStg[j] = iQtmp.poll();
                kTmp++;
                System.out.println("run 1");
            }
            while (kTmp > 0) {
                int min = getMin(aStg);
                for(int k = 0; k < i; k++) {
                    aStg[k] -= min;
                    if (aStg[k] == 0) {
                        Integer tmp = iQtmp.poll();
                        if (tmp == null)
                            kTmp--;
                        else
                            aStg[k] = tmp;
                    }
                    System.out.println("run 2");
                }
                t += min;
                System.out.println("run 3");
            }
            if (t <= T) K = i;
            System.out.println("run 4");
        }
        System.out.println(K);
    }

    private static void PriorityQueueMethod() {
        int Tm = 0;
        int K = N;
        Queue<Integer> iQtemp;
        for (int i = N - 1; i > 0; i--) {
            PriorityQueue<Integer> stage = new PriorityQueue<>();
            iQtemp = new LinkedList<>(iQ);
            for (int j = 0; j < i; j++)
                stage.add(iQtemp.poll());
            int iC = stage.poll();
            for (int t = 0; t < T; t++) {
                if (iC == t) {
                    stage.add(iQtemp.poll());
                    int iN = stage.poll();
                    while (iN == t) {
                        stage.add(iQtemp.poll());
                        iN = stage.poll();
                    }
                    iC = iN;
                } else iC = stage.poll();
            }
        }
        System.out.println(K);
    }

    private static int getMin(int[] arr) {
        int iRet = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < iRet && arr[i] > 0) iRet = arr[i];
        }
        return iRet;
    }

    private static boolean chkKTmp(int kTmp) {
        return kTmp == T;
    }

}

