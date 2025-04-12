import java.util.HashSet;
public class PairWithGivenSum {

    public static boolean hasPairwithSum(int[] arr, int target){
        HashSet<Integer> seen=new HashSet<>();

        for(int num:arr){
            int complement=target-num;
            if(seen.contains(complement)){
                System.out.println("pair found: ("+num+" , "+complement+" )");
                return true;
            }
            seen.add(num);
        }
        System.out.println("No pair with given sum found");
        return false;
    }

    public static void main(String[] args){
        int[] arr={10,3,4,7};
        int target=17;
        hasPairwithSum(arr,target);
    }

}
