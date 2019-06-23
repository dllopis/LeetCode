package medium;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

/* 	LEETCODE PROBLEM #98	*/
public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if(root == null)
			return true;
		if(root.val == min && root.left != null)   return false;
        if(root.val == max && root.right != null)  return false;
        
		if(min != null && root.val < min || max != null && root.val > max)
			return false;
		
		return isValidBST(root.left,min,root.val-1) && isValidBST(root.right,root.val+1,max);
    }
}
