package WK191207;

import java.util.*;

public class Switch {
    static int N;
    static String in;
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, Boolean> status = new HashMap<>();

    static void run(){

    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cnt = 0;
        char next;
        char prev = ' ';
        for (int i = 0; i < N; i++) {
            next = sc.next().charAt(0);
            if (next != prev) {
                if (next == '0')
                    status.put(cnt, false);
                else status.put(cnt, true);
                cnt = 0;
            }
            cnt++;
            in+=next;

        }
    }

    public static void main(String[] args) {
        init();

    }
}
