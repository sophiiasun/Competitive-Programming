package CCC.Y2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S03Q5_TruckingTroublesDS {
    static int C, R, D;
    static int[][] map;
    static HashMap<Integer, Set<Integer>> graph;
    static int max = Integer.MAX_VALUE;
    static int[] groups;
    static int groupi = 0;
    static boolean[] mark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        C = Integer.parseInt(in[0]); R = Integer.parseInt(in[1]); D = Integer.parseInt(in[2]);
        map = new int[R][3];
        for (int i = 0; i < R; i++) {
            in = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(in[0]); map[i][1] = Integer.parseInt(in[1]); map[i][2] = Integer.parseInt(in[2]);
        }
        groups = new int[C+1]; // city number starts from 1
        mark = new boolean[C+1]; // city number starts from 1
        for (int i = 0; i < D; i++)
            mark[Integer.parseInt(br.readLine())] = true;       // 1: it is a destination, 2: it is connected

        // Init groups with city 1
        graph = new HashMap<>();
        graph.put(1, new HashSet<>());
        graph.get(1).add(1);
        groups[1] = 1;
        groupi = 1;

        Arrays.sort(map, (int[] a, int[] b) -> b[2] - a[2]); // sort weight from greatest to least
        doKruskal();
        System.out.println("Fail, could not connect to all destinations");
    }

    static void doKruskal(){
        int count = 0;

        for (int i = 0; i < R; i++) {
            int[] curr = map[i]; //node 1, node 2, weight
            int node1 = curr[0];
            int node2 = curr[1];

            if (groups[node1] == 0 && groups[node2] == 0) { // neither node is connected, create a new group
                groupi ++;
                graph.put(groupi, new HashSet<>());
                graph.get(groupi).add(node1);
                graph.get(groupi).add(node2);
                groups[node1] = groupi;
                groups[node2] = groupi;
            } else if (groups[node1] > 0 && groups[node2] == 0) { // add node2 to node1 group
                graph.get(groups[node1]).add(node2);
                groups[node2] = groups[node1];
                if (groups[node1] == 1 && mark[node2])
                    count ++;
            } else if (groups[node1] == 0 && groups[node2] > 0) { // add node1 to node2 group
                graph.get(groups[node2]).add(node1);
                groups[node1] = groups[node2];
                if (groups[node2] == 1 && mark[node1])
                    count ++;
            } else if (groups[node1] != groups[node2]) { // two nodes are not in the same group, merge group with larger id to the one with smaller id
                int min = Math.min(groups[node1], groups[node2]);
                int max = Math.max(groups[node1], groups[node2]);
                for(int j : graph.get(max)) {
                    groups[j] = min;
                    if (min == 1 && mark[j]) {
                        count++;
                        if (count == D)
                            break;
                    }
                }
                if (count != D) {
                    graph.get(min).addAll(graph.get(max));
                    graph.remove(max);
                }
            } // else two nodes are already in the same group, do nothing

            if (count == D) { // all destinations are connected
                System.out.println(curr[2]);
                System.exit(0);
            }
        }
    }

//    static void init2(){
//        Scanner sc = new Scanner(System.in);
//        C = sc.nextInt(); R = sc.nextInt(); D = sc.nextInt();
//        map = new int[R][3]; par = new HashMap<>();
//        for (int i = 0; i < R; i++) {
//            map[i][0] = sc.nextInt()-1;
//            map[i][1] = sc.nextInt()-1;
//            map[i][2] = sc.nextInt();
//        }
//        counter = D;
//        par.put(-1, -1); destination = new int[D];
//        for (int i = 0; i < D; i++) {
//            destination[i] = sc.nextInt()-1;
//            par.put(destination[i], destination[i]);
//        }
//    }

//    static boolean isConnected(){
//        int compare = par.get(-1);
//        for (int i = 0; i < D; i++) {
//            if (par.get(destination[i]) != compare)
//                return false;
//        }
//        return true;
//    }
}
