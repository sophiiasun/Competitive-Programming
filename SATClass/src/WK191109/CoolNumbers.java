package WK191109;

import java.util.*;

public class CoolNumbers {
    static int S, E;
    static int counter = 0;
    public static void main(String[] args) {
        init();
        run(1);
        System.out.println(counter);
    }
    static void run(int iS) {
        if (Math.pow(iS, 6) >= E) {
            return;
        }
        int cnt = 1; // number of exponent 6's
        int numN = (int)Math.pow(iS, cnt * 6); //starting number
        int numP = -1; //numN = numNew, numP = numPrevious
        while (numN <= E) {
            if (numP == numN)
                break;
            counter++;
            cnt++;
            numP = numN;
            numN = (int)Math.pow(iS, cnt * 6);
        }
        run(iS+1);
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        E = sc.nextInt();
    }
}
