package S2005;

import java.util.*;

public class S05Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tx = sc.nextInt();
        int ty = sc.nextInt();
        int X = 0, Y = 0;
        int ix = sc.nextInt(), iy = sc.nextInt();
        while (ix !=0 && iy != 0){
            if (X + ix < 0) X = 0;
            else if (X + ix > tx) X = tx;
            else X += ix;
            if (Y + iy < 0) Y = 0;
            else if (Y + iy > ty) Y = ty;
            else Y += iy;
            System.out.println(X + " " + Y);
            ix = sc.nextInt();
            iy = sc.nextInt();
        }
    }
}
