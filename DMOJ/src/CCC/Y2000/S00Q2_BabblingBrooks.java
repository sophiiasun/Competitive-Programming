package CCC.Y2000;

import java.util.*;
import java.io.*;

public class S00Q2_BabblingBrooks {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), next;
        LinkedList<Double> ll = new LinkedList<>();
        for (int i = 1; i <= N; i++) ll.add((double)readInt());
        next = readInt();
        while (next != 77) {
            int stream = readInt();
            if (next == 99) {
                double per = readDouble() / 100.0, val = ll.get(stream-1);
                ll.set(stream-1, per * val);
                ll.add(stream, (1.0-per) * val);
            } else {
                ll.set(stream-1, ll.get(stream-1) + ll.get(stream));
                ll.remove(stream);
            }
            next = readInt();
        }
        for (double i : ll) {
            System.out.print((int)Math.round(i) + " ");
        } System.out.println();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}
