package LeetCode.LeetCodeBinaryTree;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(Integer val) { this.val = val; }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * https://www.baeldung.com/java-print-binary-tree-diagram
     * https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
     */
    /**
     * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     */

    public void printTree() {
        if (right != null) {
            right.printTree(true, "");
        }
        printNodeValue();
        if (left != null) {
            left.printTree(false, "");
        }
    }
    private void printNodeValue() {
        if (val == null) {
            //out.write("<null>");
            System.out.print("<null>");
        } else {
            //out.write(val);
            System.out.print(val);
        }
        //out.write('\n');
        System.out.println();
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(boolean isRight, String indent) {
        if (right != null) {
            right.printTree(true, indent + (isRight ? "        " : " |      "));
        }
        //out.write(indent);
        System.out.print(indent);
        if (isRight) {
            //out.write(" /");
            System.out.print(" /");
        } else {
            //out.write(" \\");
            System.out.print(" \\");
        }
        //out.write("----- ");
        System.out.print("----- ");
        printNodeValue();
        if (left != null) {
            left.printTree(false, indent + (isRight ? " |      " : "        "));
        }
    }

}
