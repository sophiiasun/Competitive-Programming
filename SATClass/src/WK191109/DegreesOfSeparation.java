package WK191109;

import java.util.*;

public class DegreesOfSeparation {
    /*
     * i: add link
     * d: delete link
     * n: output the number of direct friends n has
     * f: output the number of indirect friend n has
     * s: output the degree of separation n and m have
     * q: quit the program
     */
    static Queue<ArrayList<Integer>> aQ = new LinkedList<>();
    static ArrayList<Integer>[] link;
    static boolean[] aMet;
    public static void main(String[] args) {
        init();
    }
    static void s(int a, int b){
//        doBFS();
    }
    static int doBFS(int iS, int T){
        ArrayList<Integer> tmp = new ArrayList<>(aQ.poll());
        ArrayList<Integer> next = new ArrayList<>();
        for (int i : tmp) {
            aMet[i] = true;
            if (i == T)
                return iS;
//            next.add();
        }
        return -1;
    }
    static void q(){ //exit program
        System.exit(1);
    }
    static void f(int a){ //output number of total indirect friends
        Queue<int[]> iQ = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < link.length; i++) {
            int tmp = link[a].get(i);
            cnt += link[tmp].size();
        }
        System.out.println(cnt);
    }
    static void n(int a){ //output number of direct friends
        System.out.println(link[a].size());
    }
    static void d(int a, int b){ //delete friend
        if (link[a].contains(b)) {
            link[a].remove(b);
            link[b].remove(a);
        }
    }
    static void i(int a, int b){ //add link
        link[a].add(b);
        link[b].add(a);
    }
    static void init(){
        link = new ArrayList[49];
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
        aMet = new boolean[50];
    }
}
