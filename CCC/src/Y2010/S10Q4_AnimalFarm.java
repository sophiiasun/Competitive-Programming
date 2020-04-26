package Y2010;

import java.util.*;

public class S10Q4_AnimalFarm {
    static Map<String, Edge> setid = new HashMap<>();
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    static int N;

    static class Graph{
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int[] groups;
        int gid = 0;
        int n;
        int exp;
        Graph (int pn) {
            n = pn;
            groups = new int[n + 1];
            exp = n;
        }
        void addPoint(){
            exp = n + 1;
        }
        boolean connect(int o1, int o2){
            if (groups[o1] == groups[o2] && groups[o1] != 0) {
                return false;
            }
            if (groups[o1] == groups[o2] && groups[o1] == 0) {
                gid++;
                groups[o1] = gid;
                groups[o2] = gid;
                HashSet<Integer> set = new HashSet<>();
                set.add(o1);
                set.add(o2);
                map.put(gid, set);
            } else if (groups[o1] == 0 && groups[o2] != 0) {
                map.get(groups[o2]).add(o1);
                groups[o1] = groups[o2];
            } else if (groups[o1] != 0 && groups[o2] == 0) {
                map.get(groups[o1]).add(o2);
                groups[o2] = groups[o1];
            } else if (groups[o1] != 0 && groups[o2] != 0) {
                int min = Math.min(groups[o1], groups[o2]);
                int max = Math.max(groups[o1], groups[o2]);
                map.get(min).addAll(map.get(max));
                Set<Integer> set = map.get(max);
                map.remove(max);
                for (int i : set)
                    groups[i] = min;
            }
            return true;
        }

        boolean isConnected() {
            return (map.size() == 1 && map.get(1).size() == exp);
        }
    }

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int c;
        String id;
        int[] pens = new int[2];
        Edge(int ps, int pe, int pc) {
            s = ps;
            e = pe;
            c = pc;
            id = Math.min(s, e) + "+" + Math.max(e, s);
        }
        @Override
        public int compareTo(Edge o){
            return c - o.c;
        }
    }

    public static void main(String[] args) {
        init();
        int cost = 0;
        Graph graph = new Graph(N);
        while (!graph.isConnected()) {
            Edge edge = queue.poll();
            if (edge.pens[1] == 0)
                graph.addPoint();
            if (graph.connect(edge.pens[0], edge.pens[1]))
                cost += edge.c;
        }
        System.out.println(cost);
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int[] arr = new int[M];
            for (int j = 0; j < M; j++)
                arr[j] = sc.nextInt();
            for (int j = 0; j < M; j++) {
                int cost = sc.nextInt();
                Edge edge = (j == M-1) ? new Edge(arr[j], arr[0], cost) : new Edge(arr[j], arr[j+1], cost);
                if (!setid.containsKey(edge.id)) {
                    queue.add(edge);
                    setid.put(edge.id, edge);
                }
                edge = setid.get(edge.id);
                if (edge.pens[0] == 0)
                    edge.pens[0] = i + 1;
                else
                    edge.pens[1] = i + 1;
            }
        }
    }
}
