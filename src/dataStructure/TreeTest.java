package dataStructure;

import java.util.Stack;

public class TreeTest {

    public static void main(String[] args) {
        //findNthDataOfTreeByPostSearch2(createTree(), 4);
        중위탐색_스택이용(createTree());
    }



    public static void 중위탐색_스택이용(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            System.out.println(root.data);
            root = root.right;
        }
    }



    /**
     * 주어진 이진 트리에서 후위탐색(왼쪽, 오른쪽, 루트 순서)시 n번째에 해당하는 값을 출력하라
     */
    private static int count = 0;

    public static void findNthDataOfTreeByPostSearch2(BinaryTreeNode root, int n) {
        if(root == null) {
            return;
        }

        findNthDataOfTreeByPostSearch2(root.left, n);
        findNthDataOfTreeByPostSearch2(root.right, n);

        if(++count == n) {
            System.out.println(root.data);
        }
    }



    private static BinaryTreeNode createTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);

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
