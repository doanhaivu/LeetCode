package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return invertRecur(root);
    }

    public TreeNode invertRecur(TreeNode aNode) {
        if (aNode == null) return null;
        TreeNode ret = new TreeNode(aNode.val);
        if (aNode.right != null)
            ret.left = invertRecur(aNode.right);
        if (aNode.left != null)
            ret.right = invertRecur(aNode.left);
        return ret;
    }

    @Test
    public void testInvertTree() {
        Integer[] nums = new Integer[] {4, 2, 7, 1, 3, 6, 9};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Integer[] numsInvert = new Integer[] {4, 7, 2, 9, 6, 3, 1};
        Tree trInvert = new Tree();
        TreeNode treeNodeInvert = trInvert.fromArray(numsInvert);

        try {
            treeNodeInvert.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(invertTree(treeNode), is(treeNodeInvert));
    }
}
