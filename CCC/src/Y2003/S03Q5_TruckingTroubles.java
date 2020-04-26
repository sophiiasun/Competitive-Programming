package Y2003;

import java.util.*;
import java.io.*;

public class S03Q5_TruckingTroubles {
    static int C, R, D;
    static int[][] map;
    static HashMap<Integer, ArrayList<Integer>> par;
    static int max = Integer.MAX_VALUE;
    static int[] mark;
    static boolean[] flags;
    static int counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        C = Integer.parseInt(in[0]); R = Integer.parseInt(in[1]); D = Integer.parseInt(in[2]);
        map = new int[R][3];
        for (int i = 0; i < R; i++) {
            in = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(in[0])-1; map[i][1] = Integer.parseInt(in[1])-1; map[i][2] = Integer.parseInt(in[2]);
        }
        counter = D;
        mark = new int[C];
        flags = new boolean[C];
        Arrays.fill(mark, -1);
        par = new HashMap<>();
        par.put(0, new ArrayList<>());
        par.get(0).add(0);
        mark[0] = 0;
        for (int i = 0; i < D; i++) {
            int tmp = Integer.parseInt(br.readLine())-1;
            par.put(tmp, new ArrayList<>());
            par.get(tmp).add(tmp);
            mark[tmp] = tmp;
            flags[tmp] = true;
        }
        Arrays.sort(map, (int[] a, int[] b) -> b[2] - a[2]); // sort weight from greatest to least
        doKruskal();
    }

    static void doKruskal(){
        int count = 0;
        for (int i = 0; i < R; i++) {
            int[] curr = map[i]; //node 1, node 2, weight
            if (mark[curr[0]] < 0) {
                par.put(curr[0], new ArrayList<>()); par.get(curr[0]).add(curr[0]);
                mark[curr[0]] = curr[0];
            }
            if (mark[curr[1]] < 0) {
                par.put(curr[1], new ArrayList<>());
                par.get(curr[1]).add(curr[1]); mark[curr[1]] = curr[1];
            }
            if (mark[curr[0]] != mark[curr[1]]) {
                int min = Math.min(mark[curr[0]], mark[curr[1]]);
                int max = Math.max(mark[curr[0]], mark[curr[1]]);
                par.get(min).addAll(par.get(max));
                for (int index : par.get(max)) {
                    mark[index] = min;
                    if (flags[index] && min == 0)
                        count++;
                }
                par.remove(max);
            }
            if (count == D) {
                System.out.println(curr[2]);
                System.exit(0);
            }
        }
    }

//    static void init2(){
//        Scanner sc = new Scanner(System.in);
//        C = sc.nextInt(); R = sc.nextInt(); D = sc.nextInt();
//        map = new int[R][3]; par = new HashMap<>();
//        for (int i = 0; i < R; i++) {
//            map[i][0] = sc.nextInt()-1;
//            map[i][1] = sc.nextInt()-1;
//            map[i][2] = sc.nextInt();
//        }
//        counter = D;
//        par.put(-1, -1); destination = new int[D];
//        for (int i = 0; i < D; i++) {
//            destination[i] = sc.nextInt()-1;
//            par.put(destination[i], destination[i]);
//        }
//    }

//    static boolean isConnected(){
//        int compare = par.get(-1);
//        for (int i = 0; i < D; i++) {
//            if (par.get(destination[i]) != compare)
//                return false;
//        }
//        return true;
//    }
}
