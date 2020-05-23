package CCC.Y2009;

import java.util.*;
import java.io.*;

public class S09Q4_ShopAndShip { // Minimum Spanning Tree

    static int N, T, K, D;
    static ArrayList<int[]>[] map;
    static HashMap<Integer, Integer> store = new HashMap<>();
    static int[] cost;
    static int min = Integer.MAX_VALUE;
//    static HashMap<Integer, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        map = new ArrayList[N];
        cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        String[] in;
        for (int i = 0; i < T; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0])-1, b = Integer.parseInt(in[1])-1, c = Integer.parseInt(in[2]);
            map[a].add(new int[]{b, c}); map[b].add(new int[]{a, c});
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            in = br.readLine().split(" ");
            store.put(Integer.parseInt(in[0])-1, Integer.parseInt(in[1]));
//            visited.put(Integer.parseInt(in[0])-1, false);
        }
        D = Integer.parseInt(br.readLine())-1;
//        init();
//        if (store.containsKey(D))
//            min = store.get(D);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(D); // curr node, cost
        cost[D] = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] arr : map[curr]) { // destination node, cost
                int newcost = cost[curr] + arr[1];
                if (newcost < cost[arr[0]] /*&& newcost < min*/) {
                    cost[arr[0]] = newcost;
                    queue.add(arr[0]);
//                    if (store.containsKey(arr[0]) && store.get(arr[0]) + cost[arr[0]] < min) {
//                        min = store.get(arr[0]) + cost[arr[0]];
//                        continue;
//                    }
                }
            }
        }

        for (int i : store.keySet()) {
            min = Math.min(min, cost[i]+store.get(i));
        }

        System.out.println(min);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); T = sc.nextInt();
        map = new ArrayList[N];
        cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt()-1, b = sc.nextInt()-1, c = sc.nextInt();
            map[a].add(new int[]{b, c});
            map[b].add(new int[]{a, c});
        }
        K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int tmp = sc.nextInt()-1;
            store.put(tmp, sc.nextInt());
//            visited.put(tmp, false);
        }
        D = sc.nextInt()-1;
    }
}
