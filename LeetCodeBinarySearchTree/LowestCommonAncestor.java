package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return search(root, p, q);
        TreeNode ret = root;

        while (ret != null) {
            if (p.val < ret.val && q.val < ret.val) {
                ret = ret.left;
            } else if (p.val > ret.val && q.val > ret.val) {
                ret = ret.right;
            } else return ret;
        }

        return null;
    }

    public TreeNode search(TreeNode tmp, TreeNode p, TreeNode q) {
        if (tmp.val == p.val || tmp.val == q.val) {
            return tmp;
        }
        if ((p.val < tmp.val && q.val > tmp.val) || (q.val < tmp.val && p.val > tmp.val)) {
            return tmp;
        } else {
            if (p.val < tmp.val && q.val < tmp.val)
                return search(tmp.left, p, q);
            else return search(tmp.right, p, q);
        }
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        TreeNode p = aTree.getNode(root, 2);
        TreeNode q = aTree.getNode(root, 8);
        TreeNode ret = aTree.getNode(root, 6);

        assertThat(lowestCommonAncestor(root, p, q).val, is(ret.val));

        q = aTree.getNode(root, 4);

        assertThat(lowestCommonAncestor(root, p, q).val, is(p.val));

        nums = new Integer[]{2,1};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        p = aTree.getNode(root, 2);
        q = aTree.getNode(root, 1);

        assertThat(lowestCommonAncestor(root, p, q).val, is(p.val));

        nums = new Integer[]{2,null,3};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        p = aTree.getNode(root, 3);
        q = aTree.getNode(root, 2);
        assertThat(lowestCommonAncestor(root, p, q).val, is(q.val));
    }

    @Test
    public void testGetNode() {
        Integer[] nums = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        System.out.println(aTree.getNode(root, 6).val);
        System.out.println(aTree.getNode(root, 2).val);
        System.out.println(aTree.getNode(root, 8).val);
        System.out.println(aTree.getNode(root, 0).val);
        System.out.println(aTree.getNode(root, 4).val);
        System.out.println(aTree.getNode(root, 7).val);
        System.out.println(aTree.getNode(root, 9).val);
        System.out.println(aTree.getNode(root, 3).val);
        System.out.println(aTree.getNode(root, 5).val);
    }

}
