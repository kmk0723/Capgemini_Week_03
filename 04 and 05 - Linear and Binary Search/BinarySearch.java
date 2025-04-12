public class BinarySearch {

    public static int findMinIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 9, 15, 19, 2, 3};
        int minIndex = findMinIndex(arr);
        System.out.println("Index of the smallest element is: " + minIndex);
        System.out.println("Smallest element is: " + arr[minIndex]);
    }
}
