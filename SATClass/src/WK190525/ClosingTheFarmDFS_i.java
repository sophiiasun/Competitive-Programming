package WK190525;

import java.util.*;

public class ClosingTheFarmDFS_i {

    static LinkedList<Integer>[] link;
    static boolean[] aVisited;
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt(), M = sc.nextInt();

    public static void main(String[] args) {
        link = new LinkedList[N];
        for (int i = 0; i < N; i++) link[i] = new LinkedList<>();
        for (int i = 0; i < M; i++) addEdges(sc.nextInt(), sc.nextInt());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < N; i++) {
            if (isConnected()) System.out.println("YES");
            else System.out.println("NO");
            for (int j = 0; j < link.length; i++) {
                if (link[j].get(0) == arr[j]) link[j].set(0, -2);
                if (link[j].get(1) == arr[j]) link[j].set(1, -2);
            }
        }
    }

    static boolean isConnected() {
        boolean cnct = true;
        Arrays.fill(aVisited, false);
        doDFS(0);
        for (int i = 0; i < aVisited.length; i++) {
            if (!aVisited[i]) {
                cnct = false;
                break;
            }
        }
        return cnct;
    }

    static void doDFS(int iN) {
        aVisited[iN] = true;
        for (int i = 0; i < link[iN].size(); i++) {
            int iNext = link[iN].get(i);
            if (!aVisited[iNext]) doDFS(iNext);
        }
    }

    static void addEdges(int iBarn, int iLink) {
        link[iBarn].add(iLink);
        link[iLink].add(iBarn);
    }
}
