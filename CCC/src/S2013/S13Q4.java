package S2013;

import java.io.*;
import java.util.*;

public class S13Q4 {
    static Queue<Set<Integer>> queue = new LinkedList<>();
    static int p, q;
    static HashMap<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] in = br.readLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int M = Integer.parseInt(in[1]);
            for (int i = 0; i < M; i++) {
                in = br.readLine().split(" ");
                int key = Integer.parseInt(in[0]);
                if (!map.containsKey(key))
                    map.put(key, new HashSet<>());
                map.get(key).add(Integer.parseInt(in[1]));
            }
            in = br.readLine().split(" ");
            p = Integer.parseInt(in[0]);
            q = Integer.parseInt(in[1]);
            if (!map.containsKey(p) && !map.containsKey(q)) {
                System.out.println("unknown");
                System.exit(0);
            }
            doBFS(p, q);
            doBFS(q, p);

            System.out.println("unknown");
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static void doBFS(int source, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> tmp;
        set1.add(source);
        while (!set1.isEmpty()) {
            set2.clear();
            for (int s : set1) {
                if (map.containsKey(s)) {
                    tmp = map.get(s);
                    if (tmp.contains(target)) {
                        System.out.println((target==q) ? "yes" : "no");
                        System.exit(0);
                    }
                    set2.addAll(tmp);
                }
            }
            tmp = set1; set1 = set2; set2 = tmp;
        }
    }
}
