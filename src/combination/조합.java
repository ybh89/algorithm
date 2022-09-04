package combination;

public class 조합 {
    static boolean [] visited = new boolean[3];
    static int [] arr = {1,2,3};

    public static void main(String[] args) {
        for (int i = 1; i <= arr.length; i++) {
            backtracking(i, 0);
        }
    }

    /**
     *
     * @param selectNumber - 몇 개 뽑는지.. arr 중에 몇 개 뽑을 건지
     * @param start - 어디서 시작할 것인지.. 중복되지 않게 다음 요소를 선택하기 위해 +1 해준다.
     */
    static void backtracking(int selectNumber, int start) {
        if(selectNumber == 0) {
            print(arr, visited);
            return;
        }

        for(int i = start; i < arr.length; i++) {
            visited[i] = true;
            backtracking(selectNumber - 1, i + 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
