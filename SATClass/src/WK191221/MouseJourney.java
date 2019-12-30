package WK191221;

import java.util.*;

public class MouseJourney { //-1 = trap, -2 = goal
    static int[][] arr;
    static int R, C;

    public static void main(String[] args) {
        init();
        System.out.println(run(R, C));
    }

    static int run(int iR, int iC){
        if (safe(iR-1, iC) && safe(iR, iC-1)) {
            return run(iR-1, C) + run(iR, iC-1);
        } else if (safe(iR-1, iC))
            return run(iR-1, iC);
        else if (safe(iR, iC-1))
            return run(iR, iC-1);
        return 0;
    }

    static boolean safe(int r, int c) {
        return (r>=0 && c>=0 && r<R && c<C && arr[r][c] != -1);
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new int[R][C];
        int x = sc.nextInt();
        for (int i = 0; i < x; i++)
            arr[sc.nextInt()-1][sc.nextInt()-1] = -1;
        arr[R-1][C-1] = -2;
        arr[0][0] = 1;
    }
}
