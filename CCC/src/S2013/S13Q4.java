package S2013;

import java.util.*;

public class S13Q4 {
    static Queue<Set<Integer>> queue = new LinkedList<>();
    static int p, q;
    static HashMap<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            if (!map.containsKey(key))
                map.put(key, new HashSet<>());
            map.get(key).add(sc.nextInt());
        }
        p = sc.nextInt();
        q = sc.nextInt();

        if (map.containsKey(p)) {
            Set<Integer> set = map.get(p);
            if (set.contains(q)) {
                System.out.println("yes");
                System.exit(0);
            }
            queue.add(map.get(p));
            doBFS(q);
        }

        if (map.containsKey(q)) {
            if (map.containsKey(q)) {
                if (map.get(q).contains(p)) {
                    System.out.println("no");
                    System.exit(0);
                }
            }
            queue.add(map.get(q));
            doBFS(p);
        }

        System.out.println("unknown");
    }

    static void doBFS(int target) {
        while (!queue.isEmpty()) {
            Set<Integer> next = queue.poll();
            for (int i : next) {
                if (i == target && target == q) {
                    System.out.println("yes");
                    System.exit(0);
                } else if (i == target && target == p) {
                    System.out.println("no");
                    System.exit(0);
                } else if (map.containsKey(i))
                    queue.add(map.get(i));
            }
        }
    }
}
