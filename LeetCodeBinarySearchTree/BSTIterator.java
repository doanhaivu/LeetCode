package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    List<Integer> ret = new ArrayList<>();
    int iterator = -1;

    //public BSTIterator(TreeNode root) {
    //    traverseWithStack(root, ret);
    //}

    public BSTIterator() {
    }

    public void init(TreeNode root) {
        traverseWithStack(root, ret);
    }

    public void traverseWithStack(TreeNode aNode, List<Integer> ret) {
        if (aNode != null) {

            Stack<TreeNode> aStack = new Stack<>();

            while (aNode != null || !aStack.isEmpty()) {
                while (aNode != null) {
                    aStack.push(aNode);
                    aNode = aNode.left;
                }
                aNode = aStack.pop();
                if (aNode.val != null)
                    ret.add(aNode.val);
                aNode = aNode.right;
            }
        }
    }

    /** @return the next smallest number */
    public int next() {
        return ret.get(++iterator);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return  ret.size() > 0 && iterator < ret.size()-1;
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{7,3,15,null,null,9,20};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        root.printTree();

        BSTIterator iterator = new BSTIterator();
        iterator.init(root);

        assertThat(iterator.next(), is(3));   // return 3
        assertThat(iterator.next(), is(7));    // return 7
        assertThat(iterator.hasNext(), is(true)); // return true
        assertThat(iterator.next(), is(9));    // return 9
        assertThat(iterator.hasNext(), is(true)); // return true
        assertThat(iterator.next(), is(15));    // return 15
        assertThat(iterator.hasNext(), is(true)); // return true
        assertThat(iterator.next(), is(20));    // return 20
        assertThat(iterator.hasNext(), is(false)); // return false

        nums = new Integer[]{1};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        iterator = new BSTIterator();
        iterator.init(root);

        assertThat(iterator.hasNext(), is(true)); // return true
        assertThat(iterator.next(), is(1));   // return 3
        assertThat(iterator.hasNext(), is(false)); // return true


    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
