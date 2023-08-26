package medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInABinaryTree {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int length = queue.size();
            long sum = 0;
            for(int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            pq.add(sum);
            if(pq.size() > k) pq.poll();
        }

        if(pq.size() < k) return -1;
        
        return pq.poll();
    }

    public static void main(String[] args) {
        KthLargestSumInABinaryTree solution = new KthLargestSumInABinaryTree();
        TreeNode root = solution.new TreeNode(5);
        root.left = solution.new TreeNode(8);
        root.right = solution.new TreeNode(9);
        root.left.left = solution.new TreeNode(2);
        root.left.right = solution.new TreeNode(1);
        root.right.left = solution.new TreeNode(3);
        root.right.right = solution.new TreeNode(7);
        root.left.left.left = solution.new TreeNode(4);
        root.left.left.right = solution.new TreeNode(6);

        long result = solution.kthLargestLevelSum(root, 2);
        System.out.printf("Result of kth largest level sum in binary tree: %d", result);
    }
}
