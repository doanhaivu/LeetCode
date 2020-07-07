package LeetCode.LeetCodeBinarySearchTree;

import LeetCode.LeetCodeBinaryTree.Tree;
import LeetCode.LeetCodeBinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tmp = root;
        TreeNode prev = null;
        boolean flag = false;
        while (tmp != null && tmp.val != null) {
            if (tmp.val == key) {
                flag = true;
                break;
            }
            prev = tmp;
            tmp = tmp.val > key ? tmp.left:tmp.right;
        }
        if (flag) {
            if (tmp.left != null && tmp.right != null && tmp.left.val != null && tmp.right.val != null) {
                System.out.println("AAAAA");
                TreeNode leftMost = tmp.right;
                prev = tmp;
                while (leftMost.left != null && leftMost.left.val != null) {
                    prev = leftMost;
                    leftMost = leftMost.left;
                }
                tmp.val = leftMost.val;
                if (leftMost == prev.left)
                    prev.left = leftMost.right;
                else prev.right = leftMost.right;
            } else {
                if (tmp.left != null && tmp.left.val != null && tmp.right != null && tmp.right.val == null) {
                    System.out.println("BBBBB");
                    tmp.val = tmp.left.val;
                    TreeNode tmpLeft = tmp.left.left;
                    TreeNode tmpRight = tmp.left.right;
                    tmp.left = tmpLeft;
                    tmp.right = tmpRight;
                    //tmp.left = null;
                } else if (tmp.right != null && tmp.right.val != null && tmp.left != null && tmp.left.val == null) {
                    System.out.println("CCCCC");
                    //if (prev.left == tmp) prev.left = tmp.right;
                    //else prev.right = tmp.right;
                    tmp.val = tmp.right.val;
                    TreeNode tmpLeft = tmp.right.left;
                    TreeNode tmpRight = tmp.right.right;
                    tmp.left = tmpLeft;
                    tmp.right = tmpRight;
                    //tmp.right = null;
                } else {
                    if (prev == null)
                        return null;
                    if (tmp.val != null && prev.val > tmp.val) {
                        System.out.println("DDDDD");
                        prev.left = null;
                    } else {
                        System.out.println("EEEEE");
                        prev.right = null;
                    }
                }
            }
        }

        return root;
    }

    /**
     * No difference from above, just for submitting to Leetcode because of TreeNode.val type
     */
    public TreeNode deleteNode2(TreeNode root, int key) {
        TreeNode tmp = root;
        TreeNode prev = null;
        boolean flag = false;
        while (tmp != null) {
            if (tmp.val == key) {
                flag = true;
                break;
            }
            prev = tmp;
            tmp = tmp.val > key ? tmp.left:tmp.right;
        }
        if (flag) {
            if (tmp.left != null && tmp.right != null) {
                TreeNode leftMost = tmp.right;
                prev = tmp;
                while (leftMost.left != null) {
                    prev = leftMost;
                    leftMost = leftMost.left;
                }
                tmp.val = leftMost.val;
                if (leftMost == prev.left)
                    prev.left = leftMost.right;
                else prev.right = leftMost.right;
            } else {
                if (tmp.left != null && tmp.right == null) {
                    tmp.val = tmp.left.val;
                    TreeNode tmpLeft = tmp.left.left;
                    TreeNode tmpRight = tmp.left.right;
                    tmp.left = tmpLeft;
                    tmp.right = tmpRight;
                } else if (tmp.right != null && tmp.left == null) {
                    tmp.val = tmp.right.val;
                    TreeNode tmpLeft = tmp.right.left;
                    TreeNode tmpRight = tmp.right.right;
                    tmp.left = tmpLeft;
                    tmp.right = tmpRight;
                } else {
                    if (prev == null)
                        return null;
                    if (prev.val > tmp.val) {
                        prev.left = null;
                    } else {
                        prev.right = null;
                    }
                }
            }
        }

        return root;
    }

    @Test
    public void test() {
        Integer[] nums = new Integer[]{5,3,6,2,4,null,7};
        Tree aTree = new Tree();
        TreeNode root = aTree.fromArray(nums);
        //root.printTree();

        Integer[] expectedNums = new Integer[]{5,4,6,2,null,null,7};
        Tree expectedTree = new Tree();
        TreeNode expectedRoot = expectedTree.fromArray(expectedNums);
        //expectedRoot.printTree();
        TreeNode result = null;

        result = deleteNode(root, 3);
        result.printTree();

        assertThat(result.val, is(expectedRoot.val));

        nums = new Integer[]{0};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        expectedNums = new Integer[]{};
        expectedTree = new Tree();
        expectedRoot = expectedTree.fromArray(expectedNums);
        //expectedRoot.printTree();
        //result = deleteNode(root, 0);
        //result.printTree();

        //assertThat(result.val, is(expectedRoot.val));

        nums = new Integer[]{1,null,2};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        expectedNums = new Integer[]{2};
        expectedTree = new Tree();
        expectedRoot = expectedTree.fromArray(expectedNums);
        expectedRoot.printTree();
        result = deleteNode(root, 1);
        result.printTree();

        assertThat(result.val, is(expectedRoot.val));

        nums = new Integer[]{3,1,4,null,2};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        expectedNums = new Integer[]{4,1,null,null,2};
        expectedTree = new Tree();
        expectedRoot = expectedTree.fromArray(expectedNums);
        expectedRoot.printTree();
        result = deleteNode(root, 3);
        result.printTree();

        assertThat(result.val, is(expectedRoot.val));


        nums = new Integer[]{8,0,31,null,6,28,45,1,7,25,30,32,49,null,4,null,null,9,26,29,null,null,42,47,null,2,5,null,12,null,27,null,null,41,43,46,48,null,3,null,null,10,19,null,null,33,null,null,44,null,null,null,null,null,null,null,11,18,20,null,37,null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,null,23,null,null,35,null,40,null,17};
        aTree = new Tree();
        root = aTree.fromArray(nums);
        root.printTree();

        expectedNums = new Integer[]{8,0,31,null,6,28,45,2,7,25,30,32,49,null,4,null,null,9,26,29,null,null,42,47,null,3,5,null,12,null,27,null,null,41,43,46,48,null,null,null,null,10,19,null,null,33,null,null,44,null,null,null,null,null,11,18,20,null,37,null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,null,23,null,null,35,null,40,null,17};
        expectedTree = new Tree();
        expectedRoot = expectedTree.fromArray(expectedNums);
        expectedRoot.printTree();
        result = deleteNode(root, 1);
        result.printTree();

        assertThat(result.val, is(expectedRoot.val));
    }
}
