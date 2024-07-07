class Tester {

    public static int findMaxSum(int arr[], int low, int high) {
        // Base case: only one element
        if (low == high) {
            return arr[low];
        }

        // Find the middle point
        int mid = (low + high) / 2;

        // Return maximum of following three possible cases
        // a) Maximum subarray sum in left half
        // b) Maximum subarray sum in right half
        // c) Maximum subarray sum such that the subarray crosses the midpoint
        return Math.max(Math.max(findMaxSum(arr, low, mid),
                                 findMaxSum(arr, mid + 1, high)),
                        findMaxCrossingSubarraySum(arr, low, mid, high));
    }

    public static int findMaxCrossingSubarraySum(int arr[], int low, int mid, int high) {
        // Include elements on the left of mid
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // Include elements on the right of mid
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // Return sum of elements on left and right of mid
        // which includes the middle element
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int arr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
        System.out.println("Maximum sum: " + findMaxSum(arr, 0, arr.length - 1));
    }
}