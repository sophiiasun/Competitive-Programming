package CCC.Y2020;

import java.util.*;

public class S20Q3_SearchingForStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String perm = sc.next(), str = sc.next();
        Set<String> set = new HashSet<>();
        String compare = getPerm(perm);

        String letters = "";
        for (int i = 0; i < perm.length(); i++) {
            if (letters.indexOf(perm.charAt(i)) < 0)
                letters += perm.charAt(i);
        }

        str+= " ";
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (letters.indexOf(str.charAt(i)) >= 0) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (letters.indexOf(str.charAt(j)) < 0) {
                        if (j-i >= perm.length())
                            strings.add(str.substring(i, j));
                        i = j;
                        break;
                    }
                }
            }
        }

        for (String s : strings) {
            for (int i = 0; i < s.length() - perm.length() + 1; i++) {
                String tperm = s.substring(i, i + perm.length());
                if (!set.contains(tperm) && countLetters(tperm, compare))
                    set.add(tperm);
            }
        }

//        for (int i = 0; i < str.length() - perm.length() + 1; i++) {
//            String tperm = str.substring(i, i + perm.length());
//            if (!set.contains(tperm) && countLetters(tperm, compare))
//                set.add(tperm);
//        }
        System.out.println(set.size());
    }

    static boolean countLetters(String str, String compare){ //97
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 97]++;
        String out = "";
        for (int i = 0; i < 26; i++) {
            out += i;
            out += arr[i];
        }
        if (out.equals(compare))
            return true;
        return false;
    }

    static String getPerm(String str){
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 97]++;
        String out = "";
        for (int i = 0; i < 26; i++) {
            out += i;
            out += arr[i];
        }
        return out;
    }
}
