package Y2011;

import java.util.*;

public class S11Q5_Switch {

    static int[] arr;
    static int N;
    static int counter = 0;
    static Set<String> set;
    static Queue<int[]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.next());
            if (arr[i] == 1)
                counter++;
        }

        if (counter==0) System.out.println(0);
        else {
            int out = doBFS();
            System.out.println(out);
        }
    }

    static int doBFS(){
        set = new HashSet<>();
        queue = new LinkedList<>();
        set.add(getString(arr));
        queue.add(arr);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < N; i++) {
                if (curr[i] == 0) {
                    int[] next = Arrays.copyOf(curr, N+1);
                    next[N]++;
                    if (check(next, i) >= 4)
                        change(next, i);
                    if (done(next))
                        return next[N];
                }
            }
        }
        return -1;
    }

    static String getString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(arr[i]);
        return sb.toString();
    }

    static boolean done(int[] arr) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) return false;
        }
        return true;
    }

    static void change(int[] arr, int pos) {
        arr[pos] = 0;
        counter--;
        for (int i = pos+1; i < N; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else break;
        }
        for (int i = pos-1; i >= 0; i--) {
            if (arr[i] == 1) arr[i] = 0;
            else break;
        }
//        String tmp = getString(arr);
//        if (!set.contains(tmp)) {
//            set.add(tmp);
//            queue.add(arr);
//        }
    }

    static int check(int[] arr, int pos) {
        arr[pos] = 1;
        int up = 1, down = 0;
        for (int i = pos+1; i < N; i++) {
            if (arr[i] == 1) down++;
            else break;
        }
        for (int i = pos-1; i >= 0; i--) {
            if (arr[i] == 1) up++;
            else break;
        }
        String tmp = getString(arr);
        if (!set.contains(tmp)) {
            set.add(tmp);
            queue.add(arr);
            return up + down;
        }
        return -1;
    }
}
