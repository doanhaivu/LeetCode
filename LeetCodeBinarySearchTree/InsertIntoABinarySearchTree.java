package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode tmp = root;
        TreeNode prev = root;
        while (tmp != null && tmp.val != null) {
            prev = tmp;
            tmp = tmp.val > val? tmp.left:tmp.right;
        }
        TreeNode aNode = new TreeNode(val);
        if (prev != null) {
            if (prev.val > val) {
                prev.left = aNode;
            } else {
                prev.right = aNode;
            }
        } else {
            return new TreeNode(val);
        }

        return root;
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{4,2,7,1,3,null,null};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        Integer[] expectedNums = new Integer[]{4,2,7,1,3,5,null};
        Tree expectedTree = new Tree();
        TreeNode expectedRoot = expectedTree.fromArray(expectedNums);
        expectedRoot.printTree();
        assertThat(insertIntoBST(root, 5).val, is(expectedRoot.val));

        nums = new Integer[]{};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        //root.printTree();

        expectedNums = new Integer[]{5};
        expectedTree = new Tree();
        expectedRoot = expectedTree.fromArray(expectedNums);
        //expectedRoot.printTree();
        assertThat(insertIntoBST(root, 5).val, is(expectedRoot.val));
    }
}
