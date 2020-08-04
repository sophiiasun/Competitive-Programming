package CCO;

import java.util.*;
import java.io.*;

public class CCO15P2_Artskjid {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<Node>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) arr[readInt()].add(new Node(readInt(), readInt()));
        int[] dis = new int[n]; Arrays.fill(dis, -1); dis[0] = 0;

        Queue<Node> queue = new LinkedList<>(); queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.d < dis[curr.n]) continue;
            for (Node a : arr[curr.n]) { // a : {node, dis}
                if (curr.d + a.d > dis[a.n]) {
                    dis[a.n] = curr.d + a.d;
                    if (a.n != n-1) queue.add(new Node(a.n, dis[a.n]));
                }
            }
        }

        System.out.println(dis[n-1]);
    }

    static class Node implements Comparable<Node> {
        int n, d;
        Node(int pn, int pd) {n = pn; d = pd;}
        public int compareTo (Node other) { return (d - other.d); }
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
