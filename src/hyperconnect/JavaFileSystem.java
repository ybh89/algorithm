package hyperconnect;

import java.util.*;

public class JavaFileSystem {
    public static final String PATH_SEPARATOR = "/";
    public static final int MINIMUM_SPLIT_LENGTH = 2;

    private Map<String, Integer> store = new HashMap<>();

    public JavaFileSystem() {
    }

    public boolean createPath(String path, int value) {
        if (path.isBlank() || path.equals(PATH_SEPARATOR)) {
            return false;
        }

        if (store.containsKey(path)) {
            return false;
        }

        String[] split = path.split(PATH_SEPARATOR);
        if (split.length == MINIMUM_SPLIT_LENGTH) {
            return save(path, value);
        }

        int lastPathSeparatorIndex = path.lastIndexOf(PATH_SEPARATOR);
        String parentPath = path.substring(0, lastPathSeparatorIndex);

        if (store.containsKey(parentPath)) {
            return save(path, value);
        }

        return false;
    }

    private boolean save(String path, int value) {
        store.put(path, value);
        return true;
    }

    public int get(String path) {
        return store.getOrDefault(path, -1);
    }

    public static void main(String[] args) {
        JavaFileSystem javaFileSystem = new JavaFileSystem();
        javaFileSystem.createPath("/a", 0);
        javaFileSystem.createPath("/a/b", 1);
        javaFileSystem.createPath("/a/b/c/d", 2);

        System.out.println(javaFileSystem.get("/a"));
        System.out.println(javaFileSystem.get("/a/b"));
        System.out.println(javaFileSystem.get("/a/b/c/d"));
        System.out.println(javaFileSystem.get("/b"));
    }
}
