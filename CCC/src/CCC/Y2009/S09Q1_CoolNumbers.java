package CCC.Y2009;

import java.util.*;

public class S09Q1_CoolNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(), E = sc.nextInt(), counter = 0;
        int start = (int)Math.pow(S, 1/6);
        while (start < E) {
            int tmp = (int)Math.pow(start, 6);
            if (tmp >= S && tmp <= E)
                counter++;
            else if (tmp > E)
                break;
            start++;
        }
        System.out.println(counter);
    }
}
