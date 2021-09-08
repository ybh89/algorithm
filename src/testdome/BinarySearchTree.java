package testdome;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        Node node = find(root, value);
        if (node == null) {
            return false;
        }

        return true;
    }

    private static Node find(Node root, int value) {
        Node currentNode = root;
        while (currentNode != null && currentNode.value != value) {
            if (currentNode.value < value) {
                currentNode = currentNode.right;
                continue;
            }

            if (currentNode.value > value) {
                currentNode = currentNode.left;
                continue;
            }
        }
        return currentNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}
