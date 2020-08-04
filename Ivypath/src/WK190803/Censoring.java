package WK190803;

import java.util.*;

public class Censoring {

    private static Scanner sc = new Scanner(System.in);
    private static int chgLen;

    public static void main(String[] args) {
        String sIn = sc.nextLine();
        String sChg = sc.nextLine();
        chgLen = sChg.length();
        int iLoc = 0;
        while (sIn.substring(iLoc).contains(sChg)) {
            iLoc = sIn.indexOf(sChg);
            sIn = replace(sIn, sChg, iLoc);
            iLoc -= chgLen - 1;
            if(iLoc < 0) iLoc = 0;
            System.out.println("run");
        }
        System.out.println(sIn);
    }

    public static String replace(String sIn, String sChg, int iLoc) {
        sIn = sIn.substring(0, iLoc) + sIn.substring(iLoc + chgLen);
        return sIn;
    }

}