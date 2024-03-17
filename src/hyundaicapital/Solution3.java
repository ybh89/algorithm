package hyundaicapital;

import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {
    public static Map<Integer, Integer> dataCount = new HashMap<>();
    public static Map<Integer, Integer> diskCount = new HashMap<>();

    public static void main(String[] args) {
        //int[][] records = new int[][]{{1, 1, 5}, {2, 4, 7}, {1, 5, 10}, {3, 1, 10}, {2, 1, 5}, {1, 3, 3}, {3, 2, 8}, {2, 2, 8}, {3, 4, 7}};
        //solution(3, 5, records);

        int[][] records = new int[][]{{1, 2, 7}, {1, 1, 7}, {1, 3, 9}, {2, 1, 3}, {2, 2, 9}, {2, 3, 1}};
        int[][] solution = solution(2, 3, records);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] solution(int n, int m, int[][] records) {
        List<DiskData> diskDataList = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            int[] record = records[i];
            diskDataList.add(new DiskData(i + 1, record[0], record[1], record[2]));
            dataCount.put(record[1], dataCount.getOrDefault(record[1], 0) + 1);
            diskCount.put(record[0], diskCount.getOrDefault(record[0], 0) + 1);
        }

        List<DiskData> result = new ArrayList<>();
        while (true) {
            List<DiskData> collect = diskDataList.stream()
                    .filter(diskData -> dataCount.get(diskData.getData()) > 1)
                    .sorted()
                    .collect(Collectors.toList());

            if (collect.isEmpty()) {
                break;
            }
            DiskData diskData = collect.get(0);
            result.add(diskData);
            dataCount.computeIfPresent(diskData.data, (key, value) -> {
                value--;
                return value;
            });
            diskCount.computeIfPresent(diskData.disk, (key, value) -> {
                value--;
                return value;
            });
            diskDataList.remove(diskData);
        }

        int[][] arrayResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arrayResult[i][0] = result.get(i).disk;
            arrayResult[i][1] = result.get(i).data;
        }

        return arrayResult;
    }

    static class DiskData implements Comparable<DiskData> {
        int saveSeq;
        int disk;
        int data;
        int latestSelectDay;

        public DiskData(int saveSeq, int disk, int data, int latestSelectDay) {
            this.saveSeq = saveSeq;
            this.disk = disk;
            this.data = data;
            this.latestSelectDay = latestSelectDay;
        }

        public int getSaveSeq() {
            return saveSeq;
        }

        public int getDisk() {
            return disk;
        }

        public int getData() {
            return data;
        }

        public int getLatestSelectDay() {
            return latestSelectDay;
        }

        @Override
        public int compareTo(DiskData other) {
            if (this.latestSelectDay == other.latestSelectDay) {
                if (Objects.equals(diskCount.get(other.disk), diskCount.get(this.disk))) {
                    return this.saveSeq - other.saveSeq;
                }

                return diskCount.get(other.disk) - diskCount.get(this.disk);
            }

            return other.latestSelectDay - this.latestSelectDay;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DiskData diskData = (DiskData) o;
            return getSaveSeq() == diskData.getSaveSeq();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getSaveSeq());
        }
    }
}
