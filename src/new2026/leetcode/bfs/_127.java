package new2026.leetcode.bfs;

import java.util.*;

public class _127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patternMap = new HashMap<>();
        wordList.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                StringBuilder sb = new StringBuilder(word);
                sb.replace(j, j + 1, "*");

                patternMap.compute(sb.toString(), (k, v) -> {
                    if (v == null) {
                        v = new ArrayList<>();
                    }
                    v.add(word);
                    return v;
                });
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(beginWord, 1);
        queue.offer(node);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (int i = 0; i < currentNode.getWord().length(); i++) {
                StringBuilder sb = new StringBuilder(currentNode.getWord());
                sb.replace(i, i + 1, "*");

                List<String> patternWords = patternMap.get(sb.toString());
                if (patternWords == null || patternWords.isEmpty()) {
                    continue;
                }

                for (String patternWord : patternWords) {
                    if (visited.contains(patternWord)) {
                        continue;
                    }

                    if (patternWord.equals(endWord)) {
                        return currentNode.getLength() + 1;
                    }

                    queue.offer(new Node(patternWord, currentNode.getLength() + 1));
                    visited.add(patternWord);
                }
            }
        }
        return 0;
    }

    private static class Node {
        private String word;
        private int length;

        public Node(String word, int length) {
            this.word = word;
            this.length = length;
        }

        public String getWord() {
            return word;
        }

        public int getLength() {
            return length;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(word, node.word);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(word);
        }
    }

    static void main() {
        _127 l = new _127();
        System.out.println(l.ladderLength("hit", "cog", new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"))));
    }
}
