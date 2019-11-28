import java.io.*;
import java.util.*;

public class test2 {
    static BufferedReader in;
    static StringTokenizer st;

    public static void main (String [] args){ //on the online tests, use buffer because if can be 1-2secs longer
        //recommended to use buffer for Q4-5, especially with many lines of input
        //you have to manually handle all exceptions
        try{
            in = new BufferedReader(new InputStreamReader(System.in));
            int iT = nextInt();
            String sT = next();
            double dT = nextDouble();
            long lT = nextLong();

            System.out.println(iT + "; " + sT + "; " + dT + "; " + lT);
        }
        catch(IOException e){
            System.out.println("IO: General");
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(in.readLine().trim());
        return st.nextToken();
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String nextLine() throws IOException {
        return in.readLine().trim();
    }

}