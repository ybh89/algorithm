package permutation;

import java.util.*;

/**
 * 백준 14888
 */
public class 연산자_끼워넣기 {
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int[] countOperators;
    private static int[] numbers;
    private static int[] operators;
    private static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        countOperators = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        makeOperators();
        isUsed = new boolean[operators.length];

        findMaxAndMin(N-1, new ArrayList<>());
        System.out.println(max);
        System.out.println(min);
    }

    private static void findMaxAndMin(int depth, List<Integer> result) {
        //종료
        if(depth == 0) {
            int calRes = numbers[0];
            for(int i=1; i<numbers.length; i++) {
                calRes = operate(calRes, numbers[i], result.get(i-1));

            }
            max = Math.max(max, calRes);
            min = Math.min(min, calRes);
            return;
        }

        //프로세스
        for(int i=0; i<countOperators.length; i++) {
            for(int j=0; j<countOperators[i]; j++) {
                if(!isUsed[i]) {
                    isUsed[i] = true;
                    result.add(operators[i]);
                    findMaxAndMin(depth-1, result);
                    result.remove(result.size()-1);
                    isUsed[i] = false;
                }
            }
        }
        for(int i=0; i<operators.length; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                result.add(operators[i]);
                findMaxAndMin(depth-1, result);
                result.remove(result.size()-1);
                isUsed[i] = false;
            }
        }
    }

    /**
     * 연산자 갯수만큼 연산자를 만들어줌
     * + -> 0, - -> 1, * -> 2, / -> 3
     * 시간 복잡도: O(N)
     */
    private static void makeOperators() {
        operators = new int[countOperators[0]+countOperators[1]+countOperators[2]+countOperators[3]];
        int operatorIndex = 0;
        for(int i=0; i<countOperators.length; i++) {
            for(int j=0; j<countOperators[i]; j++) {
                operators[operatorIndex++] = i;
            }
        }
    }

    private static int operate(int num1, int num2, int operator) {
        switch (operator) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            default: return num1 / num2;
        }
    }
}
