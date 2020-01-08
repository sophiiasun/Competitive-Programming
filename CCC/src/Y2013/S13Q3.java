package Y2013;

import java.util.*;

//6 total games
//check if # games left * 3 (max points per win)
//if true, continue checking combinations
//if not, output 0

public class S13Q3 { //win - 3pnts, lose - 0 pnts, tie - 1 pnts
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), G = sc.nextInt();
        int[] scores = new int[4];

        for (int i = 0; i < G; i++) {
            int ind1 = sc.nextInt(), ind2 = sc.nextInt();
            int sco1 = sc.nextInt(), sco2 = sc.nextInt();
            if (sco1 > sco2)
                scores[ind1] += 3;
            else if (sco1 == sco2) {
                scores[ind1] += 1;
                scores[ind2] += 1;
            } else
                scores[ind2] += 3;
        }

//        for (int)
//
//        if ()
    }
}
