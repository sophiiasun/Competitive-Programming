package WK191123;

import java.util.*;

public class Firehose {
    public static void main(String[] args) {
        int H, K, dis = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //value is difference to the previous house
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < H; i++)
            arr.add(sc.nextInt());
        Collections.sort(arr);
        for (int i = 0; i < H; i++) {
            if (i != H-1)
                map.put(arr.get(i+1)-arr.get(i), arr.get(i));
            else
                if (map.containsValue(0))
                    map.put(1000000 - arr.get(i), arr.get(i));
                else
                    map.put(1000000 - arr.get(i) + arr.get(0), arr.get(i));
        }
        K = sc.nextInt();
        if (K >= H)
            System.out.println(0);
        else {
            ArrayList<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list, Collections.reverseOrder());
            int[] house = new int[K];
            for (int i = 0; i < K; i++)
                house[i] = map.get(list.get(i));
            Arrays.sort(house);
            for (int i = 0; i < K; i++) {
                int tmp;
                int index = arr.indexOf(house[i]);
                if (i != K-1) {
                    tmp = house[i+1] - arr.get(index + 1);
                    if (tmp % 2 == 0) tmp /= 2;
                    else tmp = tmp/2 + 1;
                } else {
                    if (index + 1 >= H)
                        tmp = house[0] - arr.get(0);
                    else
                        tmp = 1000000 - arr.get(index + 1) + house[0];
                    if (tmp % 2 == 0) tmp /= 2;
                    else tmp = tmp/2 + 1;
                }
                dis += tmp;
            }
            System.out.println(dis);
        }
    }
}
