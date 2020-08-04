package DMOPC;

import java.io.*;
import java.util.*;

public class DMOPC18_ThanksgivingFeast2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]), K = Integer.parseInt(in[2]);
        int A = Integer.parseInt(in[3]), B = Integer.parseInt(in[4]);
        in = br.readLine().split(" ");
        boolean[] stores = new boolean[N+1];
        for (int i = 0; i < K; i++)
            stores[Integer.parseInt(in[i])] = true;
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]);
            arr[a].add(b); arr[b].add(a);
        }

        int[] dis1 = new int[N+1];
        int[] dis2 = new int[N+1];
        Arrays.fill(dis1, -1);
        Arrays.fill(dis2, -1);
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(A);
        queue2.add(B);
        dis1[A] = 0;
        dis2[B] = 0;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                int curr = queue1.poll();
                for (int i : arr[curr]) {
                    if (dis1[i] < 0) {
                        dis1[i] = dis1[curr] + 1;
                        if (stores[i] && dis2[i] >= 0) {
                            System.out.println(dis1[i] + dis2[i]); System.exit(0);
                        }
                        queue1.add(i);
                    }
                }
            }
            if (!queue2.isEmpty()) {
                int curr = queue2.poll();
                for (int i : arr[curr]) {
                    if (dis2[i] < 0) {
                        dis2[i] = dis2[curr] + 1;
                        if (stores[i] && dis1[i] >= 0) {
                            System.out.println(dis1[i] + dis2[i]); System.exit(0);
                        }
                        queue2.add(i);
                    }
                }
            }
        }
    }
}
