import java.util.Random;

public class SearchPerformanceComparison {

    // Linear Search (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search (O(log N))
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Generate sorted array of given size
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        arr[0] = rand.nextInt(5); // starting number
        for (int i = 1; i < size; i++) {
            arr[i] = arr[i - 1] + rand.nextInt(5); // ascending
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};

        for (int size : sizes) {
            int[] arr = generateSortedArray(size);
            int target = arr[arr.length - 1]; // target at end (worst-case for linear)

            System.out.println("\nArray Size: " + size);

            // Linear Search
            long startLinear = System.nanoTime();
            int indexLinear = linearSearch(arr, target);
            long endLinear = System.nanoTime();
            System.out.println("Linear Search: Index = " + indexLinear + ", Time = " + (endLinear - startLinear) + " ns");

            // Binary Search
            long startBinary = System.nanoTime();
            int indexBinary = binarySearch(arr, target);
            long endBinary = System.nanoTime();
            System.out.println("Binary Search: Index = " + indexBinary + ", Time = " + (endBinary - startBinary) + " ns");
        }
    }
}
