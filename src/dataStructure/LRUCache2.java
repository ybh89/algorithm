package dataStructure;

import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache2 {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(3);
        cache.query("1");
        cache.query("2");
        cache.query("3");
        cache.query("1");
        cache.print();
    }

    private Set<String> set = new LinkedHashSet<>();
    private int cacheSize;

    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void query(String data) {
        if(set.contains(data)) {
            set.remove(data);
        } else if(isFull()) {
            set.remove(set.iterator().next());
        }
        set.add(data);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        set.stream().forEach(data -> sb.append(data+", "));
        System.out.println(sb.toString());
    }

    private boolean isFull() {
        return set.size() == cacheSize;
    }
}
