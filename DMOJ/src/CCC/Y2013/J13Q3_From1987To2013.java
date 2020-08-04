package CCC.Y2013;

import java.util.*;

public class J13Q3_From1987To2013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean isDistinct;
        String str;
        do {
            isDistinct = true;
            N++;
            str = Integer.toString(N);
            char[] tmp = new char[str.length()];
            for (int i = 0; i < str.length(); i++)
                tmp[i] = str.charAt(i);
            Arrays.sort(tmp);
            for (int i = 0; i < tmp.length-1; i++){
                if (tmp[i] == tmp[i+1])
                    isDistinct = false;
            }
        } while (!isDistinct);
        System.out.println(str);
    }
}
