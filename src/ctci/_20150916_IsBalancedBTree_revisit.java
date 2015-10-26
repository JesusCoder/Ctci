package ctci;

import TreeUtils.TreeNode;

//TODO: not finished yet.

/*Cracking 4.1:
 *Implement a function to check if a binary tree
 *is balanced. For the purposes of this question, a
 *balanced tree is defined to be a tree such that the
 *heights of the two subtrees of any node never differ 
 *by more than one.*/

public class _20150916_IsBalancedBTree_revisit {

	public static int checkHeight(TreeNode root) {

		if (root == null)
			return 1;
		/* If unbalanced, directly return -1 to break */
		int rightTreeHeight = checkHeight(root.right);
		if (rightTreeHeight == -1)
			return -1;

		int leftTreeHeight = checkHeight(root.left);
		if (leftTreeHeight == -1)
			return -1;
		int heightDiff = Math.abs(rightTreeHeight - leftTreeHeight);

		if (heightDiff > 1)
			return -1;
		else
			return heightDiff;
	}
		
	

	public static boolean isBalanced(TreeNode tn) {

		return false;
	}

	public static void main(String arg[]){
	}
}
