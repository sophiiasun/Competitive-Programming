package Olympiads;

import java.util.*;
import java.io.*;

public class Mynerva {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), a, b, c;
        ArrayList<Node2>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            a = readInt(); b = readInt(); c = readInt();
            adj[a].add(new Node2(b, c, 1)); adj[b].add(new Node2(a, c, 1));
        }
        Node[] arr = new Node[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new Node(0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        int Q = readInt();

        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Node2> queue = new LinkedList<>();
        queue.add(new Node2(1, 0, 0)); // node, brightness
        while (!queue.isEmpty()) {
            Node2 curr = queue.poll();
            for (Node2 n : adj[curr.n]) {
                if (curr.d + n.d == dis[n.n]) { // Same minimal distance
                    if (curr.b + n.b > arr[n.n].h) {
                        arr[n.n].h = curr.b + n.b;
                        queue.add(new Node2(n.n, arr[n.n].h, dis[n.n]));
                    } else if (curr.n + n.b < arr[n.n].l) {
                        arr[n.n].l = curr.b + n.b;
                        queue.add(new Node2(n.n, arr[n.n].l, dis[n.n]));
                    }
                } else if (curr.d + n.d < dis[n.n]) { // New minimal distance
                    arr[n.n].h = curr.b + n.b;
                    arr[n.n].l = curr.b + n.b;
                    queue.add(new Node2(n.n, arr[n.n].h, dis[n.n]));
                    queue.add(new Node2(n.n, arr[n.n].l, dis[n.n]));
                }
            }
            System.out.println("run");
        }

        for (int i = 0; i < Q; i++) {
            int n = readInt(); String s = next();
            if (s.charAt(0) == 'B') {
                System.out.println(arr[n].l);
            } else {
                System.out.println(arr[n].h);
            }
        }
    }

    static class Node2 {
        int n, b, d;
        Node2 (int ph, int pl, int pd) {n=ph; b=pl; d = pd;}
    }

    static class Node {
        int h=0, l=0, d = Integer.MAX_VALUE;
        Node (int ph, int pl, int pd) {h=ph; l=pl; d=pd; }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
