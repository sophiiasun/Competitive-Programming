package S2019;

import java.util.*;

public class S2019Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean bH = false;
        boolean bV = false;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'H') bH = !bH;
            else bV = !bV;
        }
        if (!bH && !bV) {
            System.out.println("1 2");
            System.out.println("3 4");
        } else if (!bH && bV) {
            System.out.println("2 1");
            System.out.println("4 3");
        } else if (bH && !bV) {
            System.out.println("3 4");
            System.out.println("1 2");
        } else {
            System.out.println("4 3");
            System.out.println("2 1");
        }
    }
}
