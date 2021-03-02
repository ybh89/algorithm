package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println(maxSumOfBinaryTree(createTree()));
    }

    /**
     * 바이너리 트리의 계층별 합계 중에 최대 값을 구하라.(BFS)
     *
     *    9  -> 9
     *   2 3  -> 5
     * 1 5 4  -> 10
     * ==========> 10
     */
    public static int maxSumOfBinaryTree(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }

        int result = 0;
        int parentsLevelSum = 0;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()) {
            int levelSize = q.size();
            int levelSum = 0;

            for(int i=0; i<levelSize; i++) {
                BinaryTreeNode curNode = q.poll();
                levelSum += curNode.data;

                if(curNode.left != null) {
                    q.offer(curNode.left);
                }

                if(curNode.right != null) {
                    q.offer(curNode.right);
                }
            }

            result = Math.max(parentsLevelSum, levelSum);
            parentsLevelSum = levelSum;
        }

        return result;
    }

    private static BinaryTreeNode createTree() {
        BinaryTreeNode root = new BinaryTreeNode(4);
        BinaryTreeNode node1 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        return root;
    }

    private static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;

        public BinaryTreeNode(int data) {
            this.data = data;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
