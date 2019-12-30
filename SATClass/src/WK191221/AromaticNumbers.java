package WK191221;

import java.util.*;

public class AromaticNumbers { //largest to smallest
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

//        myway(in);
        dadway(in);
    }

    static void dadway(String in){
        int[] arr = new int[in.length()];
        for (int i = 0; i < in.length(); i++) {
            arr[i] = in.charAt(i) - '0';
            i++;
            switch(in.charAt(i)) {
                case 'I': arr[i] = 1; break;
                case 'V': arr[i] = 5; break;
                case 'X': arr[i] = 10; break;
                case 'L': arr[i] = 50; break;
                case 'C': arr[i] = 100; break;
                case 'D': arr[i] = 500; break;
                case 'M': arr[i] = 1000; break;
            }
        }

        int total = 0;
        for (int i = 0; i < in.length()-3; i+=2) {
            if (arr[i+1] >= arr[i+3])
                total += (arr[i] * arr[i+1]);
            else
                total -= (arr[i] * arr[i+1]);
        }
        total += arr[in.length()-2] * arr[in.length()-1] ;
        System.out.println(total);
    }

    static void myway(String in){
        String str = "IVXLCDM";
        int[] arr = {1, 5, 10, 50, 100, 500, 1000};
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
