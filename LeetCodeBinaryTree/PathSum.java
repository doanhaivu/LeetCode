package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        return recurSum(root, 0, sum);
    }

    public boolean recurSum(TreeNode aNode, int current, int sum) {
        if (aNode == null) return false;

        int thisSum = aNode.val + current;

        if (aNode.left == null && aNode.right == null && thisSum == sum) {
            return true;
        } else {
            return (recurSum(aNode.left, thisSum, sum) || recurSum(aNode.right, thisSum, sum));
        }
    }

    @Test
    public void testHasPathSum() {
        Integer[] nums = new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(hasPathSum(treeNode, 22), is(true));
    }
}
