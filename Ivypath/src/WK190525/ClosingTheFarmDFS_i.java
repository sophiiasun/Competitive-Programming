package WK190525;

import java.util.*;

public class ClosingTheFarmDFS_i {

    private static Scanner sc = new Scanner(System.in);
    private static int N = sc.nextInt(), M = sc.nextInt();
    private static ArrayList<int[]> link = new ArrayList<>();
    private static int[] close = new int[N];
    private static int[] aParent = new int[N];
    private static int comp = 0;

    public static void main(String[] args) {
        for(int i = 0; i < M; i++)
            link.add(new int[] {sc.nextInt(), sc.nextInt()});
        for(int i = 0; i < N; i++)
            close[i] = sc.nextInt();
        for(int i = 0; i < N; i++){
            doDSU();
            if(comp == 1) System.out.println("YES");
            else System.out.println("NO");
            for(int j = 0; j < link.size(); j++){
                if(link.get(j)[0] == close[i] || link.get(j)[1] == close[i]) {
                    link.get(j)[0] = -1;
                    link.get(j)[1] = -1;
                }
            }
        }
    }

    private static void doDSU(){
        comp = aParent.length;
        for(int i = 0; i < aParent.length; i++) {
            aParent[i] = i;
        }
        for(int i = 0; i < link.size(); i++) {
            mergeSets(link.get(i)[0], link.get(i)[1]);
        }
    }

    private static void mergeSets(int A, int B){
        if (aParent[A] != aParent[B]) {
            comp--;
            for(int i = 0; i < aParent.length; i++) {
                if(aParent[i] == A) aParent[i] = B;
            }
        }
    }
}