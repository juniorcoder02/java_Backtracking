public class RotatedSortedArray {
    /**
     * Recursive binary search in a rotated sorted array.
     *
     * @param arr    The rotated sorted array.
     * @param target The element to search for.
     * @param start  The starting index of the current search range.
     * @param end    The ending index of the current search range.
     * @return The index of the target element if found, otherwise -1.
     */
    public static int binSearch(int[] arr, int target, int start, int end) {
        // Base case: If the search range is invalid, the target is not found
        if (start > end) {
            return -1;
        }

        // Calculate the middle index to divide the search range
        int mid = start + (end - start) / 2;

        // If the middle element is the target, return its index
        if (arr[mid] == target) {
            return mid;
        }

        // Determine which half of the array is sorted
        if (arr[start] <= arr[mid]) { // Left half is sorted
            // Check if the target lies in the sorted left half
            if (target >= arr[start] && target < arr[mid]) {
                return binSearch(arr, target, start, mid - 1); // Search left half
            } else {
                return binSearch(arr, target, mid + 1, end); // Search right half
            }
        } else { // Right half is sorted
            // Check if the target lies in the sorted right half
            if (target > arr[mid] && target <= arr[end]) {
                return binSearch(arr, target, mid + 1, end); // Search right half
            } else {
                return binSearch(arr, target, start, mid - 1); // Search left half
            }
        }
    }

    public static void main(String[] args) {
        // Example array (rotated sorted array)
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        
        // Target element to search for
        int target = 0;

        // Perform the binary search and print the result
        int result = binSearch(arr, target, 0, arr.length - 1);
        System.out.println("Target index: " + result); // Output the index of the target
    }
}
