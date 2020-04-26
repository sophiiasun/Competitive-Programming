package Y2012;

import java.util.*;

public class S12Q3_AbsolutelyAcidic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = sc.nextInt();
            if (!counter.containsKey(key))
                counter.put(key, 0);
            int tmp = counter.get(key);
            counter.put(key, ++tmp);
        }

        dadway(counter);
    }

    static void dadway(HashMap<Integer, Integer> counter){
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        int[] tmp;
        int max1 = 0, max2 = 0;

        for (int i : counter.keySet()){
            int v = counter.get(i);
            if (v > max1) {
                tmp = arr2; arr2 = arr1; arr1 = tmp;
                max2 = max1; max1 = v;
                arr1[0] = arr1[1] = i;
            } else if (v > max2 && v < max1) {
                max2 = v;
                arr2[0] = arr2[1] = i;
            } else if (v == max1) {
                add2MaxMin(arr1, i);
            } else if (v == max2) {
                add2MaxMin(arr2, i);
            }
        }

        if (arr1[0] != arr1[1]) {
            System.out.println(Math.abs(arr1[0]-arr1[1]));
        } else {
            System.out.println(Math.max(Math.abs(arr1[0]-arr2[0]), Math.abs(arr1[0]-arr2[1])));
        }
    }

    static void add2MaxMin(int[] arr, int v){
        if (v > arr[0])
            arr[0] = v;
        else if (v < arr[1])
            arr[1] = v;
    }
}
