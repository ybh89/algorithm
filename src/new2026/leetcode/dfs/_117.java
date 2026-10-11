package new2026.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class _117 {
    public Node connect(Node root) {
        dfs(root, 1, new HashMap<>());
        return root;
    }

    public void dfs(Node node, int depth, Map<Integer, Node> preNodes) {
        if (node == null) {
            return;
        }

        preNodes.compute(depth, (key, value) -> {
            if (value != null) {
                value.next = node;
            }
            value = node;
            return value;
        });

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            dfs(node.left, depth + 1, preNodes);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1, preNodes);
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
