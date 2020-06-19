package asmartcloud.ccc.y2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * python bin/ccctest.py asmartcloud.ccc.y2017.Y17Q4MinimumCostFlow D:\SYY\CCC\testdata\2017\s4
 *
 * 1. Kruskal MST. For path with same weight, sort original path before new path. The count of new paths is the days to
 *    test and replace.
 * 2. When D>0, to achieve min cost, the enhanced should only be applied to the last path, i.e. path with highest cost.
 *    It is only possible to use an original path instead of a new path while maintaining the min cost achieved
 *    from step 1 when:
 *        2.1 Kruskal MST stops at a new path
 *        2.2 The new path's cost is less than D
 *        2.3 There is an old path with cost <= D. So after applying enhancer, the old path can have the same value (0) of new
 *        path. And the old path can be used in Kruskal MST, i.e the path can connect two buildings that are not connected
 *        yet, but in step1 can be connected with new path.
 */
public class Y17Q4MinimumCostFlow {
    static int N = 0, M = 0, D = 0;
    static int[] gs;

    static class P implements Comparable<P> {
        int f = 0, t = 0, c = 0, o = 0;
        P(int pf, int pt, int pc, int po) { f = pf; t = pt; c = pc; o = po; }
        public int compareTo(P t) { return (c != t.c) ? c - t.c : o - t.o; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
        String arr[] = br.readLine().split(" ");
        N = gi(arr[0]); M = gi(arr[1]); D = gi(arr[2]);
        P paths[] = new P[M];
        for (int i=0; i<M; i++) {
            arr = br.readLine().split(" ");
            paths[i] = new P(gi(arr[0]), gi(arr[1]), gi(arr[2]), (i<N-1)?0:1);
        }
        Arrays.sort(paths);

        gs = new int[N+1];
        for(int i=1; i<=N; i++) gs[i] = i;
        int days = 0, i = 0, c = 0;
        for (; i<M && c<N-1; i++) {
            int gf = gg(paths[i].f), gt = gg(paths[i].t);
            if (gf != gt) {
                gs[gf] = gt;
                c++;
                if (paths[i].o == 1) days++;
            }
        }

        if (D>0 && paths[i-1].o == 1 && paths[i-1].c < D) {
            int m = paths[i-1].c, s = i;
            gs = new int[N+1];
            for (i=1; i<=N; i++) gs[i] = i;
            for (i=0; i<M && (paths[i].c<m || (paths[i].c==m && paths[i].o==0)); i++) {
                int gf = gg(paths[i].f), gt = gg(paths[i].t);
                if (gf != gt)
                    gs[gf] = gt;
            }
            for (;i<M && paths[i].c<=D;i++) {
                if (paths[i].o == 0) {
                    int gf = gg(paths[i].f), gt = gg(paths[i].t);
                    if (gf != gt) { System.out.println(days-1); return; }
                }
            }
        }

        System.out.println(days);
    }

    static int gg(int c) {
        return gs[c] = (gs[c] == c) ? c : gg(gs[c]);
    }

    static int gi(String s) {
        int n = 0;
        for (int i=0; i<s.length(); i++)
            n = (n<<3) + (n<<1) + s.charAt(i) - '0';
        return n;
    }
}