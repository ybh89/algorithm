package new2025.real.fourtytwodot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        Test2 sol = new Test2();
        System.out.println(Arrays.toString(sol.solution(new String[]{"PIZER 3 20 99", "ASTRA 1 9 55", "YANSEN 10000 22 49"}, new String[]{"susan 50 ASTRA YANSEN PIZER", "kevin 55 ASTRA", "luka 60 PIZER ASTRA", "erica 20 YANSEN PIZER ASTRA", "roy 20 PIZER"})));
    }

    public String[] solution(String[] vac, String[] peo) {
        List<Requester> requesters = new ArrayList<>();

        for (int i = 0; i < peo.length; i++) {
            String[] inputs = peo[i].split(" ");
            String name = inputs[0];
            int age = Integer.parseInt(inputs[1]);
            List<String> vacList = new ArrayList<>();
            for (int j = 2; j < inputs.length; j++) {
                vacList.add(inputs[j]);
            }
            requesters.add(new Requester(i, name, age, vacList));
        }

        List<Requester> sortedRequesters = requesters.stream()
                .sorted((o1, o2) -> {
                    if (o1.getAge() > o2.getAge()) {
                        return -1;
                    }
                    if (o1.getAge() < o2.getAge()) {
                        return 1;
                    }

                    return Integer.compare(o1.getSeq(), o2.getSeq());
                })
                .collect(Collectors.toList());

        Map<String, Vaccine> vaccineMap = new HashMap<>();
        for (String v : vac) {
            String[] inputs = v.split(" ");
            String name = inputs[0];
            int stock = Integer.parseInt(inputs[1]);
            int minAge = Integer.parseInt(inputs[2]);
            int maxAge = Integer.parseInt(inputs[3]);

            Vaccine vaccine = new Vaccine(name, stock, minAge, maxAge);
            vaccineMap.put(name, vaccine);
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for (Requester requester : sortedRequesters) {
            List<String> vacList = requester.getVacList();

            for (String vaccineName : vacList) {
                Vaccine vaccine = vaccineMap.get(vaccineName);
                if (vaccine.isValid(requester.getAge())) {
                    vaccine.useOne();
                    resultMap.compute(vaccineName, (key, value) -> {
                        if (value == null) {
                            List<String> queue = new ArrayList<>();
                            queue.add(requester.getName());
                            return queue;
                        }

                        value.add(requester.getName());
                        return value;
                    });
                    break;
                }
            }
        }

        List<String> result = new ArrayList<>();
        resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(entry.getKey()).append(" ");
                    entry.getValue().stream()
                            .sorted()
                            .forEach(requesterName -> sb.append(requesterName).append(" "));
                    result.add(sb.toString().trim());
                });

        return result.toArray(String[]::new);
    }

    static class Vaccine {
        private String name;
        private int stock;
        private int minAge;
        private int maxAge;

        public Vaccine(String name, int stock, int minAge, int maxAge) {
            this.name = name;
            this.stock = stock;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public void useOne() {
            if (stock > 0) {
                stock--;
            }
        }

        public boolean isValid(int age) {
            return stock > 0 && age >= minAge && age <= maxAge;
        }
    }

    static class Requester {
        private int seq;
        private String name;
        private int age;
        private List<String> vacList;

        public Requester(int seq, String name, int age, List<String> vacList) {
            this.seq = seq;
            this.name = name;
            this.age = age;
            this.vacList = vacList;
        }

        public int getSeq() {
            return seq;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<String> getVacList() {
            return vacList;
        }
    }
}
