package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConstructFromInorderPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
    }

    @Test
    public void testBuildTree() {

        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};

        TreeNode treeNode = buildTree(inorder, postorder);
        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Integer[] nums = new Integer[] {3, 9, 20, null, null, 15, 7};
        Tree tr = new Tree();
        TreeNode expected = tr.fromArray(nums);
        try {
            expected.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(treeNode, is(expected));
    }
}
