import java.util.HashSet;
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums){

        if(nums.length==0){
            return 0;
        }

        HashSet<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }

        int longestStreak=0;

        for(int num: numSet){
            if(!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;


                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }

        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(arr);
        System.out.println("Longest consecutive sequence length: " + result);
    }

}
