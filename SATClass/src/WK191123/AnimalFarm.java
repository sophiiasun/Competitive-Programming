package WK191123;

import java.util.*;

public class AnimalFarm {
    static int N;
    static HashMap<Integer, Integer>[] map;
    static int[] room;
    static HashMap<Integer, int[]> cost = new HashMap<>();
    public static void main(String[] args) {
        init();
    }
    static void run(){
        ArrayList<Integer> key = new ArrayList<>(cost.keySet());
        Collections.sort(key);
        while(!checkRooms()){
            
        }
    }
    static boolean checkRooms(){
        for (int i = 0; i < N-1; i++) {
            if (room[i] != room[i+1])
                return false;
        }
        return true;
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        room = new int[N];
        map = new HashMap[N];
        for (int i = 0; i < N; i++) {
            map[i] = new HashMap<>();
            int edges = sc.nextInt();
            int first = sc.nextInt();
            int tmp1;
            int tmp2 = first;
            for (int j = 0; j < edges - 1; j++) {
                tmp1 = tmp2;
                tmp2 = sc.nextInt();
                map[i].put(tmp1, tmp2);
            }
            map[i].put(tmp2, first);
            for (int j : map[i].keySet())
                cost.put(sc.nextInt(), new int[]{j, map[i].get(j)});
        }
    }
}
