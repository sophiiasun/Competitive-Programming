package Y2009;

import java.util.*;

public class S09Q2_LightsGoingOnAndOff {
    static int N, L;
    static int[] arr; // true=on, false=off
    static Set<Integer> setP = new HashSet<>(); //set Previous
    static Set<Integer> setN = new HashSet<>(); //set Next
    public static void main(String[] args) {
        init();
        run();
        System.out.println(setN.size());
    }
    static void run(){ //starting row
        setN.add(arr[N-1]);
        int tmp = arr[N-1];
        for (int i = N-2; i >= 0; i--) {
            tmp = arr[i] ^ tmp;
            setN.add(tmp);
        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N];
        for (int r = 0; r < N; r++) {
            int tmp = 0;
            for (int c = 0; c < L; c++) {
                tmp |= sc.nextInt() << (L-1-c);
            }
            arr[r] = tmp;
        }
        setP.add(arr[0]);
    }
}
