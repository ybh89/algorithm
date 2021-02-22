package dataStructure;

import java.util.*;
import java.util.LinkedList;

/**
 * Least Recently Used Cache
 * 캐시 메모리에 데이터가 캐싱될때 가장 오랫동안 사용되지 않은 데이터를 삭제하고 새로운 데이터를 캐싱하는 것
 */
public class LRUCache<T> {
    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache<>(3);
        cache.query("1");
        cache.query("2");
        cache.query("3");
        cache.query("3");
        cache.print();
    }
    private LRUCacheNode<T> head;
    private LRUCacheNode<T> tail;
    private Map<T, LRUCacheNode<T>> map = new HashMap<>();
    private int cacheSize;
    private int listSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void query(T data) {
        addToTail(data);
    }

    private boolean isFull() {
        return cacheSize == listSize;
    }

    private void addToTail(T data) {
        LRUCacheNode<T> newNode = new LRUCacheNode<>();
        newNode.data = data;

        if(map.containsKey(data)) {
            remove(map.get(data));
            map.remove(data);
        } else if(isFull()) {
            head = head.next;
            head.prev = null;
        }
        add(newNode);
        map.put(data, newNode);
    }

    private void remove(LRUCacheNode<T> node) {
        if(node == head) {
            head = head.next;
            head.prev = null;
        } else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        listSize--;
    }

    private void add(LRUCacheNode<T> newNode) {
        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        listSize++;
    }

    public void print() {
        LRUCacheNode<T> curNode = head;
        StringBuilder sb = new StringBuilder();

        while(curNode != null) {
            sb.append(curNode.data + ", ");
            curNode = curNode.next;
        }
        System.out.println(sb.toString());
    }

    private class LRUCacheNode<T> {
        private T data;
        private LRUCacheNode prev;
        private LRUCacheNode next;
    }
}
