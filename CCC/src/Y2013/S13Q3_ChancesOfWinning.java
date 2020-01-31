package Y2013;

import java.util.*;

//6 total games
//check if # games left * 3 (max points per win)
//if true, continue checking combinations
//if not, output 0

public class S13Q3_ChancesOfWinning { //win-3pnts, lose-0 pnts, tie-1 pnts
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int G = sc.nextInt();
        boolean[][] games = new boolean[4][4];
        int[] points = new int[6]; //0-5
        for (int i = 0; i < G; i++) {
            int A = sc.nextInt(), B = sc.nextInt();
            int Sa = sc.nextInt(), Sb = sc.nextInt();
            games[A][B] = games[B][A] = true;
            if (Sa > Sb)
                points[Sa-1]+=3;
            else if (Sb > Sa)
                points[Sb-1]+=3;
            else {
                points[Sb-1]++;
                points[Sa-1]++;
            }
        }

        for (int i = 0; i < 4; i++) {

        }
    }
}
