package APIO;

import java.util.*;
import java.io.*;

public class Jakarta {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), S, E;
//        ArrayList<Integer>[] arr = new ArrayList[N];
//        for (int i = 0; i < N; i++) arr[i] = new ArrayList<>(); // Initialize
        Set<Integer>[] arr = new HashSet[N];
        for (int i = 0; i < N; i++) arr[i] = new HashSet<>(); // Initialize
        S = readInt(); arr[S].add(readInt());
        E = readInt(); arr[E].add(readInt());
        for (int i = 0; i < M - 2; i++) arr[readInt()].add(readInt()); // Input
//        for (int i = 0; i < N; i++) { Collections.sort(arr[i]); dedup(arr[i]); }

        PriorityQueue<Loc> queue = new PriorityQueue<>(); queue.add(new Loc(0, S));
        long[] dis = new long[N]; Arrays.fill(dis, Long.MAX_VALUE); dis[S] = 0; // Distance from skyscraper 0 to skyscraper i

        while (!queue.isEmpty()) { // Dijkstra
            Loc curr = queue.poll();
            if (curr.n == E) { System.out.println(curr.d); return; }
            if (dis[curr.n] < curr.d) continue;
            for (int jump : arr[curr.n]) { // Go through each Doge at skyscraper i
                // Jump forwards:
                for (int i = 1; curr.n + i * jump < N; i++) { // Go through each possible jump by Doge i
                    int j = i * jump + curr.n;
                    if (curr.d + i < dis[j]) { // Takes less jumps
                        dis[j] = curr.d + i;
                        queue.add(new Loc(dis[j], j));
//                        if (Collections.binarySearch(arr[j], jump) >= 0) break;
                        if (arr[j].contains(jump)) break;
                    }
                }
                // Jump backwards:
                for (int i = 1; curr.n - i * jump >= 0; i++) { // Go through each possible jump by Doge i
                    int j = curr.n - i * jump;
                    if (curr.d + i < dis[j]) {
                        dis[j] = curr.d + i;
                        queue.add(new Loc(dis[j], j));
//                        if (Collections.binarySearch(arr[j], jump) >= 0) break;
                        if (arr[j].contains(jump)) break;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static void dedup (ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i+1).equals(arr.get(i))) arr.remove(i);
        }
    }

    static class Loc implements Comparable<Loc> {
        long d; int n; // distance : node
        Loc (long pd, int pn) { d = pd; n = pn; }
        public int compareTo (Loc other) {
            return Long.compare(d, other.d);
        }
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
