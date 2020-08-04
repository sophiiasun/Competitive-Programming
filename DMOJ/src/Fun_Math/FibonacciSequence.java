package Fun_Math;

import java.util.*;
import java.io.*;

public class FibonacciSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static long[][] arr = {{1, 1}, {1, 0}};
    static long a, b, c, d;
    static int mod = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        long N = Long.parseUnsignedLong(next())-1;

        ArrayList<Integer> list = new ArrayList<>();
        if (N%2==1) {
            N-=1; list.add(1);
        } N = Long.divideUnsigned(N, 2); list.add(2);

        while (N != 1) {
            if (N%2==1) {
                N-=1; list.add(1);
            } N = N>>1; list.add(2);
        }

        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) == 1) add();
            else mul();
        }

        System.out.println(arr[0][0]);
    }

    static void add () {
        a = arr[0][0]; b = arr[0][1]; c = arr[1][0]; d = arr[1][1];
        arr[0][0] = (a+c)%mod;
        arr[0][1] = (b+d)%mod;
        arr[1][0] = a;
        arr[1][1] = b;
    }

    static void mul () {
        a = arr[0][0]; b = arr[0][1]; c = arr[1][0]; d = arr[1][1];
        arr[0][0] = ((a*a)%mod + (b*c)%mod)%mod;
        arr[0][1] = (b*((a+d)%mod))%mod;
        arr[1][0] = (c*((a+d)%mod))%mod;
        arr[1][1] = ((c*b)%mod + (d*d)%mod)%mod;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}
