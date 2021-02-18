package dataStructure;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T> {
    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    public void add(T data) {
        //노드 생성
        LinkedListNode<T> newNode = new LinkedListNode(data);

        //노드 연결
        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;

        size++;
    }

    public void addFirst(T data) {
        if(head == null) {
            add(data);
        }else {
            LinkedListNode<T> newNode = new LinkedListNode(data);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;

            size++;
        }
    }

    public void set(int index, T data) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        LinkedListNode<T> curNode = goToIndex(index);

        if(index == 0) { // 첫번째 요소에 연결하는 경우
            addFirst(data);
        }
        else if(curNode == null) { // 마지막 요소 뒤에 연결하는 경우
            add(data);
        }else {
            LinkedListNode<T> newNode = new LinkedListNode(data);
            newNode.prev = curNode.prev;
            curNode.prev.next = newNode;
            newNode.next = curNode;
            curNode.prev = newNode;

            size++;
        }
    }

    public void remove(int index) {
        if(size == 0 || index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        LinkedListNode<T> curNode = goToIndex(index);

        if(curNode == head && tail != null) {
            head = curNode.next;
        } else if(curNode == tail && head != null) {
            tail = curNode.prev;
            tail.next = null;
        } else {
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
        }
        curNode = null;
        size--;
    }

    public void reverse() {
        LinkedListNode<T> curNode = head;

        while(curNode != null) {
            //prev와 next를 swap
            LinkedListNode<T> temp = curNode.prev;
            curNode.prev = curNode.next;
            curNode.next = temp;

            //prev와 next가 바뀐 상황이므로 다음 노드는 prev로 변경
            curNode = curNode.prev;
        }

        //head와 tail을 swap
        LinkedListNode<T> temp = head;
        head = tail;
        tail = temp;
    }
    
    public void reverseByRecursion() {
        LinkedListNode<T> curNode = head;
        reverse2(curNode);

        LinkedListNode<T> temp = head;
        head = tail;
        tail = temp;
    }

    public void reverse2(LinkedListNode<T> curNode) {
        if(curNode == null) {
            return;
        }

        LinkedListNode<T> temp = curNode.prev;
        curNode.prev = curNode.next;
        curNode.next = temp;

        reverse2(curNode.prev);
    }

    /**
     * 마지막 요소로 부터 n번째에 있는 노드를 찾는 함수
     * 단, 리스트의 사이즈를 모른다고 가정.
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(1)
     */
    public LinkedListNode<T> findFromLast(int n) {
        LinkedListNode<T> leftNode = head, rightNode = head;

        int count = 1;
        while(rightNode.next != null) {
            if(count < n) {
                rightNode = rightNode.next;
            }else {
                rightNode = rightNode.next;
                leftNode = leftNode.next;
            }

            count++;
        }

        return leftNode;
    }

    /**
     * 리스트에서 중복된 노드 제거하기
     * 단, 나중에 나온 노드를 제거해야한다.
     * ex) 1->1->1->2->3->1->2   =>   1->2->3
     */
    public void removeDuplicates() {
        LinkedListNode<T> curNode = head;
        LinkedListNode<T> preNode = head;

        Set<T> checker = new HashSet<>();

        while (curNode != null) {
            if(checker.contains(curNode.data)) {
                if(!curNode.data.equals(curNode.prev.data)) {
                    preNode.next = curNode;
                    curNode.prev = preNode;
                }

            } else {
                checker.add(curNode.data);

            }
            curNode = curNode.next;
        }
    }

    private LinkedListNode<T> goToIndex(int index) {
        LinkedListNode<T> curNode = head;
        for(int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        return curNode;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        LinkedListNode<T> curNode = head;
        StringBuilder str = new StringBuilder();

        while(curNode != null) {
            str.append(curNode.data+", ");
            curNode = curNode.next;
        }

        return str.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

    private class LinkedListNode<T> {
        private LinkedListNode prev;
        private LinkedListNode next;
        private T data;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.findFromLast(3).data);
        System.out.println(list.getSize());
        list.print();
    }
}
