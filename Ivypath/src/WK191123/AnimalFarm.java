package WK191123;

import java.util.*;

public class AnimalFarm {
    static int M;
    static HashMap<String, Edge> map = new HashMap<>();
    static HashMap<Integer, Set<Pen>> groups = new HashMap<>();
    static int[] groupIDs;
    static int groupID;
    static Pen pen0 = new Pen(0);
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int c;
        String id;
        List<Pen> pens = new ArrayList<>();
        Edge(int ps, int pe, int pc){
            s = Math.min(ps, pe);
            c = pc;
            e = Math.max(pe, ps);
            id = s + "+" + e;
        }
        @Override
        public int compareTo(Edge o){
            return c - o.c;
        }
    }

    static class Pen{
        ArrayList<Edge> edges = new ArrayList<>();
        int id;
        Pen(int pid){
            id = pid;
        }
    }

    public static void main(String[] args) {
        init();
        int cost = 0;
        int exp = M;
        Pen pen1, pen2;
        while(!(groups.size() == 1 && groups.get(1).size() == exp)) {
            Edge edge = queue.poll();
            pen1 = edge.pens.get(0);
            if (edge.pens.size() == 2)
                pen2 = edge.pens.get(1);
            else {
                pen2 = pen0;
                exp = M+1;
            }
            if (joinPens(pen1, pen2)) {
                cost += edge.c;
            }
        }
        System.out.println(cost);
    }

    static boolean joinPens(Pen pen1, Pen pen2){ //return true if something was joined together
        if (groupIDs[pen1.id] == groupIDs[pen2.id] && groupIDs[pen1.id] != 0) {
            return false;
        }
        if (groupIDs[pen1.id] == groupIDs[pen2.id] && groupIDs[pen1.id] == 0) {
            groupID++;
            groupIDs[pen1.id] = groupID;
            groupIDs[pen2.id] = groupID;
            HashSet<Pen> set = new HashSet<>();
            set.add(pen1);
            set.add(pen2);
            groups.put(groupID, set);
        } else if (groupIDs[pen1.id] == 0 && groupIDs[pen2.id] != 0) {
            groups.get(groupIDs[pen2.id]).add(pen1);
            groupIDs[pen1.id] = groupIDs[pen2.id];
        } else if (groupIDs[pen1.id] != 0 && groupIDs[pen2.id] == 0) {
            groups.get(groupIDs[pen1.id]).add(pen2);
            groupIDs[pen2.id] = groupIDs[pen1.id];
        } else if (groupIDs[pen1.id] != 0 && groupIDs[pen2.id] != 0) {
            int min = Math.min(groupIDs[pen1.id], groupIDs[pen2.id]);
            int max = Math.max(groupIDs[pen1.id], groupIDs[pen2.id]);
            groups.get(min).addAll(groups.get(max));
            Set<Pen> set = groups.get(max);
            groups.remove(max);
            for (Pen i : set)
                groupIDs[i.id] = min;
        }
        return true;
    }

    public static void init(){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            Pen pen = new Pen(i+1);
            int tmp = sc.nextInt();
            int[] arr = new int[tmp];
            for (int j = 0; j < tmp; j++)
                arr[j] = sc.nextInt();
            for (int j = 0; j < tmp; j++){
                int cost = sc.nextInt();
                Edge edge = (j == tmp-1) ? new Edge(arr[j], arr[0], cost) : new Edge(arr[j], arr[j + 1], cost);
                if (!map.containsKey(edge.id)) {
                    map.put(edge.id, edge);
                    queue.add(edge);
                }
                edge = map.get(edge.id);
                edge.pens.add(pen);
                pen.edges.add(edge);
            }
        }
        groupIDs = new int[M+1];
    }
}
