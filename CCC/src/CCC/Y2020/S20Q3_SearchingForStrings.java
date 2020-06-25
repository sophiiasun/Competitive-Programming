package CCC.Y2020;

import java.util.*;
import java.io.*;

public class S20Q3_SearchingForStrings {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static String hay, ndl;
    static Set<Long> set = new HashSet<>();
    static int[] hash = new int[26], ori = new int[26];
    static int N, H;

    public static void main(String[] args) throws IOException {
        ndl = readLine(); hay = readLine(); N = ndl.length(); H = hay.length();
        if (N > H) { System.out.println(0); return; } // Needle longer than hay
        for (int i = 0; i < N; i++) { // Obtain needle hash value
            ori[ndl.charAt(i)-'a']++; hash[hay.charAt(i)-'a']++;
        }
        long arr[] = new long[H];
        long n = 1, hv = 31;
        for (int i = 0; i < N; i++) {
            n *= hv;
            if (i==0) arr[i] = hay.charAt(i) - 'a' + 1;
            else arr[i] = arr[i-1]*hv + (hay.charAt(i) - 'a' + 1);
        }
        if (Arrays.equals(ori, hash)) set.add(arr[N-1]);
        for (int i = N; i < H; i++) { // implement rolling hash
            hash[hay.charAt(i)-'a']++; hash[hay.charAt(i-N)-'a']--;
            arr[i] = arr[i-1]*hv + (hay.charAt(i)-'a'+1);
            if (Arrays.equals(ori, hash)) set.add(arr[i] - arr[i-N]*n);
        }

        System.out.println(set.size());
    }

    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
