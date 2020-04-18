package Miscellaneous;

import java.util.*;
import java.io.*;

public class GrafZeppelin {

//    static boolean[][] count;
    static int N, M, K;
    static ArrayList<Integer>[] map;
    static Set<Integer>[] set;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        K = Integer.parseInt(in[2]);
        map = new ArrayList[N];
        set = new HashSet[N];
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < M; i++){
            in = br.readLine().split(" ");
            map[Integer.parseInt(in[0])-1].add(Integer.parseInt(in[1])-1);
            map[Integer.parseInt(in[1])-1].add(Integer.parseInt(in[0])-1);
        }

        boolean[] vis = new boolean[N];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int counter = 1;
            queue.add(new int[]{i, 0});
            vis[i] = true;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll(); // curr: node, counter
                for (int j : map[curr[0]]) {
                    if (!vis[j] && curr[1] < K) {
                        counter++;
                        queue.add(new int[]{j, curr[1] + 1});
                        vis[j] = true;
                    }
                }
            }
            System.out.println(counter);
            queue.clear();
            Arrays.fill(vis, false);
        }
    }
}
