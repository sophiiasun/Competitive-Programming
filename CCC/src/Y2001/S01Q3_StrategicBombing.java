package Y2001;

import java.util.*;

public class S01Q3_StrategicBombing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] map = new boolean[26][26];
        String in = "";
        while (in != "**") {
            in = sc.next();
            map[in.charAt(0)][in.charAt(1)] = true;
            map[in.charAt(1)][in.charAt(0)] = true;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (map[i][j]) {
//                    if (doBFS(map))
//                        count++;
                }
            }
        }
    }

//    static boolean doBFS(boolean[][] map){ //return True if road can be removed
//
//    }
}
