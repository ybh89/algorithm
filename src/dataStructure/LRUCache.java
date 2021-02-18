package dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Least Recently Used Cache
 * 캐시 메모리에 데이터가 캐싱될때 가장 오랫동안 사용되지 않은 데이터를 삭제하고 새로운 데이터를 캐싱하는 것
 */
public class LRUCache<T> {
    private List<T> list = new LinkedList<>();
    private Map<Integer, T> cache = new HashMap<>();
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void caching(T data) {
        if(!isFullSize()) {
            list.add(data);
            cache.put(list.size()-1, data);
        }else {
            list.remove(0);
            list.add(data);
        }
    }

    public boolean isFullSize() {
        return cache.size() >= cacheSize;
    }
}
