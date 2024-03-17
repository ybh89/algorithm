package ainjob;

public class Solution4 {
    private int result = 0;
    private String addString;

    public int solution(String S1, String S2) {
        addS1S2(S1, S2, 0, 0, new StringBuilder());
        calculate(0, 1024, addString, 1);

        return result;
    }

    public void calculate(int index, int pixel, String s1s2, int len) {
        if (index > s1s2.length() - 1) {
            return;
        }

        if (s1s2.charAt(index) == 'p') {
            calculate(index + 1, pixel / 4, s1s2, 1);
        }

        if (s1s2.charAt(index) == 'w') {
            if (len == 4) {
                calculate(index + 1, pixel * 4, s1s2, 1);
            } else {
                calculate(index + 1, pixel, s1s2, len + 1);
            }
        }

        if (s1s2.charAt(index) == 'b') {
            result += pixel;
            if (len == 4) {
                calculate(index + 1, pixel * 4, s1s2, 1);
            } else {
                calculate(index + 1, pixel, s1s2, len + 1);
            }
        }
    }

    public void addS1S2(String S1, String S2, int s1Index, int s2Index, StringBuilder s1s2) {
        if (s1Index > S1.length() - 1 && s2Index > S2.length() - 1) {
            addString = s1s2.toString();
            return;
        }

        char s1Char = S1.charAt(s1Index);
        char s2Char = S2.charAt(s2Index);

        if (s1Char == 'w' && s2Char == 'w') {
            s1s2.append('w');
            addS1S2(S1, S2, s1Index + 1, s2Index + 1, s1s2);
        }

        if ((s1Char == 'w' && s2Char == 'b') || (s1Char == 'b' && s2Char == 'w')) {
            s1s2.append('b');
            addS1S2(S1, S2, s1Index + 1, s2Index + 1, s1s2);
        }

        if (s1Char == 'w' && s2Char == 'p') {
            s1s2.append('p');
            addS1S2(S1, S2, s1Index, s2Index + 1, s1s2);
        }

        if (s1Char == 'p' && s2Char == 'w') {
            s1s2.append('p');
            addS1S2(S1, S2, s1Index + 1, s2Index, s1s2);
        }

        if (s1Char == 'p' && s2Char == 'p') {
            s1s2.append('p');
            addS1S2(S1, S2, s1Index + 1, s2Index + 1, s1s2);
        }

        if (s1Char == 'b' && s2Char == 'p') {
            s1s2.append('b');
            addS1S2(S1, S2, s1Index + 1, s2Index + 5, s1s2);
        }

        if (s1Char == 'p' && s2Char == 'b') {
            s1s2.append('b');
            addS1S2(S1, S2, s1Index + 5, s2Index + 1, s1s2);
        }

        if (s1Char == 'b' && s2Char == 'b') {
            s1s2.append('b');
            addS1S2(S1, S2, s1Index + 1, s2Index + 1, s1s2);
        }
    }

    private String addS1S2(String S1, String S2) {
        int s1Index = 0;
        int s2Index = 0;
        StringBuilder s1s2 = new StringBuilder();

        while (s1Index < S1.length() && s2Index < S2.length()) {
            char s1Char = S1.charAt(s1Index);
            char s2Char = S2.charAt(s2Index);

            if (s1Char == 'w' && s2Char == 'w') {
                s1s2.append('w');
                s1Index++;
                s2Index++;
                continue;
            }

            if ((s1Char == 'w' && s2Char == 'b') || (s1Char == 'b' && s2Char == 'w')) {
                s1s2.append('b');
                s1Index++;
                s2Index++;
                continue;
            }

            if (s1Char == 'w' && s2Char == 'p') {
                String substring = S2.substring(s2Index, s2Index + 5);
                s1s2.append(substring);
                s1Index++;
                s2Index += 5;
                continue;
            }

            if (s1Char == 'p' && s2Char == 'w') {
                String substring = S1.substring(s1Index, s1Index + 5);
                s1s2.append(substring);
                s2Index++;
                s1Index += 5;
                continue;
            }

            if (s1Char == 'p' && s2Char == 'p') {
                s1s2.append('p');
                s1Index++;
                s2Index++;
                continue;
            }

            if (s1Char == 'b' && s2Char == 'p') {
                s1s2.append('b');
                s1Index++;
                s2Index += 5;
                continue;
            }

            if (s1Char == 'p' && s2Char == 'b') {
                s1s2.append('b');
                s2Index++;
                s1Index += 5;
                continue;
            }

            if (s1Char == 'b' && s2Char == 'b') {
                s1s2.append('b');
                s1Index++;
                s2Index++;
                continue;
            }
        }

        System.out.println(s1s2);

        return s1s2.toString();
    }


    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        //System.out.println(solution4.solution("ppwwwbpbbwwbw", "pwbwpwwbw"));
        //System.out.println(solution4.solution("b", "w"));
        //System.out.println(solution4.solution("b", "b"));
        System.out.println(solution4.solution("w", "ppwwwbwww"));
    }
}
