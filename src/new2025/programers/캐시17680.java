package new2025.programers;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class 캐시17680 {
    public static void main(String[] args) {
        캐시17680 sol = new 캐시17680();
        System.out.println(sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(sol.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(sol.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(sol.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(sol.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(sol.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public int solution(int cacheSize, String[] cities) {
        final int[] latency = {0};
        LRU lru = new LRU(cacheSize);

        for (String city : cities) {
            lru.get(city)
                    .ifPresentOrElse(s -> latency[0] = latency[0] + 1, () -> {
                        latency[0] = latency[0] + 5;
                        lru.cache(city);
                    });
        }

        return latency[0];
    }

    static class LRU {
        private Set<String> cache = new LinkedHashSet<>();
        private final int cacheMaxSize;

        public LRU(int cacheMaxSize) {
            this.cacheMaxSize = cacheMaxSize;
        }

        public Optional<String> get(String key) {
            if (cacheMaxSize <= 0) {
                return Optional.empty();
            }
            String innerKey = key.toLowerCase();
            if (cache.contains(innerKey)) {
                cache.remove(innerKey);
                cache.add(innerKey);
                return Optional.of(key);
            }
            return Optional.empty();
        }

        public void cache(String key) {
            if (cacheMaxSize <= 0) {
                return;
            }
            String innerKey = key.toLowerCase();
            if (cache.contains(innerKey)) {
                cache.remove(innerKey);
                cache.add(innerKey);
            }
            else {
                if (cache.size() < cacheMaxSize) {
                    cache.add(innerKey);
                }
                else {
                    String first = cache.stream().findFirst().get();
                    cache.remove(first);
                    cache.add(innerKey);
                }
            }
        }
    }
}
