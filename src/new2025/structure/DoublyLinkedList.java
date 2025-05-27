package new2025.structure;

public class DoublyLinkedList<T> {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.print("초기 리스트: ");
        list.printList(); // 10 20 30 40

        Node<Integer> node = list.find(20);
        if (node != null) {
            System.out.println("찾은 노드의 값: " + node.value);
        } else {
            System.out.println("노드를 찾을 수 없습니다.");
        }

        boolean isDeleted = list.delete(20);
        System.out.println("삭제: " + (isDeleted ? "성공" : "실패"));

        System.out.print("삭제 후 리스트: ");
        list.printList(); // 10 20 40

    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }

    public Node<T> find(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

    public boolean delete(T value) {
        Node<T> node = find(value);
        if (node != null) {
            Node<T> prev = node.getPrev();
            Node<T> next = node.getNext();

            if (prev == null) {
                next.setPrev(null);
                head = next;
                return true;
            }

            if (next == null) {
                prev.setNext(null);
                tail = prev;
                return true;
            }

            prev.setNext(next);
            next.setPrev(prev);
            return true;
        }

        return false;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + ", ");
            current = current.next;
        }
        System.out.println();
    }

    static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
