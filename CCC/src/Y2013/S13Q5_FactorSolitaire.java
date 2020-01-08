package Y2013;

import java.util.*;

public class S13Q5_FactorSolitaire {
    static int N;
    static int[] cost;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N + 1];
        cost[1] = 0;
        for (int i = 1; i < N; i++) {
            findFactors(i);
           for (int j = 0; j < list.size(); j+=2) {
                int target = list.get(j) + i;
                if (target <= N) {
                    int newcost = cost[i] + list.get(j+1);
                    if (newcost < cost[target] || cost[target] == 0)
                        cost[target] = newcost;
                }
                if (list.get(j) != list.get(j+1)) {
                    target = list.get(j+1) + i;
                    if (target <= N) {
                        int newcost = cost[i] + list.get(j);
                        if (newcost < cost[target] || cost[target] == 0)
                            cost[target] = newcost;
                    }
                }
            }
        }
        System.out.println(cost[N]);
    }

    static void findFactors(int num){
        list.clear();
        int sqrt = (int)Math.sqrt(num);
        for (int i = 1; i <= sqrt; i++) {
            if (num%i==0) {
                list.add(i);
                list.add(num/i);
            }
        }
    }
}
