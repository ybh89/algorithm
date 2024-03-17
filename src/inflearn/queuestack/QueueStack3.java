package inflearn.queuestack;

import java.util.*;

public class QueueStack3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] board = new int[n][n];
        for (int i = 0; i < board.length; i++) {
            String[] line = scanner.nextLine().split(" ");
            board[i] = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        scanner.nextLine();
        int[] moves = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> boardStack = new ArrayList<>();
        boardStack.add(new Stack<>());
        for (int j = 0; j < board.length; j++) {
            Stack<Integer> stack = new Stack<>();
            boardStack.add(stack);
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] == 0) {
                    break;
                }
                stack.push(board[i][j]);
            }
        }

        int count = 0;
        Stack<Integer> resultStack = new Stack<>();

        for (int moveNumber : moves) {
            Stack<Integer> stack = boardStack.get(moveNumber);
            if (stack.isEmpty()) {
                continue;
            }
            Integer pop = stack.pop();

            if (!resultStack.isEmpty()) {
                Integer peek = resultStack.peek();
                if (pop.equals(peek)) {
                    count += 2;
                    resultStack.pop();
                    continue;
                }
            }

            resultStack.push(pop);
        }

        return count;
    }
}
