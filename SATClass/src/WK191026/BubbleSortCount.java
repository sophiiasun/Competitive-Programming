package WK191026;

import java.util.*;

public class BubbleSortCount { //count the number of times an element needs to jump forward, the max number counted is the output
    static int N;
    static int[] arr, sA;
    public static void main(String[] args) {
        init();
        run();
    }
    static void run() { //execute BubbleSort here
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) continue;
            else if(isFront(i)) {

            }
        }
    }
    static boolean isFront(int a) { //only need to count the movements heading towards the front of the array
        //one move forwards is one complete loop through, meaning one print "moo"
        do {

        }
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        sA = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            sA[i] = tmp;
        }
        Arrays.sort(sA);
    }
}
