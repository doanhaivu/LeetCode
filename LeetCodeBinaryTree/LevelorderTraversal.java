package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LevelorderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        Queue<List<TreeNode>> aQueue = new LinkedList();

        List<TreeNode> tmpList = new ArrayList();
        tmpList.add(root);
        aQueue.offer(tmpList);

        while (!aQueue.isEmpty()) {
            List<TreeNode> tmp = aQueue.poll();

            List<TreeNode> thisLevelList = new ArrayList<>();
            List<Integer> thisLevelRet = new ArrayList<>();
            //System.out.println("====================");
            for (TreeNode aNode:tmp) {

                thisLevelRet.add(aNode.val);
                //System.out.println("This level: " + aNode.val);

                if (aNode.left != null && aNode.left.val != null) {
                    thisLevelList.add(aNode.left);
                }
                if (aNode.right != null && aNode.right.val != null) {
                    thisLevelList.add(aNode.right);
                }
            }
            if (thisLevelList.size() > 0)
                aQueue.offer(thisLevelList);
            ret.add(thisLevelRet);
        }
        return ret;
    }

    @Test
    public void testLevelorderTraversal() {
        Integer[] nums = new Integer[] {1,null,2,3};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        List<Integer> expected = Arrays.asList(1);
        List<Integer> expected2 = Arrays.asList(2);
        List<Integer> expected3 = Arrays.asList(3);
        List<List<Integer>> aList = new ArrayList<>();
        aList.add(expected);
        aList.add(expected2);
        aList.add(expected3);
        assertThat(levelOrder(treeNode), is(aList));


        nums = new Integer[] {};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList();
        aList = new ArrayList<>();
        aList.add(expected);
        assertThat(levelOrder(treeNode), is(expected));


        nums = new Integer[] {3,9,20,null,null,15,7};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList(3);
        expected2 = Arrays.asList(9,20);
        expected3 = Arrays.asList(15,7);
        aList = new ArrayList<>();
        aList.add(expected);
        aList.add(expected2);
        aList.add(expected3);
        assertThat(levelOrder(treeNode), is(aList));
    }
}
