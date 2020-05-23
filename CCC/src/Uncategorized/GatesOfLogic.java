package Uncategorized;

import java.util.*;
import java.io.*;

public class GatesOfLogic {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[][] arr = new char[200][200]; boolean exit = false; String in = readLine();;
        while (!exit) {
            ArrayList<int[]> start = new ArrayList<>();
            if (in.charAt(0) != '*') {
                for (int i = 0; i < in.length(); i++) {
                    for (int j = 0; j < in.length(); j++) {
                        arr[i][j] = in.charAt(j);
                        if (arr[i][j] == '0' || arr[i][j] == '1') start.add(new int[]{i, j});
                    }
                    in = readLine();
                }

            }
            if (in.charAt(0) == '*'){
                in = readLine();
                if (in.charAt(0) == '*') exit = true;
            }
        }

    }

    static void run () {

    }

    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
