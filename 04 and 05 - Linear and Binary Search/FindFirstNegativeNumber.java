public class FindFirstNegativeNumber {

    public static int findNegative(int[] arr){

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                System.out.println("Index of First Negative Element is: "+i);
                break;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={3,4,-4,2,0,-3};
        findNegative(arr);

    }
}
