public class MergeSort {

    // Method to print the elements of the array
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Loop through the array
            System.out.print(arr[i] + " "); // Print each element separated by a space
        }
        System.out.println(""); // Move to the next line after printing the array
    }

    // Recursive method to perform Merge Sort
    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) { // Base case: If the start index >= end index, array is already sorted (single element)
            return;
        }

        // Calculate the middle index to divide the array into two halves
        int mid = si + (ei - si) / 2;

        // Recursively sort the left half of the array
        mergeSort(arr, si, mid);

        // Recursively sort the right half of the array
        mergeSort(arr, mid + 1, ei);

        // Merge the two sorted halves
        merge(arr, si, mid, ei);
    }

    // Method to merge two sorted subarrays
    public static void merge(int[] arr, int si, int mid, int ei) {
        // Temporary array to store merged elements
        int[] temp = new int[ei - si + 1];
        int i = si; // Pointer for the left subarray
        int j = mid + 1; // Pointer for the right subarray
        int k = 0; // Pointer for the temporary array

        // Merge elements in sorted order
        while (i <= mid && j <= ei) { // Compare elements from both halves
            if (arr[i] < arr[j]) { // If left element is smaller
                temp[k] = arr[i]; // Add it to the temp array
                i++; // Move the left pointer
            } else { // If right element is smaller
                temp[k] = arr[j]; // Add it to the temp array
                j++; // Move the right pointer
            }
            k++; // Move the temp array pointer
        }

        // Add remaining elements from the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Add remaining elements from the right subarray, if any
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted elements from temp back to the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        // Input array to be sorted
        int[] arr = { 6, 3, 9, 5, 2, 8, -2 };

        // Perform merge sort on the array
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        printArr(arr);

        // Time complexity = O(nlogn)
        // Explanation: Each level of recursion splits the array (O(logn)), and merging takes O(n) per level.

        // Space complexity = O(n)
        // Explanation: Temporary array `temp` of size n is used during the merge process.
    }
}
