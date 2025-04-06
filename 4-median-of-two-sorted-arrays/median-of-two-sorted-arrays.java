import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Get the sizes of both input arrays.
        int n = nums1.length;
        int m = nums2.length;

        // Merge the arrays into a single sorted array.
        int[] mergedarr = new int[n + m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            mergedarr[k++] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            mergedarr[k++] = nums2[i];
        }

        // Sort the merged array.
        Arrays.sort(mergedarr);

        // Calculate the total number of elements in the merged array.
        int total = mergedarr.length;

        if (total % 2 == 1) {
            // If the total number of elements is odd, return the middle element as the median.
            return (double) mergedarr[total / 2];
        } else {
            // If the total number of elements is even, calculate the average of the two middle elements as the median.
            int middle1 = mergedarr[total / 2 - 1];
            int middle2 = mergedarr[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }
    }
}