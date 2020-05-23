package GFSSOC;

import java.util.*;
import java.io.*;

public class NightmareAThon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), Q = readInt();
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = readInt();
        int[] leftMax = new int[N+1], rightMax = new int[N+2], leftFreq = new int[N+1], rightFreq = new int[N+2];
        for (int i = 1; i <= N; i++) {
            if (arr[i] > leftMax[i-1]) {
                leftFreq[i] = 1; leftMax[i] = arr[i];
            } else if (arr[i] == leftMax[i-1]) {
                leftFreq[i] = leftFreq[i-1] + 1; leftMax[i] = arr[i];
            } else {
                leftFreq[i] = leftFreq[i-1]; leftMax[i] = leftMax[i-1];
            }
        }
        for (int i = N; i > 1; i--) {
            if (arr[i] > rightMax[i+1]) {
                rightFreq[i] = 1; rightMax[i] = arr[i];
            } else if (arr[i] == rightMax[i+1]) {
                rightFreq[i] = rightFreq[i+1] + 1; rightMax[i] = arr[i];
            } else {
                rightFreq[i] = rightFreq[i+1]; rightMax[i] = rightMax[i+1];
            }
        }
        for (int i = 0; i < Q; i++) {
            int a = readInt(), b = readInt();
            if (leftMax[a-1] > rightMax[b+1]) System.out.println(leftMax[a-1] + " " + leftFreq[a-1]);
            else if (leftMax[a-1] < rightMax[b+1]) System.out.println(rightMax[b+1] + " " + rightFreq[b+1]);
            else System.out.println(leftMax[a-1] + " " + (leftFreq[a-1] + rightFreq[b+1]));
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
