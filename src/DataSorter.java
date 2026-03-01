import java.util.Arrays;
import java.util.Scanner;

public class DataSorter {

    // 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 2. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 3. Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { arr[k] = L[i]; i++; }
            else { arr[k] = R[j]; j++; }
            k++;
        }
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces:");
        String input = scanner.nextLine();
        String[] items = input.split(" ");
        int[] original = new int[items.length];
        for (int i = 0; i < items.length; i++) original[i] = Integer.parseInt(items[i]);

        // Timing Bubble Sort
        int[] bData = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        bubbleSort(bData);
        long bTime = System.nanoTime() - start;

        // Timing Quick Sort
        int[] qData = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        quickSort(qData, 0, qData.length - 1);
        long qTime = System.nanoTime() - start;

        // Timing Merge Sort
        int[] mData = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        mergeSort(mData, 0, mData.length - 1);
        long mTime = System.nanoTime() - start;

        // Requirement: Display Comparison Table
        System.out.println("\nAlgorithm\tTime (ns)");
        System.out.println("Bubble Sort\t" + bTime);
        System.out.println("Quick Sort\t" + qTime);
        System.out.println("Merge Sort\t" + mTime);
        System.out.println("\nSorted Result: " + Arrays.toString(qData));
        scanner.close();
    }
}
