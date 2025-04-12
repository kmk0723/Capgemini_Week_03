public class SearchIn2D {

    public static boolean Search(int[][] arr,int target){
        int rows=arr.length;
        int cols=arr[0].length;
        int left=0;
        int right=rows*cols-1;
        while(left<=right){
            int mid=(left+right)/2;
            int row=mid/cols;
            int col=mid%cols;
            int midVal=arr[row][col];
            if(midVal==target){
                return true;
            }else if(midVal<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] arr={{1,3,7,9,11},{12,13,17,23,24},{25,80,96,97,98}};

        int target=99;
        boolean result= Search(arr,target);
        if(result){
            System.out.println("Number found");
        }else{
            System.out.println("Number not found");
        }
    }
}
