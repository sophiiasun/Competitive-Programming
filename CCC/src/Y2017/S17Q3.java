package Y2017;

import java.util.*;

public class S17Q3 {
    static int N;
    static HashMap<Integer, Integer> input = new HashMap<>();
    static HashMap<Integer, Integer> heights = new HashMap<>();
    public static void main(String[] args){
        init();
    }
    static void run(){
        //max is the max length
        //cnt is the number of different heights
        int h = 0, c = 0, max = 0, cnt = 0;
        if (input.size() == 1) {
            max = N/2;
            cnt = 1;
        } else {

        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int in = sc.nextInt();
            if (input.containsKey(in)) {
                int tmp = input.get(in);
                tmp++;
                input.put(in, tmp);
            } else {
                input.put(in, 1);
            }
        }
    }
}
