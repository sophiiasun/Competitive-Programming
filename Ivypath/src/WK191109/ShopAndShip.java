package WK191109;

import sun.font.ExtendedTextLabel;

import java.util.*;

public class ShopAndShip {
    static int N, T, K, D;
    static HashMap<Integer, Set<CostTo>> trade = new HashMap<>();
    static HashMap<Integer, Integer> price = new HashMap<>();
    static long minC = Long.MAX_VALUE;
    static long tmpC = 0;
    static long[] cost;
    static double time;
    public static void main(String[] args) {
        init();
        run();
        System.out.println(minC);
    }
    static void run(){
        Set<Integer> set = new HashSet<>();
        Set<Integer> Nset = new HashSet<>();
        Set<Integer> tmp;
        set.add(D);
        while (!set.isEmpty()) {
            Nset.clear();
            for (int i : set) {
                if (trade.containsKey(i)){
                    for (CostTo j : trade.get(i)){
                        if (price.containsKey(j.to)) {
                            tmpC = j.cost + price.get(j.to) + cost[i]; //find cost with pencil
                            if (tmpC < minC) minC = tmpC;
                        }
                        tmpC = j.cost + cost[i]; //find cost without pencil
                        if (tmpC < minC) {
                            if (cost[j.to] == 0 || tmpC < cost[j.to]) {
                                cost[j.to] = tmpC;
                                Nset.add(j.to);
                            }
                        }
                    }
                }
            }
            tmp = set;
            set = Nset;
            Nset = tmp;
        }
    }
    static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        for (int i = 0; i < T; i++)
            connect(sc.nextInt(), sc.nextInt(), sc.nextInt());
        K = sc.nextInt();
        for (int i = 0; i < K; i++)
            price.put(sc.nextInt(), sc.nextInt());
        D = sc.nextInt();
        cost = new long[N + 1];
    }
    static void connect(int x, int y, int c){
        CostTo to = new CostTo(y, c);
        if (!trade.containsKey(x))
            trade.put(x, new HashSet<>());
        trade.get(x).add(to);
        to = new CostTo(x, c);
        if (!trade.containsKey(y))
            trade.put(y, new HashSet<>());
        trade.get(y).add(to);
    }
    static class CostTo{
        int to;
        int cost;
        CostTo(int pto, int pcost){
            to = pto;
            cost = pcost;
        }
    }
}
