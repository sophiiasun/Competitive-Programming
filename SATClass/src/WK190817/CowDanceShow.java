package WK190817;

import java.util.*;

public class CowDanceShow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();

        Queue<Integer> iQ = new LinkedList<>();
        for (int i = 0; i < N; i++)
            iQ.add(sc.nextInt());
//      ==================================================
        int Tm = 0;
        int K = N;
        Queue<Integer> iQtemp;
        for (int i = N - 1; i > 0; i--) {
            PriorityQueue<Integer> stage = new PriorityQueue<>();
            iQtemp = new LinkedList<>(iQ);
            for (int j = 0; j < i; j++)
                stage.add(iQtemp.poll());
            while (!iQtemp.isEmpty()) {
                int iC = stage.poll();
                int iN = stage.poll();
                while (iN == iC) {
                    stage.add (iQtemp.poll());
                    iN = stage.poll();
                }
                Tm += iC;
                iC = iN;
            }
            if (Tm <= T) K = i;
            else break;
        }

        System.out.println(K);
    }
}

