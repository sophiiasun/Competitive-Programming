package Y2011;

import java.util.*;

public class S11Q5_Switch {

    static int[] arr;
    static int N;
    static Set<String> set;
    static Queue<int[]> queue;
    static int counter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 2];
        counter = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 1)
                counter++;
        }

        if (counter == 0) System.out.println(0);
        else {
            arr[N + 1] = counter;
            int out = doBFS();
            System.out.println(out);
        }
    }

    static int doBFS() {
        set = new HashSet<>();
        queue = new LinkedList<>();
        set.add(getString(arr));
        queue.add(arr);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < N; i++) {
                if (curr[i] == 0 && isCloseEnough(curr, i)) {
                    int[] next = Arrays.copyOf(curr, N + 2);
                    next[N]++;
                    if (check(next, i) >= 4)
                        change(next, i);
                    if (next[N + 1] == 0)
                        return next[N];
                }
            }
        }
        return -1;
    }

    static boolean isCloseEnough(int[] arr, int pos) {
        boolean up = false, down = false;
        for (int i = 1; i <= 3; i++) {
            if (pos+i < N && arr[pos+i] == 1) {
                up = true; break;
            }
        }
        for (int i = 1; i <= 3; i++) {
            if (pos-i >= 0 && arr[pos-i] == 1) {
                down = true; break;
            }
        }
        if (N==25 && counter < 8)
            return up && down;
        return up || down;
    }

    static String getString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(arr[i]);
        return sb.toString();
    }

    static void change(int[] arr, int pos) {
        arr[pos] = 0;
        arr[N + 1]--;
        for (int i = pos + 1; i < N; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
                arr[N + 1]--;
            } else break;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                arr[i] = 0;
                arr[N + 1]--;
            } else break;
        }
        set.add(getString(arr));
    }

    static int check(int[] arr, int pos) {
        arr[pos] = 1;
        arr[N + 1]++;
        int up = 1, down = 0;
        for (int i = pos + 1; i < N; i++) {
            if (arr[i] == 1) down++;
            else break;
        }
        for (int i = pos - 1; i >= 0; i--) {
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
