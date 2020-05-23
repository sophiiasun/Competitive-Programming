package CCC.Y2009;

import java.util.*;

public class S09Q1_CoolNumbers {
    static int S, E;
    static int counter = 0;
    public static void main(String[] args) {
        init();
        run();
        System.out.println(counter);
    }
    static void run() {
        int start = (int)Math.pow(S, 1/6);
        while (start < E) {
            int tmp = (int)Math.pow(start, 6);
            if (tmp >= S && tmp <= E)
                counter++;
            else if (tmp > E)
                break;
            start++;
        }
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        E = sc.nextInt();
    }
}
