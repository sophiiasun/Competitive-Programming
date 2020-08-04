package Alghorithms;

import java.util.*;
import java.io.*;

public class MiniatureSudoku {

    static int[][] arr = new int[4][4];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { //Character to integer: -49

        int N = br.read() - 97;
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr, 0);
            init();

        }
    }

    static void run(){

    }

    static void init() throws IOException {
        for (int j = 0; j < 4; j++) {
            String in = br.readLine();
            for (int k = 0; k < 4; k++) {
                if (in.charAt(k) == 'X')
                    arr[j][k] = 0;
                else
                    arr[j][k] = in.charAt(k) - 49;
            }
        }
    }
}
