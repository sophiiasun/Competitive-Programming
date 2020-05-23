package Uncategorized;

import java.util.*;
import java.io.*;

public class ImperativeFrench {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static String vowels = "aeiouy";

    public static void main(String[] args) throws IOException {
        int N = readInt(); HashMap<String, C> map = new HashMap<>();
        map.put("me", new C("moi", 2));
        map.put("te", new C("toi", 2));
        map.put("nous", new C("nous", 2));
        map.put("voud", new C("vous", 2));
        map.put("le", new C("le", 1));
        map.put("la", new C("la", 1));
        map.put("les", new C("les", 1));
        map.put("lui", new C("lui", 2));
        map.put("leur", new C("leur", 2));
        map.put("y", new C("y", 3));
        map.put("en", new C("en", 4));
        map.put("m", new C("moi", 2));
        map.put("t", new C("toi", 2));
        map.put("l", new C("le", 1));

        for (int t = 0; t < N; t++) {
            String[] in = readLine().split(" ");
            String[] out = new String[]{" ", " ", " ", " ", " "};
            String[] tmp = in[in.length-1].split("'");
            out[0] = tmp[tmp.length-1].substring(0, tmp[tmp.length-1].length()-1);
            for (int i = 1; i < in.length; i++) {
                tmp = in[i].split("'");
                for (int j = 0; j < tmp.length; j++) {
                    if (map.containsKey(tmp[j])) {
                        C c = map.get(tmp[j]);
                        out[c.i] = c.s;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append((char)(out[0].charAt(0)-32)).append(out[0], 1, out[0].length()-1);
            if (in[1].charAt(0) != 'T' || (in[0].charAt(in[0].length()-2) != 'r' || in[0].charAt(in[0].length()-3) != 'e' && out[0].charAt(out[0].length()-1) != 's'))
                sb.append(out[0].charAt(out[0].length()-1) + "-");
            else sb.append("-");
            for (int i = 1; i < 5; i++) {
                if (!out[i].equals(" ")) {
                    if (i < 4) {
                        int temp = i + 1;
                        while (temp < 4 && out[temp].equals(" ")) temp++; // Find next word
                        if (isVowel(out[i].charAt(out[i].length()-1)) && out[i].charAt(0)!='y' && isVowel(out[temp].charAt(0)) && out[i].charAt(1) != 'u') {
                            sb.append(out[i].charAt(0) + "'");
                        } else sb.append(out[i] + "-");
                    } else {
                        sb.append(out[i] + "-");
                    }
                }
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb + " !");
        }
    }

    static boolean isVowel(char c) {
        for (int i = 0; i < 6; i++) {
            if (vowels.charAt(i) == c) return true;
        }
        return false;
    }

    static class C {
        String s; int i;
        C (String ps, int pi) { s = ps; i = pi; }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
