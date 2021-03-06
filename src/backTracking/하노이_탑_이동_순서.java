package backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 11729
 * 문제
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 *
 * 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 *
 * 아래 그림은 원판이 5개인 경우의 예시이다.
 *
 *
 *
 * 입력
 * 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
 *
 *
 *
 * 출력
 * 첫째 줄에 옮긴 횟수 K를 출력한다.
 *
 * 두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 *
 * 예제 입력 1
 * 3
 * 예제 출력 1
 * 7
 * 1 3
 * 1 2
 * 3 2
 * 1 3
 * 2 1
 * 2 3
 * 1 3
 */
public class 하노이_탑_이동_순서 {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        findShortestPath(N);
    }

    public static List findShortestPath(int N) {
        //초기 세팅
        List<Stack<Integer>> stackList = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        for(int i=N; i>0; i--) {
            stack1.push(i);
        }

        stackList.add(0,null);
        stackList.add(1,stack1);
        stackList.add(2,stack2);
        stackList.add(3,stack3);

        backTracking(stackList, new ArrayList<Integer>(), 1, -1);

        return null;
    }

    public static void backTracking(List<Stack<Integer>> stackList, List<Integer> path, int stackNum, int preStackNum) {
        // 종료 조건: 목표 스택3에 모든 요소가 있으면 종료
        if(stackList.get(3).size() == N) {
            System.out.println(path);
            return;
        }

        Stack<Integer> curStack = stackList.get(stackNum);

        if(curStack.isEmpty()) {
            return;
        }

        path.add(stackNum);

        Stack<Integer> otherStack1 = null;
        Stack<Integer> otherStack2 = null;
        if(stackNum == 1) {
            if(preStackNum != 2) {
                otherStack1 = stackList.get(2);
            }
            if(preStackNum != 3) {
                otherStack2 = stackList.get(3);
            }
        } else if(stackNum == 2) {
            if(preStackNum != 1) {
                otherStack1 = stackList.get(1);
            }
            if(preStackNum != 3) {
                otherStack2 = stackList.get(3);
            }
        } else {
            if(preStackNum != 1) {
                otherStack1 = stackList.get(1);
            }
            if(preStackNum != 2) {
                otherStack2 = stackList.get(2);
            }
        }

        if(isPushable(curStack, otherStack1)) {
            otherStack1.push(curStack.pop());
            backTracking(stackList, path, otherStack1 == stackList.get(1) ? 1 : 2, stackNum);
            curStack.push(otherStack1.pop());
        }
        if(isPushable(curStack, otherStack2)) {
            otherStack2.push(curStack.pop());
            backTracking(stackList, path, otherStack2 == stackList.get(3) ? 3 : 2, stackNum);
            curStack.push(otherStack1.pop());
        }


    }

    private static boolean isPushable(Stack<Integer> curStack, Stack<Integer> targetStack) {
        if(targetStack == null) {
            return false;
        }
        if(targetStack.isEmpty()) {
            return true;
        }

        return curStack.peek() < targetStack.peek();
    }
}
