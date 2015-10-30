/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        BFS(root, res);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {//需要倒置的链表
                List<Integer> line = res.get(i);
                Collections.reverse(line);
            }
        }
        return res;
    }

    private void BFS(TreeNode root, List<List<Integer>> res) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return;
        LinkedList<Integer> line = new LinkedList<>();
        line.add(root.val);
        res.add(line);
        int level = 0;
        if (root.left != null) queue.offer(new Node(level + 1, root.left));
        if (root.right != null) queue.offer(new Node(level + 1, root.right));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.level == level) {//还在同一层
                line.add(node.node.val);
            } else {//新出的节点不在同一层
                line = new LinkedList<>();
                line.add(node.node.val);
                res.add(line);
                level = node.level;
            }
            if (node.node.left != null) queue.offer(new Node(node.level + 1, node.node.left));
            if (node.node.right != null) queue.offer(new Node(node.level + 1, node.node.right));
        }
    }

    private class Node {
        public Node(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }

        int level;
        TreeNode node;
    }
}