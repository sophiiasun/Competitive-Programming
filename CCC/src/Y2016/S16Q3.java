package Y2016;

import java.util.*;

public class S16Q3 {
    static int N, M;
    static HashMap<Integer, Set<Integer>> map = new HashMap<>();
    static Queue<Set> queue = new LinkedList<>();
    static int[] pho;

    public static void main(String[] args) {
        init();

    }

    static void run(int snode){
        for (int i = 0; i < M; i++){ //run from each pho restaurant

        }
    }



    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pho = new int[M];
        for (int i = 0; i < M; i++)
            pho[i] = sc.nextInt();
        for (int i = 0; i < N - 1; i++) {
            int key = sc.nextInt();
            if (!map.containsKey(key))
                map.put(key, new HashSet<>());
            map.get(key).add(sc.nextInt());
        }
    }
}
