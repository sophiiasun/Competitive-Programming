package S2019;

import java.util.*;

public class S2019Q2 {

    private static ArrayList<Integer> iSet = new ArrayList<>();
    private static int cnt;

    public static void main(String[] args) {
        findPrimeSet();
        
    }

    private static void findPrimeSet() {
        iSet.add(2);
        iSet.add(3);
        iSet.add(5);
        iSet.add(7);
        iSet.add(11);
        cnt = 5;
        for(int i = 13; i <= 1000; i+=2) {
            int tmp = (int) Math.round(Math.sqrt(i));
            boolean bln = true; //true if prime
            for (int j = 0; j <= getSetNum(tmp); j++) {
                if (i % iSet.get(j) == 0) {
                    bln = false;
                    break;
                }
            }
            if (bln) {
                cnt++;
                iSet.add(i);
            }
        }
    }

    private static int getSetNum(int a) {
        if (iSet.contains(a)) return iSet.indexOf(a);
        else {
            for(int i = a - 1; i > 0; i--) {
                if (iSet.contains(i)) return iSet.indexOf(i);
            }
        }
        return 0;
    }

}
