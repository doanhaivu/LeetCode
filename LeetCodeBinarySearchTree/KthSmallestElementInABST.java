package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> ret = new ArrayList<>();
        TreeNode tmp = root;

        Stack<TreeNode> aStack = new Stack<>();
        aStack.push(tmp);
        HashMap<Integer, Boolean> visited = new HashMap<>();

        while (!aStack.isEmpty()) {
            tmp = aStack.peek();
            if (tmp != null) {
                if (tmp.left != null && tmp.left.val != null && !visited.containsKey(tmp.left.val)) {
                    aStack.push(tmp.left);
                    visited.put(tmp.left.val, true);
                } else {
                    ret.add(tmp.val);
                    aStack.pop();
                    if (tmp.right != null && tmp.right.val != null && !visited.containsKey(tmp.right.val)) {
                        aStack.push(tmp.right);
                        visited.put(tmp.right.val, true);
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(ret.toArray()));
        return ret.get(k-1);
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{3,1,4,null,2};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        assertThat(kthSmallest(root, 1), is(1));

        nums = new Integer[]{5,3,6,2,4,null,null,1};
        aTree = new Tree();
        root = aTree.fromArray(nums);

        assertThat(kthSmallest(root, 3), is(3));
    }
}
