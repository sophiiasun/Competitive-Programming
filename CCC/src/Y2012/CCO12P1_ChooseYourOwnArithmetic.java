package Y2012;

import java.util.*;

public class CCO12P1_ChooseYourOwnArithmetic {
    static int W, D, V;
    static int[] nums;
    static int[] outs;

    public static void main(String[] args) {
        init();

    }

    static void init (){
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        D = sc.nextInt();
        nums = new int[D];
        for (int i = 0; i < D; i++)
            nums[i] = sc.nextInt();
        V = sc.nextInt();
        outs = new int[V];
        for (int i = 0; i < V; i++)
            outs[i] = sc.nextInt();
    }
}
