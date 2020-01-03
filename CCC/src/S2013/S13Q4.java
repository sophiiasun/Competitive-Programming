package S2013;

import java.util.*;

public class S13Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            if (!map.containsKey(key))
                map.put(key, new HashSet<>());
            map.get(key).add(sc.nextInt());
        }
        int p = sc.nextInt(), q = sc.nextInt();
        if (map.size() != N)
            System.out.println("unknown");
        else {

        }
    }

    static void getchild(int num){
        
    }
}
