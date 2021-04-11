package CCO.Y2011;

import java.util.*;

public class p2_VampireTunnels {

    static int S, N, E;
    static ArrayList<int[]>[] map;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        N = sc.nextInt();
        E = sc.nextInt();
        map = new ArrayList[N];
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        int a, b, c, d;
        for (int i = 0; i < E; i++) {
            a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); d = sc.nextInt();
            if (d == 0 || c <= S) {
                map[a].add(new int[]{b, c, d});
                map[b].add(new int[]{a, c, d});
            }
        }

        int[][] dis = new int[N][S+1];
        for (int i = 0; i < N; i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // curr: curr node, distance, sunlight
        int[] curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr[0] == N-1 && curr[2] <= S && curr[1] < MIN)
                MIN = curr[1];
            for (int[] arr : map[curr[0]]) { // arr: destination node, distance, above or below ground
                // above ground
                int sun = curr[2]+arr[1]; // sunlight
                int tmp = curr[1]+arr[1]; // distance
                if (arr[2] == 1 && sun <= S && tmp<MIN && tmp<dis[arr[0]][sun]) {
                    dis[arr[0]][sun] = tmp;
                    queue.add(new int[]{arr[0], tmp, sun});
                // below ground
                } else if (arr[2] == 0 && curr[2]<=S && tmp<MIN && tmp< dis[arr[0]][curr[2]]) {
                    dis[arr[0]][curr[2]] = tmp;
                    queue.add(new int[]{arr[0], tmp, curr[2]});
                }
            }
        }

        if (MIN != Integer.MAX_VALUE)
            System.out.println(MIN);
        else
            System.out.println(-1);
    }
}
