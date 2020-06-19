package Alghorithms;

import java.io.*;
import java.util.*;

public class binarySearch {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public static void main(String[] args) throws IOException {
        int n = readInt();

    }

//    static int binSearch(int n) {
//        int s = 0, e = arr.length, mid;
//        while (s < e) {
//            mid = (s+e) >> 1;
//
//        }
//    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
