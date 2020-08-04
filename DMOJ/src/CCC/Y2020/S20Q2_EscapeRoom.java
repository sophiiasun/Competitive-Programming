package CCC.Y2020;

import java.util.*;
import java.io.*;

public class S20Q2_EscapeRoom {
    static int[][] arr;
    static int M, N;
    static boolean[] data;
    static HashMap<Integer, ArrayList<int[]>> factors = new HashMap<>();
    public static void main(String[] args) throws IOException{ // m is row, n is column
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());
        arr = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            String[] str = bf.readLine().split(" ");
            for (int j = 1; j <= N; j++)
                arr[i][j] = Integer.parseInt(str[j-1]);
        }

        data = new boolean[1000001];
        doBFS();
        System.out.println("no");
    }

    static boolean doBFS(){
        ArrayList<int[]> list = getFactors(arr[1][1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(list);
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            if (!data[arr[next[0]][next[1]]]) {
                data[arr[next[0]][next[1]]] = true;
                list = getFactors(arr[next[0]][next[1]]);
                queue.addAll(list);
            }
        }
        return false;
    }

    static boolean isValid(int iR, int iC){
        return (iR <= M && iC <= N && !data[arr[iR][iC]]);
    }

    static ArrayList<int[]> getFactors(int in) {
        if (factors.containsKey(in))
            return factors.get(in);
        else {
            int sqrt = (int) Math.sqrt(in);
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 1; i <= sqrt; i++) {
                if (in % i == 0) {
                    int num = in / i;
                    if (i == M && num == N || i == N && num == M) {
                        System.out.println("yes");
                        System.exit(0);
                    }
                    if (isValid(i, num))
                        list.add(new int[]{i, num});
                    if (isValid(num, i))
                        list.add(new int[]{num, i});
                }
            }
            factors.put(in, list);
            return list;
        }
    }

}
