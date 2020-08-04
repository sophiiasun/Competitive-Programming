package DMOPC.Y2014;

import java.util.*;
import java.io.*;

public class DMOPC14_ExamDelay {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    // Start at 1, end at V

    public static void main(String[] args) throws IOException {
        int V = readInt(), E = readInt(), a, b; double t;
        ArrayList<Road>[] arr = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            a = readInt(); b = readInt(); t = (double) readInt() / readInt() * 60;
            arr[a].add(new Road(b, t)); arr[b].add(new Road(a, t));
        }

        PriorityQueue<Loc> queue = new PriorityQueue<>(); queue.add(new Loc(1, 0, 0));
        double[] dis = new double[V+1]; Arrays.fill(dis, Integer.MAX_VALUE); dis[1] = 0;

        int min = Integer.MAX_VALUE; // Minimum intersections

        while (!queue.isEmpty()) {
            Loc curr = queue.poll();
            if (curr.n == V) {
                if (curr.d < dis[V]) { min = curr.c; dis[V] = curr.d; }
                else if (curr.n < min) min = curr.c;
                continue;
            }
            if (dis[curr.n] < curr.d) continue;
            for (Road r : arr[curr.n]) {
                if (dis[curr.n] + r.d < dis[r.n]) {
                    dis[r.n] = dis[curr.n] + r.d;
                    queue.add(new Loc(r.n, curr.c + 1, dis[r.n]));
                }
            }
        }

        System.out.println(min);
        double d1 = dis[V], d2 = dis[V] / 0.75;
        System.out.println(Math.round(d2-d1));
    }

    static class Road { // destination node, distance
        int n; double d;
        Road (int pn, double pd) { n = pn; d = pd; }
    }

    static class Loc implements Comparable<Loc> { // destination node, node count, distance
        int n, c; double d;
        Loc (int pn, int pc, double pd) { n = pn; c = pc; d = pd; }
        public int compareTo (Loc other) { return Double.compare(d, other.d); }
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
