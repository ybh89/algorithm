package new2025.programers;

public class 최소직사각형86491 {
    public static void main(String[] args) {

    }

    public int solution(int[][] sizes) {
        int height = Integer.MIN_VALUE;
        int width = Integer.MIN_VALUE;

        for (int[] size : sizes) {
            height = Math.max(height, Math.max(size[0], size[1]));
            width = Math.max(width, Math.min(size[0], size[1]));
        }

        return height * width;
    }
}
