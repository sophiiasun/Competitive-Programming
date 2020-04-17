import java.util.*;

public class CCO2012Q2 {

    static int S, N, E;
    static ArrayList<int[]>[] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt(); N = sc.nextInt(); E = sc.nextInt();
        map = new ArrayList[N];
        for (int i = 0; i < N; i++)
            map[i] = new ArrayList<>();
        for (int i = 0; i < E; i++)
            map[sc.nextInt()].add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});

        int out = doBFS();
        System.out.println(out);
    }

    static int doBFS(){
        boolean[] vis = new boolean[N];
        vis[0] = true;
        queue.add(new int[]{0, 0, 0}); //curr node, distance, sunlight
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] arr : map[curr[0]]) { //arr: destination node, distance, above ground or not
                if (!vis[arr[0]]) {
                    int[] next = Arrays.copyOf(curr, 3);
                    if (arr[2] == 1 && arr[1] + curr[2] > S)
                        continue;
                    if (arr[2] == 1 && arr[1] + curr[2] <= S) {
                        next[0] = arr[0]; // node
                        next[2] += arr[1]; // sunlight
                        next[1] += arr[1]; // distance
                    } else if (arr[2] == 0){
                        next[0] = arr[0]; // node
                        next[1] += arr[1]; // distance
                    }
                    if (next[0] == N-1)
                        return next[1];
                    else {
                        queue.add(next);
                        vis[next[0]] = true;
                    }
                }
                vis[arr[0]] = true;
            }
        }
        return -1;
    }


//    static class Tunnel {
//        int d, s; boolean t;
//        public Tunnel(int pd, int ps, boolean pt) {
//            this.d = pd; this.s = ps; this.t = pt;
//        }
//    }
}
