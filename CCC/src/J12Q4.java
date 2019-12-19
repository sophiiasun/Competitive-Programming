import java.util.*;

public class J12Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        String in = sc.next();
        char[] arr = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String out = "";
        for (int i = 1; i <= in.length(); i++) {
            int shift = ((i << 1) + i + K) % 26;
            int tmp = in.charAt(i-1) - 64;
            if (tmp <= shift) {
                shift -= tmp;
                out += arr[26-shift];
            } else
                out += arr[tmp-shift];
        }
        System.out.println(out);
    }
}
