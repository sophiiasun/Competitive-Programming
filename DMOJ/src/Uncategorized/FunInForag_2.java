package Uncategorized;

import java.util.*;
import java.io.*;

public class FunInForag_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, A, B;
    static long C;
    static ArrayList<int[]>[] list;
    static boolean[] vis;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); int a, b, c;
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) { // Obtain input
            a = readInt(); b = readInt(); c = readInt();
            list[a].add(new int[]{b, c, i}); list[b].add(new int[]{a, c, i});
        }
        A = readInt(); B = readInt(); C = readLong();

        int start = 1, end = M, mid, min = Integer.MAX_VALUE;
        vis = new boolean[N+1]; dis = new int[N+1];
        while (start <= end) {
            mid = (start + end) >> 1;
            Arrays.fill(dis, Integer.MAX_VALUE); dis[A] = 0;
//            Arrays.fill(vis, false);
            if (dijkstra(mid)) {
                min = mid; end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println((min==Integer.MAX_VALUE) ? -1 : min);
    }

    static boolean dijkstra(int mid){
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[]a, int[]b) -> a[1] - b[1]);

        // Queue int[]: { node, distance, level }
        //  List int[]: { node, distance, level }

        queue.add(new int[]{A, 0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[1] > dis[curr[0]] || curr[1] > C) continue;
            for (int[] arr : list[curr[0]]) {
                if (arr[2] <= mid && curr[1] + arr[1] < dis[arr[0]]) {
                    dis[arr[0]] = curr[1] + arr[1];
                    queue.add(new int[]{arr[0], dis[arr[0]], arr[2]});
                }
                if (dis[B] != Integer.MAX_VALUE) return true;
            }
        }
        return false;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
