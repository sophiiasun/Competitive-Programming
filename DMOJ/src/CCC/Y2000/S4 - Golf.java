package CCC.Y2000;

import java.util.*;

public class S00Q4_Golf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        int cCnt = sc.nextInt();
        int[] dis = new int[distance+1];
        int[] clubs = new int[cCnt];
        for (int i = 0; i < cCnt; i++)
            clubs[i] = sc.nextInt();
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[0] = 0;
        for (int i = 1; i <= distance; i++) {
            for (int j = 0; j < cCnt; j++) {
                if (i - clubs[j] >= 0 && dis[i-clubs[j]] != Integer.MAX_VALUE)
                    dis[i] = Math.min(dis[i], dis[i-clubs[j]]+1);
            }
        }

        if (dis[distance] == Integer.MAX_VALUE)
            System.out.println("Roberta acknowledges defeat.");
        else
            System.out.println("Roberta wins in "+dis[distance]+" strokes.");
    }
}
