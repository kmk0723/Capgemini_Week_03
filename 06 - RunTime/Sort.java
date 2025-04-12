import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void MergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            MergeSort(arr,left,mid);
            MergeSort(arr,mid+1,right);

            Merge(arr,left,mid,right);

        }
    }

    public static void Merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] L=new int[n1];
        int[] R=new int[n2];

        for(int i=0;i<n1;i++){
            L[i]=arr[left+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=arr[mid+1+i];
        }

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k++]=L[i++];
            }else{
                arr[k++]=R[j++];
            }
        }

        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=R[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int[] generateRandomArray(int size){
        Random  rand=new Random();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=rand.nextInt(size*10);
        }
        return arr;
    }

    public static void main(String[] args) {
        int size=10000;
        int[] arr=generateRandomArray(size);
        int[] bubbleArr = Arrays.copyOf(arr, arr.length);
        int[] mergeArr = Arrays.copyOf(arr, arr.length);
        int[] quickArr = Arrays.copyOf(arr, arr.length);

        long start=System.nanoTime();
        BubbleSort(bubbleArr);
        long end=System.nanoTime();
        System.out.println("Bubble sort time: "+(end-start)/1000000.0+"ms");

        start=System.nanoTime();
        MergeSort(mergeArr,0,arr.length-1);
        end=System.nanoTime();
        System.out.println("Merge sort time: "+(end-start)/1000000.0+"ms");

        start = System.nanoTime();
        quickSort(quickArr, 0, arr.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");
    }

}



