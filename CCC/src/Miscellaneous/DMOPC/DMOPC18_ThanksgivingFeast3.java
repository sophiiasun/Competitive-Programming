package Miscellaneous.DMOPC;

import java.util.*;
import java.io.*;

public class DMOPC18_ThanksgivingFeast3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]), K = Integer.parseInt(in[2]);
        int A = Integer.parseInt(in[3]), B = Integer.parseInt(in[4]);
        in = br.readLine().split(" ");
        boolean[] stores = new boolean[N+1];
        int[] storeNode = new int[K];
        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(in[i]);
            stores[tmp] = true;
            storeNode[i] = tmp;
        }
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]);
            arr[a].add(b); arr[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dis = new int[N+1]; Arrays.fill(dis, -1);
        int storeCount = 0;
        if (stores[A]) storeCount=1;
        dis[A] = 0;
        queue.add(A);
        while(!queue.isEmpty() && storeCount != K) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (dis[i] == -1) {
                    dis[i] = dis[curr] + 1;
                    if (stores[i]) storeCount++;
                    queue.add(i);
                }
            }
        }
        storeCount = 0;
        queue.clear();
        int[] dis2 = new int[N+1]; Arrays.fill(dis2, -1);
        queue.add(B);
        dis2[B] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (dis2[i] == -1) {
                    dis2[i] = dis2[curr] + 1;
                    if (stores[i]) storeCount++;
                    queue.add(i);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            min = Math.min(min, dis[storeNode[i]] + dis2[storeNode[i]]);
        }

        System.out.println(min);

    }
}
