package Fun_Math;

import java.util.*;
import java.io.*;

public class APlusB_Hard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        for (int n = 0; n < N; n++) {
            char[] a = next().toCharArray(), b = next().toCharArray();
            int AS=0, AE = a.length, BS=0, BE = b.length;
            if (a[0]=='-') AS = 1; // Check if 'a' is negative
            if (b[0]=='-') BS = 1; // Check if 'b' is negative

            if (BE-BS > AE-AS) { // Make 'a' the bigger number
                char[] tmp = a; a = b; b = tmp;
                int t = AS; AS = BS; BS = t;
                t = AE; AE = BE; BE = t;
            } else if (BE-BS == AE-AS) {
                for (int i = 0; i < AE-AS; i++) {
                    if (a[AS+i] < b[BS+i]) {
                        char[] tmp = a; a = b; b = tmp;
                        int t = AS; AS = BS; BS = t;
                        t = AE; AE = BE; BE = t;
                        break;
                    } else if (a[AS+i] > b[BS+i]) break;
                }
            }

            char[] ans = new char[AE-AS+2]; int next;
            if (AS == 0 && BS == 0 || AS == 1 && BS == 1) { // PLUS TOGETHER
                int carry = 0;
                for (int i = 1; i <= AE-AS; i++) { // Loop through each digit from the end of 'a'
                    next = a[AE-i] - '0' + carry; // Add only value from 'a'
                    if (i <= BE - BS) next += b[BE-i] - '0'; // If 'b' has value, add from 'b'
                    carry = next / 10; next %= 10; // Find carry-over value
                    ans[AE-AS-i+2] = (char)next;
                }
                ans[1] = (char)carry;
                if (AS==1) ans[0] = '-';
            } else {                                        // SUBTRACTION
                int over = 0;
                for (int i = 1; i <= AE-AS; i++) { // Loop through each digit from the end of 'a'
                    next = a[AE-i] - '0'; // Check if borrowed from prev digit
                    if (i <= BE - BS) next -= (b[BE - i] - '0') + over; // Needs to borrow
                    else next -= over; // Doesn't need to borrow
                    if (next < 0) { // Get 10 from next digit
                        next += 10; over = 1;
                    } else over = 0;
                    ans[AE-AS-i+2] = (char)next;
                }
                if (a[0]=='-') ans[0] = '-';
            }

            int space = AS; int tmp = (ans[0]=='-') ? 1 : 0;
            while (ans[space] == 0 && space <= AE - tmp)
                space++;
            if (ans[0] == '-' && (space < ans.length-1 || ans[space] != 0)) System.out.print(ans[0]);
            for (int i = space; i < ans.length; i++) System.out.print((int)ans[i]);
            System.out.print("\n");
        }
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
