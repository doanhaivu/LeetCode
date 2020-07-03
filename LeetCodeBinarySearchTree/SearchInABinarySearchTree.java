package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> aStack = new Stack();
        TreeNode tmp = root;
        while (tmp != null || !aStack.isEmpty()) {
            while (tmp != null) {
                if (tmp.val == val)
                    return tmp;
                aStack.push(tmp);
                tmp = tmp.left;
            }
            tmp = aStack.pop();
            //if (tmp.val == val)
            //    return tmp;
            tmp = tmp.right;
        }
        return null;
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{4,2,7,1,3,null,null};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        Integer[] expectedNums = new Integer[]{2,1,3};
        Tree expectedTree = new Tree();
        TreeNode expectedRoot = expectedTree.fromArray(expectedNums);
        assertThat(searchBST(root, 2).val, is(expectedRoot.val));
    }
}
