package WK191109;

import java.util.*;

public class TheLightsGoingOnAndOff {
    static int N, L;
    static int[] arr; // true=on, false=off
    static Set<Integer> setP = new HashSet<>(); //set Previous
    static Set<Integer> setN = new HashSet<>(); //set Next
    static Set<Integer> tmpS = new HashSet<>(); //tmp Set
    public static void main(String[] args) {
        init();
        run();
        System.out.println(setP.size());
    }
    static void run(){ //starting row
        for (int i = 1; i < N; i++) {
            setN.add(arr[i]);
            for (int tmp : setP)
                setN.add(arr[i] ^ tmp);
            tmpS = setP;
            setP = setN;
            setN = tmpS;
            setN.clear();
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
