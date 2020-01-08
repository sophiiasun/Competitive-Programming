package WK191221;

import java.util.*;

public class ACoinGame_2 {
    static int n;
    static String result;

    static class Stacks{
        LinkedList<Character>[] stacks;
        Stacks(int n){
            stacks = new LinkedList[n];
            for (int i = 0; i < n; i++)
                stacks[i] = new LinkedList<>();
        }
        boolean move(int s, int t){ //move source to target
            if (t >= 0 && t < n && stacks[s].size() > 0) {
                if (stacks[t].size() == 0 || stacks[s].peek() < stacks[t].peek()){
                    stacks[t].push(stacks[s].pop());
                    return true;
                }
                return false;
            } else
                return false;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (char j : stacks[i])
                    sb.append(j).append(',');
                if (stacks[i].size()>0)
                    sb.setLength(sb.length()-1);
                sb.append(' ');
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }
        public void fromString(String in){
            for (int i = 0; i < n; i++)
                stacks[i].clear();
            String[] arr = in.split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length()>0) {
                    String[] tmp = arr[i].split(",");
                    for (int j = 0; j < tmp.length; j++) {
                        stacks[i].add(tmp[j].charAt(0));
                    }
                }
            }
        }
    }

    static Stacks stacks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            stacks = new Stacks(n);

            StringBuilder sb = new StringBuilder(); //create exp. result
            for (int i = 1; i <= n; i++)
                sb.append(i).append(' ');
            sb.setLength(sb.length()-1);
            result = sb.toString();

            sc.nextLine();
            run(sc.nextLine());
            n = sc.nextInt();
        }
    }

    public static void run(String in) {
        int[] leftright = {1, -1};
        HashSet<String> set = new HashSet<>();
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Queue<String> tmp;
        q1.add(in);
        set.add(in);
        int counter = 0;
        while(!q1.isEmpty()) {
            counter++;
            for (String s : q1) {
                stacks.fromString(s);
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < 2; j++) {
                        if (stacks.move(i, i+leftright[j])) {
                            String str = stacks.toString();
                            if (str.equals(result)) {
                                System.out.println(counter);
                                return;
                            }
                            if (!set.contains(str)) {
                                q2.add(str);
                                set.add(str);
                            }
                            stacks.move(i + leftright[j], i);
                        }
                    }
                }
            }
            tmp = q1; q1 = q2; q2 = tmp;
            q2.clear();
        }
        System.out.println("IMPOSSIBLE");
    }

}
