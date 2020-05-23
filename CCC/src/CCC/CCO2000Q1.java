package CCC;

import java.util.*;

public class CCO2000Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Character, Set<Character>> link = new HashMap<>();
        String str = "QWERTYUIOPASDFGHJKLZXCVBNM";
        HashMap<Character, Character> uCase = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char tmp1 = sc.next().charAt(0);
            sc.next();
            char tmp2 = sc.next().charAt(0);
            if (str.indexOf(tmp2) >= 0)
                uCase.put(tmp1, tmp2);
            else {
                if (!link.containsKey(tmp1))
                    link.put(tmp1, new HashSet<>());
                link.get(tmp1).add(tmp2);
            }
        }
        ArrayList<Character> key = new ArrayList<>(uCase.keySet());
        for (int i = 0; i < uCase.size(); i++) {
            if (link.containsKey(key.get(i)) && link.containsKey(uCase.get(key.get(i)))){
                link.get(key.get(i)).addAll(link.get(uCase.get(key.get(i))));
            } else {
//                link.put(key.get(i), uCase.get(key.get(i)));
            }
        }
        key = new ArrayList<>(link.keySet());
        Collections.sort(key);
        for (int i = 0; i < key.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(key.get(i) + " = {");
            int cnt = 0;
            for (char j : link.get(key.get(i))) {
                if (cnt != 0)
                    sb.append(",");
                sb.append(j);
                cnt++;
            }
            sb.append("}");
            System.out.println(sb);
        }
    }
}
