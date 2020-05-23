package CCC.Y2016;

import java.util.*;
import java.io.*;

public class S16Q4_CombiningRiceballs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), max=  0, arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i][i] = readInt(); max = Math.max(max, arr[i][i]);
        }
        int k, l, c;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                k = i+j-1; l = j+1; c=j+i;
                while (k >= j && l <= j + i) {
                    if (arr[j][k] == 0) k--;
                    else if (arr[l][c] == 0) l++;
                    else if (arr[j][k] > arr[l][c]) k--;
                    else if (arr[l][c] > arr[j][k]) l++;
                    else {
                        if (k + 1 == l) {
                            arr[j][c] = arr[j][k] + arr[l][c]; break;
                        } else if (k < l-1 && arr[k+1][l-1] > 0) {
                            arr[j][c] = arr[j][k] + arr[l][c] + arr[k+1][l-1]; break;
                        } else {
                            k--; l++;
                        }
                    }
                }
                max = Math.max(max, arr[j][c]);
            }
        }
        System.out.println(max);
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
