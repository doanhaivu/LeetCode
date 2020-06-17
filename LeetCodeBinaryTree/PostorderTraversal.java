package LeetCode.LeetCodeBinaryTree;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root != null) {
            traverse(root, ret);
        }
        return ret;
    }

    public void traverse(TreeNode aNode, List<Integer> aList) {
        if (aNode != null && aNode.val != null) {
            traverse(aNode.left, aList);
            traverse(aNode.right, aList);
            aList.add(aNode.val);
        }
    }

    public List<Integer> traverseWithStack(TreeNode root) {
        LinkedList ret = new LinkedList();

        if (root != null) {
            Stack aStack = new Stack();
            aStack.push(root);

            while (!aStack.empty()) {
                TreeNode aNode = (TreeNode)aStack.pop();
                if (aNode != null && aNode.val != null) {
                    ret.addFirst(aNode.val);
                    if (aNode.left != null) aStack.push(aNode.left);
                    if (aNode.right != null) aStack.push(aNode.right);
                }
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

        List<Integer> expected = Arrays.asList(3,2,1);
        assertThat(traverseWithStack(treeNode), is(expected));

        nums = new Integer[] {};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList();
        assertThat(postorderTraversal(treeNode), is(expected));

        /*
        nums = new Integer[] {1, 2, 3, 4, null, null, 5, null, null, null, 6};
        tr = new Tree();
        treeNode = tr.fromArray(nums);

        try {
            treeNode.printTree();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        expected = Arrays.asList(4,2,1,3,5,6);
        assertThat(postorderTraversal(treeNode), is(expected));*/
    }

    /**
     * leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/discuss/45559/My-Accepted-code-with-explaination.-Does-anyone-have-a-better-idea/45086
     */
    /**
     * There is an universal idea for preorder traversal inorder traversal and postorder traversal. For each node N, we process it as follows:-------
     * push N in stack -> push left tree of N in stack -> pop left tree of N -> push right tree of N in stack -> pop right tree of N -> pop N---------
     * For preorder traversal, we visit a node when pushing it in stack. For inorder traversal, we visit a node when pushing its right child in stack. for postorder traversal, we visit a node when popping it. last_pop represents the node which is popped the last time. For the top node in stack, it has three choices, pushing its left child in stack, or pushing its right child in stack, or being popped. If last_pop != top->left, meaning that its left tree has not been pushed in stack, then we push its left child. If last_pop == top->left, we push its right child. Otherwise, we pop the top node.
     */
    /*
    void preorder_traversal_iteratively(TreeNode* root)
{
	if (root == 0)
		return;
	stack<TreeNode*> s;
	s.push(root);
	cout << root->val << ' '; // visit root
	TreeNode* last_pop = root;
	while (!s.empty())
	{
		TreeNode* top = s.top();
		if (top->left != 0 && top->left != last_pop && top->right != last_pop) // push_left
		{
			s.push(top->left);
			cout << top->left->val << ' '; // visit top->left
		}
		else if (top->right != 0 && top->right != last_pop && (top->left == 0 || top->left == last_pop)) // push_right
		{
			s.push(top->right);
			cout << top->right->val << ' '; // visit top->right
		}
		else // pop
		{
			s.pop();
			last_pop = top;
		}
	}
}

void inorder_traversal_iteratively(TreeNode* root)
{
	if (root == 0)
		return;
	stack<TreeNode*> s;
	s.push(root);
	TreeNode* last_pop = root;
	while (!s.empty())
	{
		TreeNode* top = s.top();
		if (top->left != 0 && top->left != last_pop && top->right != last_pop) // push_left
		{
			s.push(top->left);
		}
		else if (top->right != 0 && top->right != last_pop && (top->left == 0 || top->left == last_pop)) // push_right
		{
			s.push(top->right);
			cout << top->val << ' '; // visit top
		}
		else // pop
		{
			s.pop();
			last_pop = top;
			if (top->right == 0)
				cout << top->val << ' '; // visit top
		}
	}
}

void postorder_traversal_iteratively(TreeNode* root)
{
	if (root == 0)
		return;
	stack<TreeNode*> s;
	s.push(root);
	TreeNode* last_pop = root;
	while (!s.empty())
	{
		TreeNode* top = s.top();
		if (top->left != 0 && top->left != last_pop && top->right != last_pop) // push_left
		{
			s.push(top->left);
		}
		else if (top->right != 0 && top->right != last_pop && (top->left == 0 || top->left == last_pop)) // push_right
		{
			s.push(top->right);
		}
		else // pop
		{
			s.pop();
			last_pop = top;
			cout << top->val << ' '; // visit top
		}
	}
}
     */
}
