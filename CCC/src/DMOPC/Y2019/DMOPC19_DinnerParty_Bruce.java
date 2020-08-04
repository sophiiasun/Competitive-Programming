package DMOPC.Y2019;

import java.util.*;
import java.io.*;

public class DMOPC19_DinnerParty_Bruce {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = readInt(), a[] = new int[n], sum = 0, min = Integer.MAX_VALUE, p = -1;
        for(int i=0; i<n; i++) {
            a[i] = readInt(); sum += a[i];
            if(a[i] < min) { min = a[i]; p = i; }
        }

        if(sum % 2 != 0) { System.out.println("NO"); return; }
        int rem[] = new int[n], rit[] = new int[n];
        for(int x = 0; x <= a[p]; x++) {
            rem = Arrays.copyOf(a, n);
            int cnt = x; boolean flag = true;
            for(int i=0, j=p; i<n; i++, j=(j+1)%n) {
                rem[j] -= cnt; rem[(j+1)%n] -= cnt;
                if(rem[j] < 0 || rem[(j+1)%n] < 0) { flag = false; break; }
                rit[j] = cnt; cnt = rem[(j+1)%n];
            }
            for(int i=0; i<n && flag; i++)
                if(rem[i] != 0) flag = false;
            if(flag) {
                System.out.println("YES\n" + (sum/2));
                for(int i=0, j=p; i<n; i++, j=(j+1)%n) {
                    for(int k=0; k<rit[j];  k++)
                        System.out.println(j + " " + (j+1)%n);
                }
                return;
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
