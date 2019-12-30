package WK191221;

import java.util.*;

public class AbsolutelyAcidic {
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
        HashMap<Integer, List> map = new HashMap<>();
        for(int i : counter.keySet()) {
            if (!map.containsKey(counter.get(i)))
                map.put(counter.get(i), new ArrayList<>());
            map.get(counter.get(i)).add(i);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        List<Integer> sort;

        if(map.get(list.get(list.size()-1)).size()>1) {
            sort = map.get(list.get(list.size()-1));
            Collections.sort(sort);
            System.out.println(Math.abs(sort.get(sort.size()-1) - sort.get(0)));
        } else {
            int max = (int)map.get(list.get(list.size()-1)).get(0);
            sort = map.get(list.get(list.size()-2));
            Collections.sort(sort);
            int num1 = Math.abs(max - sort.get(0));
            int num2 = Math.abs(max - sort.get(sort.size()-1));
            if (num1 > num2)
                System.out.println(num1);
            else
                System.out.println(num2);
        }
    }
}
