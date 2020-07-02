package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> ret = new ArrayList<>();

        traverseWithStack(root, ret);

        //System.out.println(Arrays.toString(ret.toArray()));
        for (int i = 0; i < ret.size()-1; i++) {
            if (ret.get(i) >= ret.get(i+1))
                return false;
        }
        return true;
    }

    public void traverse(TreeNode aNode, List<Integer> ret) {
        if (aNode != null) {
            traverse(aNode.left, ret);
            if (aNode.val != null) ret.add(aNode.val);
            traverse(aNode.right, ret);
        }
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

    @Test
    public void test() {
        Integer[] nums = new Integer[] {2,1,3};
        Tree aTree = new Tree();
        TreeNode treeNode = aTree.fromArray(nums);
        treeNode.printTree();

        assertThat(isValidBST(treeNode), is(true));

        nums = new Integer[] {5,1,4,null,null,3,6};
        aTree = new Tree();
        treeNode = aTree.fromArray(nums);
        treeNode.printTree();

        assertThat(isValidBST(treeNode), is(false));

        nums = new Integer[] {1,1};
        aTree = new Tree();
        treeNode = aTree.fromArray(nums);
        treeNode.printTree();

        assertThat(isValidBST(treeNode), is(false));

        nums = new Integer[] {0};
        aTree = new Tree();
        treeNode = aTree.fromArray(nums);
        treeNode.printTree();

        assertThat(isValidBST(treeNode), is(true));

        nums = new Integer[] {0,-1};
        aTree = new Tree();
        treeNode = aTree.fromArray(nums);
        treeNode.printTree();

        assertThat(isValidBST(treeNode), is(true));
    }
}


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