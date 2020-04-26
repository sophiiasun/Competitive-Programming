package Y2010;

import java.util.*;

public class S10Q2_HuffmanEncoding {
    static int K;
    static char[] arrC;
    static String[] arrS;
    static String in, out = "";
    public static void main(String[] args) {
        init();
        run();
    }
    static void run(){
        while (in.length() > 0) {
            int index = getNext();
            out += arrC[index];
            int size = arrS[index].length();
            in = in.substring(size);
        }
        System.out.println(out);
    }
    static int getNext() {
        for (int i = 0; i < K; i++) {
            if (in.indexOf(arrS[i]) == 0)
                return i;
        }
        return -1;
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        arrC = new char[K];
        arrS = new String[K];
        for (int i = 0; i < K; i++) {
            arrC[i] = sc.next().charAt(0);
            arrS[i] = sc.next();
        }
        in = sc.next();
    }
}
