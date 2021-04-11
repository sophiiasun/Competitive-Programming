package CCC.Y2012;

import java.util.*;

public class S12Q2_AromaticNumbers {
    public static void main(String[] args) {
        String str = "IVXLCDM";
        int[] arr = {1, 5, 10, 50, 100, 500, 1000};
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

        String[] astr = new String[in.length()/2];
        for (int i = 0; i < in.length()/2; i++)
            astr[i] = in.substring(i<<1, (i<<1)+2);

        int total = 0;
        for (int i = 0; i < astr.length - 1; i++) {
            int index = str.indexOf(astr[i].charAt(1));
            int num = Character.getNumericValue(astr[i].charAt(0));
            if (index >= str.indexOf(astr[i+1].charAt(1)))
                total += arr[index] * num;
            else
                total -= arr[index] * num;
        }
        total += arr[str.indexOf(astr[astr.length-1].charAt(1))] * Character.getNumericValue(astr[astr.length-1].charAt(0));

        System.out.println(total);
    }
}
