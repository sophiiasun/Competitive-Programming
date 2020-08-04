package CCC.Y2000;

import java.util.*;
import java.io.*;

public class S00Q5_SheepAndCoyotes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        C[] arr = new C[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new C(readDouble(), readDouble());
        }
        Arrays.sort(arr);
        double min = arr[0].y;
        for (int i = 0; i < n; i++) {
            if (arr[i].y == min) System.out.println("The sheep at " + get(arr[i].x, arr[i].y) + " might be eaten.");
        }
    }

    static String get(double x, double y) {
        return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
    }

    static class C implements Comparable<C> {
        double x, y;
        C (double px, double py) { x = px; y = py; }
        public int compareTo(C other) {
            if (y >= other.y) return 1;
            if (y < other.y) return -1;
            return 0;
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
