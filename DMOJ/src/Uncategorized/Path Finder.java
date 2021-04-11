package Uncategorized;

import java.util.*;
import java.io.*;

public class PathFinder {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, K;
    static boolean vis[][];
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); K = readInt(); vis = new boolean[N+1][M+1];
        for (int i = 0; i < K; i++) {
            int a = readInt(), b = readInt();
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            map.get(a).add(b);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1)); vis[1][1] = true;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int r = n.a, c = n.b;
            if (v(r+1, c)) {
                queue.add(new Node(r+1, c));
                vis[r+1][c] = true;
            }
            if (v(r-1, c)) {
                queue.add(new Node(r-1, c));
                vis[r-1][c] = true;
            }
            if (v(r, c+1)) {
                queue.add(new Node(r, c+1));
                vis[r][c+1] = true;
            }
            if (v(r, c-1)) {
                queue.add(new Node(r, c-1));
                vis[r][c-1] = true;
            }
        }
        System.out.println(vis[N][M] ? "YES" : "NO");
    }

    static boolean v (int r, int c) {
        return (r > 0 && c > 0 && r <= N && c <= M && !vis[r][c] && !map.get(r).contains(c));
    }

    static class Node {
        int a, b;
        Node (int pa, int pb) { a = pa; b = pb; }
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
