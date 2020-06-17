package LeetCode.LeetCodeBinaryTree;

import Stack.MyStack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        traverse(root, ret);

        return ret;
    }

    public void traverse(TreeNode aNode, List<Integer> aList) {
        if (aNode != null && aNode.val != null) {
            aList.add(aNode.val);
            traverse(aNode.left, aList);
            traverse(aNode.right, aList);
        }
    }

    public List<Integer> preorderTraversalWithStack(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        if (root != null) {
            Stack aStack = new Stack();
            aStack.push(root);
            while (!aStack.empty()) {
                TreeNode aNode = (TreeNode)aStack.pop();
                if (aNode != null && aNode.val != null) {
                    ret.add(aNode.val);
                    aStack.push(aNode.right);
                    aStack.push(aNode.left);
                }
            }
        }

        return ret;
    }

    @Test
    public void testPreorderTraversal() {
        Integer[] nums = new Integer[] {1,null,2,3};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        List<Integer> expected = Arrays.asList(1,2,3);
        assertThat(preorderTraversal(treeNode), is(expected));

        nums = new Integer[] {};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList();
        assertThat(preorderTraversal(treeNode), is(expected));

        nums = new Integer[] {1, 2, 3, 4, null, null, 5, null, null, null, 6};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList(1,2,4,3,5,6);
        assertThat(preorderTraversalWithStack(treeNode), is(expected));
    }
}
