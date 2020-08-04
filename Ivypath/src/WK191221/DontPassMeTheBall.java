package WK191221;

import java.util.*;

public class DontPassMeTheBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N < 4)
            System.out.println(0);
        else if (N == 4)
            System.out.println(1);
        else {
            System.out.println(((N-1)*(N-2)*(N-3)>>1)/3);
        }
    }
}
