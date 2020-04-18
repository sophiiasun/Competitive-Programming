package Y2015;

import java.util.*;

// WORKING VERSION

public class S15Q4_ConvexHull2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(), N = sc.nextInt(), M = sc.nextInt();
        ArrayList<int[]>[] map = new ArrayList[N];
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        int a, b, c, d;
        for (int i = 0; i < M; i++) {
            a = sc.nextInt()-1; b = sc.nextInt()-1; c = sc.nextInt(); d = sc.nextInt();
            map[a].add(new int[]{b, c, d});
            map[b].add(new int[]{a, c, d});
        }
        int A = sc.nextInt()-1, B = sc.nextInt()-1;
        int[][] distance = new int[N][K];
        for (int i = 0; i < N; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[A][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A, 0, 0}); // curr node, distance, hull
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] arr : map[curr[0]]) { // destination node, distance, hull
                if (curr[2] + arr[2] < K && curr[1] + arr[1] < distance[arr[0]][curr[2]+arr[2]]) {
                    queue.add(new int[]{arr[0], curr[1] + arr[1], curr[2] + arr[2]});
                    distance[arr[0]][arr[2]+curr[2]] = curr[1] + arr[1];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = K-1; i >= 0; i--) {
            if (distance[B][i] < min)
                min = distance[B][i];
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
