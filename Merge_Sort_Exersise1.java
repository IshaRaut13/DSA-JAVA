class Tester {

    public static void mergeSort(int[] elements, int size) {
        if (size < 2) {
            return; // Base case: if the array has 0 or 1 element, it's already sorted
        }

        // Find the middle index of the array
        int mid = size / 2;

        // Create left and right subarrays
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        // Populate left and right subarrays
        System.arraycopy(elements, 0, left, 0, mid);
        System.arraycopy(elements, mid, right, 0, size - mid);

        // Recursively sort left and right subarrays
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        // Merge the sorted left and right subarrays
        merge(elements, left, right, mid, size - mid);
    }

    public static void merge(int[] elements, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Merge left and right arrays into elements[]
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[], if any
        while (i < leftSize) {
            elements[k++] = left[i++];
        }

        // Copy remaining elements of right[], if any
        while (j < rightSize) {
            elements[k++] = right[j++];
        }
    }

    public static void displayArray(int[] elements) {
        for (int element : elements)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] elements = { 95, 56, 20, 98, 34, 77, 80 };

        System.out.println("Given Array:");
        displayArray(elements);

        mergeSort(elements, elements.length);

        System.out.println("Sorted Array:");
        displayArray(elements);
    }

}