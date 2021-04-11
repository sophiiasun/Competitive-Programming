package CCC.Y2020;

import java.util.*;
import java.io.*;

public class S20Q4_SwappingSeats {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static int L;

    public static void main(String[] args) throws IOException {
        char[] in = br.readLine().trim().toCharArray(); L=in.length;
        int A=0, B=0, C=0, pA[]=new int[L<<1], pB[]=new int[L<<1], pC[]=new int[L<<1];

        if (in[0]=='A') { A++; pA[0] = 1; }
        else if (in[0]=='B') { B++; pB[0] = 1; }
        else { C++; pC[0] = 1; }

        for (int i = 1; i < L << 1; i++) { // Count
            if (in[i%L]=='A') { A++; U(pA, pB, pC, i); }
            else if (in[i%L]=='B') { B++; U(pB, pA, pC, i); }
            else { C++; U(pC, pA, pB, i); }
        }
        A>>=1; B>>=1; C>>=1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < L; i++) {
            int pos = i+A;
            int nonA = A - pA[pos] + pA[i];
            // Try A-B-C
            int nonB = pC[pos+B] - pC[pos];
            ans = Math.min(ans, nonA + nonB);
            // Try A-C-B
            int nonC = pB[pos+C] - pB[pos];
            ans = Math.min(ans, nonA + nonC);
        }
        System.out.println(ans);
    }

    static void U (int[] arr1, int[] arr2, int[] arr3, int i) {
        arr1[i] = arr1[i-1] + 1;
        arr2[i] = arr2[i-1];
        arr3[i] = arr3[i-1];
    }
}
