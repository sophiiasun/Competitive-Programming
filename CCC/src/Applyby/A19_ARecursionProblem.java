package Applyby;

import java.util.*;
import java.io.*;

public class A19_ARecursionProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String S = readLine();
        Stack<Integer> nums = new Stack<>();
        boolean negative = false;
        for (int i = 0; i < S.length(); i++)  {
            String s = Character.toString(S.charAt(i));
            if (S.charAt(i) >= 48 && S.charAt(i) <= 57)  {
                while (i < S.length() && S.charAt(i+1) >= 48 && S.charAt(i+1) <= 57)  {
                    i++; s += Character.toString(S.charAt(i));
                }
                if (negative)  {
                    s = "-"+s; negative = false;
                }
                nums.add(Integer.parseInt(s));
            }  else if (S.charAt(i) == ')')  {
                nums.add(nums.pop() + nums.pop());
            }  else if (S.charAt(i) == '-')  {
                negative = true;
            }
        }
        System.out.println(nums.pop());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
