//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Call the mergeSort function and return the count of inversions.
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Merge sort function that counts inversions.
    static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            // Find the mid-point.
            int mid = left + (right - left) / 2;

            // Count inversions in the left half.
            count += mergeSort(arr, left, mid);
            // Count inversions in the right half.
            count += mergeSort(arr, mid + 1, right);
            // Count split inversions and merge the sorted halves.
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    // Function to merge two halves and count split inversions.
    static int mergeAndCount(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays.
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays.
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Merge the arrays and count inversions.
        int i = 0, j = 0, k = left, inversions = 0;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // All elements remaining in leftArr are greater than rightArr[j].
                inversions += (n1 - i);
            }
        }

        // Copy remaining elements of leftArr, if any.
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr, if any.
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }

        return inversions;
    }
}