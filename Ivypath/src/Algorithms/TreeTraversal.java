package Algorithms;

import java.util.*;

public class TreeTraversal {
    public static void main (String[] args) {
        // build the binary search tree
        BinaryTreeNode oP = new BinaryTreeNode("15");
        BinaryTreeNode oC1 = new BinaryTreeNode("10");
        oP.addLeft(oC1);
        oC1.addLeft(new BinaryTreeNode("6"));
        oC1.addRight(new BinaryTreeNode("12"));
        BinaryTreeNode oC5 = new BinaryTreeNode("31");
        oP.addRight(oC5);
        oC5.addLeft(new BinaryTreeNode("20"));
        oC5.addRight(new BinaryTreeNode("54"));
        System.out.println(oP.toString());

        System.out.println("DFS - PreOrder: ");
        doDFS_PreOrder(oP);
        System.out.println("\n");

        System.out.println("DFS - InOrder: ");
        doDFS_InOrder(oP);
        System.out.println("\n");

        System.out.println("DFS - PostOrder: ");
        doDFS_PostOrder(oP);
        System.out.println("\n");

        System.out.println("BFS: ");
        doBFS(oP);
        System.out.println("\n");
    }

    private static void doDFS_PreOrder(BinaryTreeNode oN) {
        System.out.print(oN.sName + "-");
        if(oN.oLeft != null)
            doDFS_PreOrder(oN.oLeft);
        if(oN.oRight != null)
            doDFS_PreOrder(oN.oRight);
    }

    private static void doDFS_InOrder(BinaryTreeNode oN) {
        if(oN.oLeft != null)
            doDFS_InOrder(oN.oLeft);
        System.out.print(oN.sName + "-");
        if(oN.oRight != null)
            doDFS_InOrder(oN.oRight);
    }

    private static void doDFS_PostOrder(BinaryTreeNode oN) {
        if(oN.oLeft != null)
            doDFS_PostOrder(oN.oLeft);
        if(oN.oRight != null)
            doDFS_PostOrder(oN.oRight);
        System.out.print(oN.sName + "-");
    }

    private static void doBFS(BinaryTreeNode oN) {
        Queue<BinaryTreeNode> oQue = new LinkedList();
        oQue.add(oN);

        while(!oQue.isEmpty()){
            BinaryTreeNode oNext = oQue.poll();
            System.out.print(oNext.sName + "-");
            if(oNext.oLeft != null)
                oQue.add(oNext.oLeft);
            if(oNext.oRight != null)
                oQue.add(oNext.oRight);
        }
    }

    static class BinaryTreeNode {
        public String sName;
        public int iData;
        public BinaryTreeNode oLeft;
        public BinaryTreeNode oRight;
        public BinaryTreeNode oParent;

        public BinaryTreeNode(String sN) {
            this.sName = sN;
        }

        public void addLeft(BinaryTreeNode oC) {
            oC.oParent = this;
            oLeft = oC;
        }

        public void addRight(BinaryTreeNode oC) {
            oC.oParent = this;
            oRight = oC;
        }

        public BinaryTreeNode getParent() {
            return oParent;
        }

        public BinaryTreeNode getLeft() {
            return oLeft;
        }

        public BinaryTreeNode getRight() {
            return oRight;
        }

        public String toString() {
            StringBuilder oBuffer = new StringBuilder(50);
            print(oBuffer, "", "");
            return oBuffer.toString();
        }

        private void print(StringBuilder oBuffer, String sPreFix, String sChildPrefix) {
            oBuffer.append(sPreFix);
            oBuffer.append(sName);
            oBuffer.append('\n');
            if(oLeft != null || oRight != null) {
                if(oLeft != null && oRight != null) {
                    oLeft.print(oBuffer, sChildPrefix + "├── ", sChildPrefix + "│   ");
                    oRight.print(oBuffer, sChildPrefix + "└── ", sChildPrefix + "    ");
                }
                else if(oLeft != null)
                    oLeft.print(oBuffer, sChildPrefix + "└── ", sChildPrefix + "    ");
                else
                    oRight.print(oBuffer, sChildPrefix + "└── ", sChildPrefix + "    ");
            }
        }
    }
}
