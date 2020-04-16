import java.util.*;

public class HideNSeek {

    static int N, M, T;
    static int[][] arr;
    static ArrayList<int[]> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        arr = new int[N][M];
        int cnt = 1;
        ArrayList<int[]> pos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String in = sc.next();
            for (int j = 0; j < M; j++) {
                if (in.charAt(j)==46) arr[i][j] = 0;
                else if (in.charAt(j)==88) arr[i][j] = -1;
                else {
                    arr[i][j] = cnt++;
                    pos.add(new int[]{i, j, 0});
                }
            }
        }
        for (int[] a : pos)
            doBFS(a);
        doKruskal();
    }

    static void doKruskal() {
        int distance = 0;
        Collections.sort(edges, (int[] a, int[] b) -> a[2] - b[2]);
        int[] par = new int[T+2];
        for (int i = 1; i <= T+1; i++)
            par[i] = i;
        int edgeCnt = 0;
        for (int i = 0; i <= edges.size(); i++) {
            if (par[edges.get(i)[0]]!=par[edges.get(i)[1]]) {
                distance += edges.get(i)[2];
                mergeSets(par[edges.get(i)[0]], par[edges.get(i)[1]], par);
                edgeCnt++;
            }
            if (edgeCnt == T) break;
        }
        System.out.println(distance);
    }

    static void mergeSets(int A, int B, int[] par) {
        for (int i = 0; i < par.length; i++) {
            if (par[i] == A)
                par[i] = B;
        }
    }

    static void doBFS(int[] curr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(curr);
        boolean[][] vis = new boolean[N][M];
        vis[curr[0]][curr[1]] = true;
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (next[0] != curr[0] && next[1] != curr[1] && arr[next[0]][next[1]] > 0)
                edges.add(new int[]{arr[curr[0]][curr[1]], arr[next[0]][next[1]], next[2]});
            if (next[0] + 1 < N && !vis[next[0] + 1][next[1]] && arr[next[0] + 1][next[1]] >= 0) {
                queue.add(new int[]{next[0] + 1, next[1], next[2]+1});
                vis[next[0] + 1][next[1]] = true;
            }
            if (next[0] - 1 >= 0 && !vis[next[0] - 1][next[1]] && arr[next[0] - 1][next[1]] >= 0) {
                queue.add(new int[]{next[0] - 1, next[1], next[2]+1});
                vis[next[0] - 1][next[1]] = true;
            }
            if (next[1] + 1 < M && !vis[next[0]][next[1] + 1] && arr[next[0]][next[1] + 1] >= 0) {
                queue.add(new int[]{next[0], next[1] + 1, next[2]+1});
                vis[next[0]][next[1] + 1] = true;
            }
            if (next[1] - 1 >= 0 && !vis[next[0]][next[1] - 1] && arr[next[0]][next[1] - 1] >= 0) {
                queue.add(new int[]{next[0], next[1] - 1, next[2]+1});
                vis[next[0]][next[1] - 1] = true;
            }
        }
    }
}
