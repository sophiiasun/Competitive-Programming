import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), a[] = new int[N];
        PriorityQueue<C> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) a[i] = readInt();
        Arrays.sort(a);
        for (int i = 0, j; i < N;) {
            int cnt = 1;
            for (j = i+1; j < N; j++) {
                if (a[i] == a[j]) cnt++;
                else break;
            }
            int tmp = cnt;
            while(!pq.isEmpty() && cnt > 0) {
                C cur = pq.poll();
                if (cur.c < cnt) cnt -= cur.c;
                else if (cur.c == cnt) cnt = 0;
                else { pq.add(new C(cur.w, cur.c-cnt)); cnt=0; }
            }
            pq.add(new C(a[i], tmp)); i = j;
        }
        int ans = 0;
        while (!pq.isEmpty()) ans += pq.peek().c * pq.poll().w;
        System.out.println(ans);
    }

    static class C implements Comparable<C> {
        int w, c;
        C (int nn, int cc) { w = nn; c = cc; }
        public int compareTo(C o) { return o.w - w; }
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