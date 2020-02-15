package p3;

import java.io.BufferedReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] freq = new int[1000 + 1];
        int top1 = 0, top2 = 0;
        for (int i = 1; i <= N; i++) {
            int val = sc.nextInt();
            freq[val]++;
            if (freq[val] > top1)
                top1 = freq[val];
            else if (freq[val] > top2 && freq[val] < top1)
                top2 = freq[val];
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == top1)
                arr1.add(i);
            else if (top2 != 0 && freq[i] == top2)
                arr2.add(i);
        }

        if (arr1.size() >= 2) {
            int[] tmp = get(arr1);
            System.out.println(Math.abs(tmp[1] - tmp[0]));
        } else if (arr1.size() == 1) {
            int[] tmp = get(arr2);
//            System.out.println(Math.max(Math.abs(arr1.get(0) - tmp[0]), Math.abs(arr1.get(0) - tmp[1])));
            int dif1 = Math.max(arr1.get(0), tmp[0]) - Math.min(arr1.get(0), tmp[0]);
            int dif2 = Math.max(arr1.get(0), tmp[1]) - Math.min(arr1.get(0), tmp[1]);
            System.out.println(Math.max(dif1, dif2));
        }
    }

    static int[] get(ArrayList<Integer> arr) {
        Collections.sort(arr);
        int[] tmp = {arr.get(0), arr.get(arr.size()-1)};
        return tmp;
    }
}
