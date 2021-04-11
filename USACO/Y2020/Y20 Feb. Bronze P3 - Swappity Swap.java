package USACO;

import java.util.*;
import java.io.*;

public class SwapitySwap {
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader (new FileReader("swap.in"));
        String[] in = sc.readLine().split(" ");
        int N = Integer.parseInt(in[0]), K = Integer.parseInt(in[1]);
        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) arr[i-1] = i;
        in = sc.readLine().split(" ");
        int swapA1 = Integer.parseInt(in[0]) - 1, swapA2 = Integer.parseInt(in[1]) - 1;
        in = sc.readLine().split(" ");
        int swapB1 = Integer.parseInt(in[0]) - 1, swapB2 = Integer.parseInt(in[1]) - 1;

        int counter = 1;
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> rev = new HashMap<>();
        Set<String> set = new HashSet<>();

        boolean found = false;
        int num = 0;
        for (int i = 0; i < K; i++) {
            String tmps = getString(arr);
            if (set.contains(tmps)){ found = true; break;} 
            else {
                String str = getString(arr);
                map.put(counter, str); rev.put(str, counter);
                counter++; set.add(str);
                int s = swapA1, e = swapA2; //swap1
                while (e > s) {
                    int tmp = arr[s];
                    arr[s] = arr[e]; arr[e] = tmp;
                    s++; e--;
                }
                s = swapB1; e = swapB2; //swap2
                while (e > s) {
                    int tmp = arr[s];
                    arr[s] = arr[e]; arr[e] = tmp;
                    s++; e--;
                }
            }
        }

        if (found) {
            int remainder = K % (counter - 1);
            arr = getArray(map.get(remainder + 1));
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        for (int i = 0; i < N; i++)
            out.println(arr[i]);
        out.flush(); out.close(); System.exit(0);
    }

    static int[] getArray(String str) {
        String[] arr = str.split(",");
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            ret[i] = Integer.parseInt(arr[i]);
        }
        return ret;
    }

    static String getString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]).append(",");
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
