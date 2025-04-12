public class FirstAndLastOccurence {

    public static int FindFirst(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int result=-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(arr[mid]==target){
                result=mid;
                high=mid-1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }
    public static int FindLast(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int result=-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(arr[mid]==target){
                result=mid;
                low=mid+1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,5,5,5,6};
        int target=5;
        int First=FindFirst(arr,target);
        int Last=FindLast(arr,target);
        System.out.println("First occurence of the "+target+" is at index: "+First);
        System.out.println("Second occurence of the "+target+" is at index: "+Last);
    }
}
