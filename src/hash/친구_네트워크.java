package hash;

import java.util.*;

/**
 * 백준 - 4195
 */
public class 친구_네트워크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = Integer.parseInt(sc.nextLine());

        for(int t=0; t<TC; t++) {
            int relationNum = Integer.parseInt(sc.nextLine());
            List<Set<String>> setList = new LinkedList<>();

            for(int r=0; r<relationNum; r++) {
                String[] relation = sc.nextLine().split(" ");
                String friend1 = relation[0];
                String friend2 = relation[1];
                int includeIndex1 = -1;
                int includeIndex2 = -1;
                for(int i=0; i<setList.size(); i++) {
                    if(includeIndex1 != -1 && includeIndex2 != -1) {
                        break;
                    }

                    Set<String> curSet = setList.get(i);
                    if(curSet.contains(friend1)) {
                        includeIndex1 = i;
                    }
                    if(curSet.contains(friend2)) {
                        includeIndex2 = i;
                    }
                }

                if(includeIndex1 == -1 && includeIndex2 == -1) {
                    setList.add(new HashSet<>(Arrays.asList(friend1, friend2)));
                    System.out.println(2);
                } else if(includeIndex1 != -1 && includeIndex2 != -1){
                    setList.get(includeIndex1).addAll(setList.get(includeIndex2));
                    setList.remove(includeIndex2);
                    System.out.println(setList.get(includeIndex1).size());
                } else if(includeIndex1 != -1) {
                    setList.get(includeIndex1).add(friend1);
                    setList.get(includeIndex1).add(friend2);
                    System.out.println(setList.get(includeIndex1).size());
                } else if(includeIndex2 != -1) {
                    setList.get(includeIndex2).add(friend1);
                    setList.get(includeIndex2).add(friend2);
                    System.out.println(setList.get(includeIndex2).size());
                }
            }
        }
    }
}
