package LeetCode.LeetCodeBinaryTree;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        traverse(root, ret);

        return ret;
    }

    public void traverse(TreeNode aNode, List<Integer> aList) {
        if (aNode != null && aNode.val != null) {
            traverse(aNode.left, aList);
            aList.add(aNode.val);
            traverse(aNode.right, aList);
        }
    }

    public List<Integer> traverseWithStack(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        if (root != null) {
            Stack aStack = new Stack();
            //aStack.push(root);
            TreeNode aNode = root;
            //while (!aStack.empty()) {
            while (aNode != null ||  !aStack.empty()) {
                while (aNode != null) {
                    aStack.push(aNode);
                    aNode = aNode.left;
                }

                aNode = (TreeNode)aStack.pop();
                if (aNode.val != null)
                    ret.add(aNode.val);
                aNode = aNode.right;
            }
        }

        return ret;
    }

    @Test
    public void testInorderTraversal() {
        Integer[] nums = new Integer[] {1,null,2,3};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        List<Integer> expected = Arrays.asList(1,3,2);
        assertThat(inorderTraversal(treeNode), is(expected));

        nums = new Integer[] {};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList();
        assertThat(inorderTraversal(treeNode), is(expected));

        nums = new Integer[] {1, 2, 3, 4, null, null, 5, null, null, null, 6};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList(4,2,1,3,5,6);
        assertThat(traverseWithStack(treeNode), is(expected));
    }
}
