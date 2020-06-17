/**
 * my own solution
 */
package LeetCode.LeetCodeBinaryTree;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<List<TreeNode>> aQueue = new LinkedList<>();
        List<List<Integer>> aList = new ArrayList<>();

        List<TreeNode> tmpList = new ArrayList<>();
        tmpList.add(root);

        aQueue.offer(tmpList);

        while (!aQueue.isEmpty()) {
            List<TreeNode> tmp = aQueue.poll();

            List<TreeNode> innerList = new ArrayList<>();
            List<Integer> toList = new ArrayList<>();

            for (TreeNode aNode:tmp) {

                if (aNode == null) {
                    toList.add(null);
                    continue;
                }
                toList.add(aNode.val);

                if (aNode.left != null && aNode.right == null) {
                    innerList.add(aNode.left);
                    innerList.add(null);
                } else if (aNode.right != null && aNode.left == null) {
                    innerList.add(null);
                    innerList.add(aNode.right);
                } else if (aNode.right != null && aNode.left != null) {
                    innerList.add(aNode.left);
                    innerList.add(aNode.right);
                } else if (aNode.right == null && aNode.left == null) {
                    innerList.add(null);
                    innerList.add(null);
                }
            }
            aList.add(toList);
            if (innerList.size() > 0) {
                boolean flag = false;
                for (TreeNode tn:innerList) {
                    if (tn != null) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    aQueue.offer(innerList);
            }

        }

        //System.out.println(Arrays.toString(aList.toArray()));
        //System.out.println("==================");

        for (List<Integer> toCheck:aList) {
            if (!isPalindrome(toCheck))
                return false;
        }

        return true;
    }

    public boolean isPalindrome(List<Integer> aList) {
        List<Integer> reverseList = reverse(aList);

        //System.out.println(Arrays.toString(aList.toArray()));
        //System.out.println(Arrays.toString(reverseList.toArray()));

        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i) != reverseList.get(i))
                return false;
        }
        return true;
    }

    public List<Integer> reverse(List<Integer> aList) {
        List<Integer> ret = new ArrayList<>();
        for (int i = aList.size()-1; i >=0; i--) {
            ret.add(aList.get(i));
        }
        return ret;
    }

    @Test
    public void testIsSymmetric() {
        Integer[] nums = new Integer[] {1,2,2,3,4,4,3};
        Tree tr = new Tree();
        TreeNode treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(isSymmetric(treeNode), is(true));

        nums = new Integer[] {1,2,2,null,3,null,3};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(isSymmetric(treeNode), is(false));

        nums = new Integer[] {2,3,3,4,5,5,4,null,null,8,9,null,null,9,8};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        assertThat(isSymmetric(treeNode), is(false));
    }
}
