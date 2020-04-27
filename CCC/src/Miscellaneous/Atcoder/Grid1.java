package Miscellaneous.Atcoder;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Grid1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" "); double mod = 1e9+7;
        int H = Integer.parseInt(in[0]), W = Integer.parseInt(in[1]);
        int[][] arr = new int[H+1][W+1];
        arr[1][1] = 1;
        for (int i = 1; i <= H; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= W; j++)
                if (line[j-1] == '.') arr[i][j] += ((arr[i-1][j]+arr[i][j-1])%mod);
        }

        System.out.println(arr[H][W]);
    }
}
