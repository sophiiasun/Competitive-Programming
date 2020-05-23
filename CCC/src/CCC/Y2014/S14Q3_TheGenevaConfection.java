package CCC.Y2014;

import java.util.*;

public class S14Q3_TheGenevaConfection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            boolean doable = true;
            LinkedList<Integer> start = new LinkedList<>();
            LinkedList<Integer> branch = new LinkedList<>();
            for (int j = 1; j <= N; j++)
                start.push(sc.nextInt());
            for (int j = 1; j <= N; j++) {
                if (!start.isEmpty() && start.peek() == j)
                    start.pop();
                else if (!branch.isEmpty() && branch.peek() == j)
                    branch.pop();
                else if (branch.size() == 0) {
                    branch.push(start.pop());
                    j--;
                } else if (start.peek() != j && start.peek() < branch.peek()) {
                    branch.push(start.pop());
                    j--;
                } else {
                    doable = false;
                }
                if (start.isEmpty())
                    break;
            }
            System.out.println((doable) ? 'Y' : 'N');
        }
    }
}
