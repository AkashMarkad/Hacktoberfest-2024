public class MergeSort {

    // Main function that sorts the array using Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point of the array
            int mid = (left + right) / 2;

            // Sort the first half
            mergeSort(arr, left, mid);

            // Sort the second half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Helper function to merge two halves
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays to hold data
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into the temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Initial indexes for left, right, and merged arrays
        int i = 0, j = 0;
        int k = left;

        // Merge the arrays back into the original array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from L[] (left array)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements from R[] (right array)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Display the original array
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Call mergeSort to sort the array
        mergeSort(arr, 0, arr.length - 1);

        // Display the sorted array
        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
