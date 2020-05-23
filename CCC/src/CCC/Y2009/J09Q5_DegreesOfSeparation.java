package CCC.Y2009;

import java.util.*;

public class J09Q5_DegreesOfSeparation {
    static ArrayList<Integer>[] link;
    static int Total;
    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        while (ch != 'q') {
            if (ch == 'i')
                i(sc.nextInt(), sc.nextInt());
            else if (ch == 'd')
                d(sc.nextInt(), sc.nextInt());
            else if (ch == 'n')
                n(sc.nextInt());
            else if (ch == 'f')
                f(sc.nextInt());
            else if (ch == 's')
                s(sc.nextInt(), sc.nextInt());
            ch = sc.next().charAt(0);
        }
        System.exit(0);
    }

    static void s(int a, int b) { //output degrees of separation between a and b
        if (a == b) {
            System.out.println("0");
            return;
        }
        Queue<ArrayList<Integer>> aQ = new LinkedList<>(); //degrees, node
        aQ.add(link[a]);
        int cnt = 1;
        while (!aQ.isEmpty()  && cnt <= link.length) {
            ArrayList<Integer> tmp = aQ.poll();
            ArrayList<Integer> next = new ArrayList<>();
            for (int i : tmp) { //i is Integer from one link ArrayList node
                if (i == b) {
                    System.out.println(cnt);
                    return;
                }
                for (int j : link[i]) //go through nodes (ArrayList) of link(i)
                    if (!next.contains(j))
                        next.add(j);
            }
            aQ.add(next);
            cnt++;
        }
        System.out.println("Not connected");
    }

    static void f(int a) { //output number of total indirect friends
        Set<Integer> set = new HashSet<>();
        for (int i : link[a]) {
            for (int j : link[i]){
                if (!link[a].contains(j))
                    set.add(j);
            }
        }
        System.out.println(set.size() - 1);
    }

    static void n(int a) { //output number of direct friends
        System.out.println(link[a].size());
    }

    static void d(int a, int b) { //delete friend
        if (link[a].contains(b)) {
            link[a].remove((Integer) b);
            link[b].remove((Integer) a);
        }
    }

    static void i(int a, int b) { //add link
        if (link[a].contains(b)) return;
        link[a].add(b);
        link[b].add(a);
    }

    static void init() {
        link = new ArrayList[50];
        for (int i = 0; i < 50; i++)
            link[i] = (new ArrayList<>());
        i(1, 6);
        i(2, 6);
        i(6, 7);
        i(7, 8);
        i(8, 9);
        i(9, 10);
        i(10, 11);
        i(9, 12);
        i(3, 6);
        i(4, 6);
        i(5, 6);
        i(4, 5);
        i(3, 4);
        i(3, 5);
        i(3, 15);
        i(11, 12);
        i(13, 15);
        i(12, 13);
        i(13, 14);
        i(16, 17);
        i(17, 18);
        i(16, 18);
    }
}
