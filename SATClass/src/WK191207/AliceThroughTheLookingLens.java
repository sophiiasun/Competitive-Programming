package WK191207;

import java.util.*;

public class AliceThroughTheLookingLens {
    static Scanner sc = new Scanner(System.in);
    static int T = sc.nextInt();
    static int m, X, Y;
    static int mag;
    public static void main(String[] args) {
        for (int i = 0; i < T; i++) {
            m = sc.nextInt();
            X = sc.nextInt();
            Y = sc.nextInt();
            int cnt = 0;
            mag = (int)Math.pow(5, m);
            run(X, Y, cnt);
        }
    }

    static void run(int iX, int iY, int cnt){
        int tmp = (int)Math.pow(5, m-1-cnt);
        int xt, yt;
        if (cnt < m-1) {
            xt = iX / tmp;
            yt = iY / tmp;
        } else {
            xt = iX;
            yt = iY;
        }
        if (xt==1&&yt==0 || xt==2&&yt==0 || xt==2&&yt==1 || xt==3&&yt==0){
            System.out.println("crystal");
        } else if (cnt<m-1 && (xt==1&&yt==1 || xt==2&&yt==2 || xt==3&&yt==1))
            run(iX%tmp, iY%tmp, cnt+1);
        else
            System.out.println("empty");
    }

}


