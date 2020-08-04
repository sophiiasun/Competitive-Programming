package CCC.Y2010;

import java.util.*;

public class S10Q5_NutrientTree {
    static int nid = 0;
    static Node root = new Node();
    static int X; //total number of agents
    static int[] Xs; //stores branch value based on (1 + i)^2
    static HashMap<String, Integer> nodeMap = new HashMap<>();
    static HashMap<String, Integer> branchMap = new HashMap<>();

    public static void main(String[] args) {
        init();
        System.out.println(runNode(root, X));
    }

    static int runNode(Node node, int agents) {
        int max = 0;
        if (node.nutrient > 0)
            max = node.nutrient + agents;
        else {
            String key = node.id + ":" + agents;
            if (nodeMap.containsKey(key)) {
                max = nodeMap.get(key);
            } else {
                for (int i = 0; i <= agents; i++) {
                    int m = runBranch(node.left, i) + runBranch(node.right, agents - i);
                    if (m > max)
                        max = m;
                }
                nodeMap.put(key, max);
            }
        }
        return max;
    }

    static int runBranch (Node node, int agents) {
        if (agents == 0)
            return 1;
        String key = node.id + ":" + agents;
        if (branchMap.containsKey(key))
            return branchMap.get(key);
        int max = 0;
        if (node.nutrient > 0) {
            int i = 0;
            while (i <= agents && Xs[i] < (node.nutrient + agents - i))
                i++;
            max = (i > agents) ? Xs[agents] : node.nutrient + agents - i;
        } else {
            for (int i = 1; i <= agents; i++) {
                int m = Math.min(Xs[i], runNode(node, agents - i));
                if (m > max)
                    max = m;
            }
        }
        branchMap.put(key, max);
        return max;
    }

    static void init(){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        Node cnode = root;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '(') {
                cnode.left = new Node();
                cnode.right = new Node();
                cnode.left.parent = cnode;
                cnode.right.parent = cnode;
                cnode = cnode.left;
            } else if (in.charAt(i) == ')') {
                cnode = cnode.parent;
                if (cnode != root && cnode.id == cnode.parent.left.id) {
                    cnode = cnode.parent.right;
                }
            } else if (in.charAt(i) >= '0' && in.charAt(i) <= '9') {
                int s = i;
                while (i < in.length() && in.charAt(i) >= '0' && in.charAt(i) <= '9')
                    i++;
                String str = in.substring(s, i);
                cnode.nutrient = Integer.parseInt(str);
                i--;
                if (cnode != root && cnode.id == cnode.parent.left.id) {
                    cnode = cnode.parent.right;
                }
            }
        }
        X = sc.nextInt();
        Xs = new int[X + 1];
        for (int i = 0; i <= X; i++)
            Xs[i] = (int)Math.pow(1 + i, 2);
    }

    static class Node{
        int id = nid++;
        int nutrient = 0;
        Node parent = null;
        Node left = null;
        Node right = null;
    }
}
