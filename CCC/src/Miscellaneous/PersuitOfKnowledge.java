package Miscellaneous;

import java.util.*;

public class PersuitOfKnowledge {
    static ArrayList<Integer>[] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), T = sc.nextInt();
        map = new ArrayList[N];
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < M; i++)
            map[sc.nextInt()-1].add(sc.nextInt()-1);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            Queue<int[]> queue = new LinkedList<>();
            int[] start = new int[]{sc.nextInt()-1, sc.nextInt()-1};
            queue.add(new int[]{start[0], 0});
            boolean[] vis = new boolean[N];
            boolean found = false;
            while (!queue.isEmpty()) {
                int[] next = queue.poll();
                if (next[0]==start[1]) {
                    System.out.println(next[1]);
                    found = true;
                    continue;
                }
                for (int j : map[next[0]]) {
                    if (!vis[j]) {
                        queue.add(new int[]{j, next[1] + T});
                        vis[j] = true;
                    }
                }
            }
            if (!found)
                System.out.println("Not enough hallways!");
        }
    }
}
