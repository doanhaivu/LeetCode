package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode tmp = null;
        Stack<TreeNode> aStack = new Stack<>();
        aStack.push(s);

        while (!aStack.isEmpty()) {
            tmp = aStack.pop();
            if (tmp != null) {
                if (tmp.val == t.val)
                    if(sameTree(tmp, t))
                        return true;
                aStack.push(tmp.right);
                aStack.push(tmp.left);
            }
        }
        return false;
    }

    public boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;

        if (s != null && t != null && s.val == t.val) {
            return sameTree(s.left, t.left) && sameTree(s.right, t.right);
        } else return false;
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{3,4,5,1,2,null,null};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        Integer[] nums2 = new Integer[]{4,1,2};
        Tree aTree2 = new Tree();
        TreeNode root2 = aTree2.fromArray(nums2);
        root2.printTree();

        assertThat(isSubtree(root, root2), is(true));

        nums = new Integer[]{3,4,5,1,2,null,null,null,null,0,null};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        assertThat(isSubtree(root, root2), is(false));

        nums = new Integer[]{1,1};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        nums2 = new Integer[]{1};
        aTree2 = new Tree();
        root2 = aTree2.fromArray(nums2);
        root2.printTree();

        assertThat(isSubtree(root, root2), is(true));
    }
}
