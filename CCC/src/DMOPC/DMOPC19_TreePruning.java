package DMOPC;

import java.util.*;
import java.io.*;

public class DMOPC19_TreePruning {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a, b; long K = readLong(), weight[] = new long[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>(); weight[i] = readLong();
            if (weight[i] >= K && weight[i] <= K << 1) {
                System.out.println(1); System.out.println(i); System.exit(0);
            }
        }
        for (int i = 1; i < N; i++) {
            a = readInt(); b = readInt();
            if (weight[a] <= K<<1 && weight[b] <= K<<1) {
                arr[a].add(b); arr[b].add(a);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if (vis[i] == 0) {
                vis[i] = i; int count = 1; long total=weight[i]; queue.add(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int next : arr[curr]) {
                        if (vis[next]==0) {
                            total += weight[next]; count++; vis[next] = i; queue.add(next);
                            if (total >= K) {
                                System.out.println(count); StringBuilder sb = new StringBuilder();
                                for (int j = 1; j <= N; j++) {
                                    if (vis[j] == i) sb.append(j + " ");
                                }
                                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); System.out.println(sb); System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
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
