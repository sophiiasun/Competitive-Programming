package Miscellaneous.DMOPC;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class DMOPC18_ThanksgivingFeast {
    static int N, M, K, A, B;
//    static boolean[][] arr;
    static ArrayList<Integer>[] arr;
    static boolean[] stores;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]); M = Integer.parseInt(in[1]); K = Integer.parseInt(in[2]);
        A = Integer.parseInt(in[3]); B = Integer.parseInt(in[4]);
        in = br.readLine().split(" ");
        stores = new boolean[N+1];
        for (int i = 0; i < K; i++)
            stores[Integer.parseInt(in[i])] = true;
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]);
            arr[a].add(b); arr[b].add(a);
        }

        int[] dis = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[A] = true;
        queue.add(A);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (!visited[i] && dis[i] + dis[curr] < min) {
                    dis[i] = dis[curr]+1;
                    if (stores[i])
                        run (i, dis[i]);
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println(min);
    }

    static void run(int start, int distance) {
        boolean[] visited = new boolean[N+1];
        int[] dis = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        dis[start] = distance;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (!visited[i] && dis[i] < min) {
                    visited[i] = true;
                    dis[i] = dis[curr]+1;
                    if (i == B) {
                        min = Math.min(min, dis[i]);
                        return;
                    }
                    queue.add(i);
                }
            }
        }
    }
}
