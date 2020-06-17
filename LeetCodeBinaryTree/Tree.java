
package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Tree {

    TreeNode root;

    public void init() {

    }

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{1, null, 2, 3};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(tree);
        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        //List<Integer> list = tr.postorderTraversal(treeNode);
        //list.forEach(System.out::println); // postOrder is 3 2 1

    }

    /**
     * https://stackoverflow.com/questions/26891747/convert-integer-array-into-a-binary-tree
     *
     */

    public TreeNode fromArray(Integer[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = q.peek();
            if (node.left == null) {
                node.left = new TreeNode(nums[i]);
                if (nums[i] != null) q.add(node.left);
            } else if (node.right == null) {
                node.right = new TreeNode(nums[i]);
                if (nums[i] != null) q.add(node.right);
                q.remove();
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }

    @Test
    public void testMaxDepth() {
        Integer[] nums = new Integer[] {1,null,2,3};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(maxDepth(treeNode), is(3));

        nums = new Integer[] {};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertThat(maxDepth(treeNode), is(0));


        nums = new Integer[] {1, 2, 3, 4, null, null, 5, null, null, null, 6};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertThat(maxDepth(treeNode), is(4));
    }
}
