class Tester {

    public static void sortArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int findMaxSum(int arr[], int m) {
        int n = arr.length;
        if (m > n) {
            return 0; // If m is greater than array size, return 0
        }

        int maxSum = 0;
        for (int i = n - 1; i >= n - m; i--) {
            maxSum += arr[i];
        }
        return maxSum;
    }

    public static int findMinSum(int arr[], int m) {
        int n = arr.length;
        if (m > n) {
            return 0; // If m is greater than array size, return 0
        }

        int minSum = 0;
        for (int i = 0; i < m; i++) {
            minSum += arr[i];
        }
        return minSum;
    }

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };

        // Sort the array using Bubble Sort
        sortArray(arr);

        // Find and print the maximum sum for m = 4
        int m1 = 4;
        int maxSum = findMaxSum(arr, m1);
        System.out.println("Maximum Sum for m=" + m1 + ": " + maxSum);

        // Find and print the minimum sum for m = 3
        int m2 = 3;
        int minSum = findMinSum(arr, m2);
        System.out.println("Minimum Sum for m=" + m2 + ": " + minSum);
    }
}