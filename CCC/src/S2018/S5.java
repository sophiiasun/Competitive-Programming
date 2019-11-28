package S2018;

import java.util.*;

public class S5 {
    static int N, M, P, Q;
    static int[] arrP; //Planets
    static int[] arrC; //Cities
    static long totalCost;
    static long buildCost;
    static int cityCNT, cityID;
    static int planetCNT, planetID;
    static HashMap<Integer, Set<Integer>> connP = new HashMap<>();
    static HashMap<Integer, Set<Integer>> connC = new HashMap<>();
    static ArrayList<Connection> aLink = new ArrayList<>();
    public static void main(String[] args) {
        init();
        run();
        out();
    }

    static void out() {
        System.out.println(totalCost - buildCost);
    }

    static void run() {
        int cnt = 0;
        for (Connection conn : aLink) {
            if (conn.isPortal) {
                if (!isConnected(arrP[conn.s], arrP[conn.e])) {
                    cnt = M - cityCNT;
                    buildCost += (long) conn.c * cnt;
                    connect(true, connP, arrP, conn.s, conn.e);
                    planetCNT++;
                }
            } else {
                if (!isConnected(arrC[conn.s], arrC[conn.e])) {
                    cnt = N - planetCNT;
                    buildCost += (long) conn.c * cnt;
                    connect(false, connC, arrC, conn.s, conn.e);
                    cityCNT++;
                }
            }
            if (planetCNT == N - 1 && cityCNT == M - 1)
                return;
        }
    }

    static void connect(boolean isPlanet, HashMap<Integer, Set<Integer>> map, int[] groups, int c1, int c2) {
        if (groups[c1] == 0 && groups[c2] == 0) {
            Set<Integer> set = new HashSet<>();
            set.add(c1);
            set.add(c2);
            int groupID = isPlanet ? ++planetID : ++cityID;
            map.put(groupID, set);
            groups[c1] = groups[c2] = groupID;
        } else if (groups[c1] == 0 && groups[c2] != 0) {
            map.get(groups[c2]).add(c1);
            groups[c1] = groups[c2];
        } else if (groups[c1] != 0 && groups[c2] == 0) {
            map.get(groups[c1]).add(c2);
            groups[c2] = groups[c1];
        } else if (groups[c1] != 0 && groups[c2] != 0) {
            int tar = Math.min(groups[c1], groups[c2]);
            int src = Math.max(groups[c1], groups[c2]);
            map.get(tar).addAll(map.get(src));
            for (int i : map.get(src)) {
                groups[i] = tar;
            }
            map.remove(src);
        }
    }

    static boolean isConnected(int a, int b) {
        return (a == b && a != 0);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        Q = sc.nextInt();
        arrP = new int[N];
        arrC = new int[M];
        int a, b, c, x, y, z;
        for (int i = 0; i < P; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            totalCost += (long) c * N;
            if (a != b)
                aLink.add(new Connection(a - 1, b - 1, c, false));
        }
        for (int i = 0; i < Q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            totalCost += (long) z * M;
            if (x != y)
                aLink.add(new Connection(x - 1, y - 1, z, true));
        }
        Collections.sort(aLink, (c1, c2) -> (c1.c - c2.c));
    }

    static class Connection {
        boolean isPortal = false;
        int s, e, c;
        Connection(int s, int e, int c, boolean isPortal) {
            this.s = s;
            this.e = e;
            this.c = c;
            this.isPortal = isPortal;
        }
    }
}
