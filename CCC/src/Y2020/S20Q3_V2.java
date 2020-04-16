package Y2020;

import java.util.*;

//out of memory batch 4 case 30

public class S20Q3_V2 {

    static int[] compare;
    static Set<String> set = new HashSet<>();
    static String perm, str;
    static int[] count = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        perm = sc.next(); str = sc.next();
        compare = getArray(perm);

        boolean invalidChar;
        for (int s = 0; s <= str.length()-perm.length(); s++) {
            invalidChar = false;
            Arrays.fill(count, 0);
            for (int i = s; i < s+perm.length(); i++) { //i is curr letter
                if (compare[str.charAt(i)-97] == 0) {
                    s = i;
                    invalidChar = true;
                    break;
                } else {
                    count[str.charAt(i) - 97]++;
                }
            }
            if (!invalidChar)
                s = run(s, count);
        }

        System.out.println(set.size());
    }

    static int run(int s, int[] count){
        if (compareArray(count, compare)) {
            if (s + perm.length() >= str.length())
                set.add(str.substring(s));
            else
                set.add(str.substring(s, s + perm.length()));
        }
        int i, e;
        for (i = s; i < str.length(); i++) {
            e = i + perm.length();
            if (e >= str.length() || compare[str.charAt(e)-97] == 0)
                return e;
            count[str.charAt(i) - 97]--;
            count[str.charAt(e) - 97]++;
            if (compareArray(count, compare)) {
                if (i + perm.length() >= str.length())
                    set.add(str.substring(i));
                else
                    set.add(str.substring(i + 1, i + 1 + perm.length()));
            }
        }
        return i;
    }

    static int[] getArray(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i)-97]++;
        return arr;
    }

    static boolean compareArray(int[] arr1, int[] arr2){
        for (int i = 0; i < 26; i++){
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
