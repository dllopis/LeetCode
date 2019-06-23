package easy;

public class PathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/* 	LEETCODE PROBLEM #112	*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null && sum - root.val == 0)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

