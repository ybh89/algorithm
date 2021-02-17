package sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] numbers = new int[]{7,4,5,1,2,0,9,3,8,6};
        System.out.println("선택 정렬: " + Arrays.toString(selectSort(numbers)));
        System.out.println("삽입 정렬: " + Arrays.toString(insertSort(numbers)));
        System.out.println("버블 정렬: " + Arrays.toString(bubbleSort(numbers)));
    }

    /**
     * 선택 정렬
     * 최소값을 찾아 현재 위치와 바꾼다.(오름차순)
     * 최대값을 찾아 현재 위치와 바꾸면 내림차순.
     * 시간 복잡도: O(n²)
     * 공간 복잡도: O(1)
     */
    public static int[] selectSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minNum = numbers[i];
            int minIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if(numbers[j] < minNum) {
                    minNum = numbers[j];
                    minIndex = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = minNum;
            numbers[minIndex] = temp;
        }

        return numbers;
    }

    /**
     * 삽입 정렬
     * 현재 값을 현재값 앞에 있는 정렬된 배열중 적절한 위치로 변경한다.
     * 시간 복잡도: O(n²)
     * 공간 복잡도: O(1)
     */
    public static int[] insertSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int curNum = numbers[i];
            for (int j = i-1; j >= 0; j--) {
                if(curNum > numbers[j]) {
                    numbers[j+1] = curNum;
                    break;
                }

                numbers[j+1] = numbers[j];
            }
        }

        return numbers;
    }

    /**
     * 버블 정렬
     * 시간 복잡도: O(n²)
     * 공간 복잡도: O(1)
     */
    public static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if(numbers[j] < numbers[j-1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }
            }
        }

        return numbers;
    }
}
