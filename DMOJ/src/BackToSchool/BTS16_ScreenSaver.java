package BackToSchool;

import java.util.*;
import java.io.*;

public class BTS16_ScreenSaver {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int C = readInt(), R = readInt(), T = readInt(), pos[] = new int[2]; char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String in = readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = in.charAt(j);
                if (arr[i][j] == 'O') { pos[0] = i; pos[1] = j; }
            }
        }

        char status = 'R';
        for (int i = 1; i <= T; i++) {
            if (status == 'R') {
                if (pos[1] + 1 < C) pos[1]++;
                else { System.out.println("The observer leaves the grid after " + i + " tick(s)."); return; }
            } else if (status == 'L') {
                if (pos[1] - 1 >= 0) pos[1]--;
                else { System.out.println("The observer leaves the grid after " + i + " tick(s)."); return; }
            } else if (status == 'U') {
                if (pos[0] - 1 >= 0) pos[0]--;
                else { System.out.println("The observer leaves the grid after " + i + " tick(s)."); return; }
            } else {
                if (pos[0] + 1 < R) pos[0]++;
                else { System.out.println("The observer leaves the grid after " + i + " tick(s)."); return; }
            }
            if (arr[pos[0]][pos[1]] == '\\') {
                if (status == 'R') status = 'D';
                else if (status == 'L') status = 'U';
                else if (status == 'U') status = 'L';
                else status = 'R';
                arr[pos[0]][pos[1]] = '/';
            } else if (arr[pos[0]][pos[1]] == '/') {
                if (status == 'R') status = 'U';
                else if (status == 'L') status = 'D';
                else if (status == 'U') status = 'R';
                else status = 'L';
                arr[pos[0]][pos[1]] = '\\';
            } else if (arr[pos[0]][pos[1]] == '-') {
                if (status == 'U') { status = 'D'; arr[pos[0]][pos[1]] = '|'; }
                else if (status == 'D') { status = 'U'; arr[pos[0]][pos[1]] = '|'; }
            } else if (arr[pos[0]][pos[1]] == '|'){
                if (status == 'R') { status = 'L'; arr[pos[0]][pos[1]] = '-'; }
                else if (status == 'L') { status = 'R'; arr[pos[0]][pos[1]] = '-'; }
            }
        }
        System.out.println("The observer stays within the grid.");
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
