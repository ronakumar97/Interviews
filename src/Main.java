import java.util.*;

public class Main {

    public static boolean solution(String[] systemNames, int[] stepNumbers) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < systemNames.length; i++) {
            if (map.containsKey(systemNames[i])) {
                List<Integer> stepNo = map.get(systemNames[i]);
                stepNo.add(stepNumbers[i]);
                map.put(systemNames[i], stepNo);
            } else {
                map.put(systemNames[i], new ArrayList<Integer>(Arrays.asList(stepNumbers[i])));
            }
        }
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> values = entry.getValue();
            Set<Integer> set = new HashSet<>(values);
            if(set.size() != values.size()) {
                return false;
            }
            if(checkSorted(values) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSorted(List<Integer> list) {
        return list.stream().sorted().toList().equals(list);
    }

    public static void main(String[] args) {
        String[] systemNames = new String[]{"Falcon 9",
        "Falcon 9",
        "Falcon 9",
        "Falcon 9",
        "Falcon 9",
        "Falcon 9"};

        int[] stepNumbers = new int[]{1, 3, 5, 7, 7, 9};
        System.out.println(solution(systemNames, stepNumbers));

    }
}
