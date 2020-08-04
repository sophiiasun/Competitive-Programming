package DMOPC.Y2015;

import java.util.*;
import java.io.*;

public class DMOPC15_PersonalAssistant {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(); long r, h, l, dp[], m = 0;
        HashMap<Integer, ArrayList<Anime>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            r = readInt(); h = readInt(); l = readInt();
//            if (!map.containsKey())
        }
    }

    static class Anime {
        long r, h, l;
        Anime (long pr, long ph, long pl) { r = pr; h = ph; l = pl; }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
