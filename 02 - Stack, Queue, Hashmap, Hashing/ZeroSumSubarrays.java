import java.util.*;

public class ZeroSumSubarrays {


    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (Integer start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);
        System.out.println("Subarrays with zero sum:");
        for (int[] range : subarrays) {
            System.out.println("From index " + range[0] + " to " + range[1]);
        }
    }
}
