class Tester {

    public static int[] getMaxMin(int arr[], int low, int high) {
        int[] result = new int[2]; // result[0] will be max, result[1] will be min

        // If there is only one element
        if (low == high) {
            result[0] = arr[low];
            result[1] = arr[low];
            return result;
        }

        // If there are two elements
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result[0] = arr[low];
                result[1] = arr[high];
            } else {
                result[0] = arr[high];
                result[1] = arr[low];
            }
            return result;
        }

        // If there are more than two elements
        int mid = (low + high) / 2;
        int[] leftResult = getMaxMin(arr, low, mid);
        int[] rightResult = getMaxMin(arr, mid + 1, high);

        // Combine results
        result[0] = Math.max(leftResult[0], rightResult[0]);
        result[1] = Math.min(leftResult[1], rightResult[1]);

        return result;
    }

    public static void main(String args[]) {
        int arr[] = {1000, 10, 5, 1, 2000};

        int[] maxMin = getMaxMin(arr, 0, arr.length - 1);

        System.out.println("Minimum value is " + maxMin[1]);
        System.out.println("Maximum value is " + maxMin[0]);
    }
}