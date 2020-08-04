package WK191221;

import java.util.*;

public class ACoinGame {
    static int n;
    static Stacks stacks;
    static String result;

    static class Stacks{
        LinkedList<Character>[] stacks;
        Stacks(int n){
            stacks = new LinkedList[n];
            for (int i = 0; i < n; i++)
                stacks[i] = new LinkedList<>();
        }
        boolean move(int src, int tgt){
            if (tgt >= 0 && tgt < n && stacks[src].size() > 0) {
                if (stacks[tgt].size() == 0 || stacks[src].peek() < stacks[tgt].peek()) {
                    stacks[tgt].push(stacks[src].pop());
                    return true;
                }
                return false;
            } else
                return false;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (Character j : stacks[i])
                    sb.append(j).append(',');
                if (stacks[i].size()>0)
                    sb.setLength(sb.length()-1);
                sb.append(' ');
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }
        public void fromString(String in){
            String[] arr = in.split(" ");
            for (int i = 0; i < n; i++) // Is is possible that the length of arr is smaller than n
                stacks[i].clear();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() > 0) {
                    String[] tmp = arr[i].split(",");
                    for (int j = 0; j < tmp.length; j++) {
                        stacks[i].add(tmp[j].charAt(0));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while (n > 0) {
            stacks = new Stacks(n);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++)
                sb.append(i).append(" ");
            sb.setLength(sb.length()-1);
            result = sb.toString();
            sc.nextLine();
            run(sc.nextLine());
            n = sc.nextInt();
        }
    }

    static void run(String in){
        int[] leftright = new int[] {-1, 1};
        HashSet<String> cach = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Queue<String> tmp;
        queue1.add(in);
        cach.add(in);
        int counter = 0;
        while (!queue1.isEmpty()) {
            counter++;
            for (String s : queue1) {
                stacks.fromString(s);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < leftright.length; j++) {
                        if (stacks.move(i, i + leftright[j])) {
                            String str = stacks.toString();
                            if (str.equals(result)) {
                                System.out.println(counter);
                                return;
                            }
                            if (!cach.contains(str)) {
                                queue2.add(str);
                                cach.add(str);
                            }
                            stacks.move(i + leftright[j], i);
                        }
                    }
                }
            }
            tmp = queue1; queue1 = queue2; queue2 = tmp;
            queue2.clear();
        }
        System.out.println("IMPOSSIBLE");
    }
}
