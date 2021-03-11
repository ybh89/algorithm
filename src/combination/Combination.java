package combination;

/**
 * 기본
 */
public class Combination {
    private static int n = 4;
    private static int[] arr = new int[]{1, 2, 3, 4};
    private static boolean[] visited = new boolean[n];

    public static void main(String[] args) {
        /*for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(i,0);
        }*/
        combination(2, 0);
    }

    private static void combination(int depth, int start) {
        if(depth == 0) {
            print(visited);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(depth - 1,i + 1);
            visited[i] = false;
        }
    }

    static void print(boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
