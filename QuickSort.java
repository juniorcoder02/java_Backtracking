public class QuickSort {

    // Method to print the elements of the array
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Loop through the array
            System.out.print(arr[i] + " "); // Print each element with a space
        }
        System.out.println(); // Move to the next line after printing
    }

    // Recursive method to perform QuickSort
    public static void quickSort(int[] arr, int si, int ei) {
        // Base case: If start index >= end index, the array is already sorted or empty
        if (si >= ei) {
            return;
        }

        // Partition the array and get the pivot index
        int pIdx = partition(arr, si, ei);

        // Recursively sort the left part of the array
        quickSort(arr, si, pIdx - 1);

        // Recursively sort the right part of the array
        quickSort(arr, pIdx + 1, ei);
    }

    // Method to partition the array and place the pivot in its correct position
    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei]; // Choose the last element as the pivot
        int i = si - 1; // Pointer for the smaller-than-pivot region

        // Traverse the array and rearrange elements
        for (int j = si; j < ei; j++) { // Iterate from start to just before the pivot
            if (arr[j] <= pivot) { // If the current element is less than or equal to the pivot
                i++; // Expand the smaller-than-pivot region
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot in its correct position
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[ei] = temp;

        // Return the index of the pivot
        return i;
    }

    public static void main(String[] args) {
        // Input array to be sorted
        int[] arr = { 6, 3, 9, 8, 2, 5 };

        // Perform quick sort on the array
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        printArr(arr);
    }
}
