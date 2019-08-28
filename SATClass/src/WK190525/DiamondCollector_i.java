package WK190525;

import java.util.*;

public class DiamondCollector_i {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int Cnt = 0;
        for(int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if(map.containsKey(tmp)) {
                map.put(tmp, ++Cnt);
            } else {
                map.put(tmp, 1);
            }
        }
        for (Integer key : map.keySet()) {
            System.out.println(key +":"+ map.get(key));
        }
        int[] arr = {1,2,3,4};
        int temp = arr.length;
    }
}