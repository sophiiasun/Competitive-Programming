package DMOPC.Y2019;

import java.util.*;
import java.io.*;

public class DMOPC19_DinnerParty {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), a[] = new int[n], sum = 0, min = Integer.MAX_VALUE, p = -1;
        for (int i = 0; i < n; i++) {
            a[i] = readInt(); sum += a[i];
            if (a[i] < min) { min = a[i]; p = i; }
        }

        if (sum % 2 != 0) { System.out.println("NO"); return; } // Odd number of orders
        int[] rem, rit = new int[n];
        for (int t = 0; t <= a[p]; t++) { // Use smallest dish count and brutal force all options
            rem = Arrays.copyOf(a, n);
            int cnt = t; boolean b = true;
            for (int i = 0, j = p; i < n; i++, j = (j+1)%n) { // Go around the table
                int tmp = (j+1)%n;
                rem[j] -= cnt; rem[tmp] -= cnt;
                if (rem[j] < 0 || rem[tmp] < 0) { b = false; break; } // Doesn't have enough dishes; break
                rit[j] = cnt; cnt = rem[tmp];
            }
            for (int i = 0; i < n && b; i++) { // Check if there are no more dishes left
                if (rem[i] != 0) b = false;
            }
            if (b) { // If option is valid, output "YES" along with order
                System.out.println("YES\n" + (sum/2));
                for (int i = 0, j = p; i < n; i++, j = (j+1)%n) {
                    for (int k = 0; k < rit[j]; k++) System.out.println(j + " " + ((j+1)%n));
                } return;
            }
        }
        System.out.println("NO");
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
