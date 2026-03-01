import java.util.Random;
import java.util.Arrays;

/**
 * Module 3: Algorithm Performance Analyzer
 * Responsibilities: Searching algorithms, Sorting algorithms, and Performance measurement.
 */
public class AlgorithmAnalyzer {

    // 1. Implementation of Binary Search Algorithm 
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid; 
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1; 
    }

    // 2. Implementation of Bubble Sort Algorithm 
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 3. Method to analyze performance and display in tabular format [cite: 41, 46]
    public static void runPerformanceTest(int size) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(10000); // Generate random dataset [cite: 29]
        }

        // --- Measuring Sorting Performance ---
        int[] sortData = data.clone(); // Use a clone to keep original data intact
        long startSort = System.nanoTime(); // Measuring time using nanoTime 
        bubbleSort(sortData);
        long endSort = System.nanoTime();
        long sortDuration = endSort - startSort;

        // --- Measuring Searching Performance ---
        // Binary search requires a sorted array
        Arrays.sort(data); 
        int target = -1; // Use a value not in array for worst-case analysis
        long startSearch = System.nanoTime();
        binarySearch(data, target);
        long endSearch = System.nanoTime();
        long searchDuration = endSearch - startSearch;

        // Displaying results in a table [cite: 46]
        System.out.printf("%-15d | %-20s | %-15d ns%n", size, "Bubble Sort", sortDuration);
        System.out.printf("%-15d | %-20s | %-15d ns%n", size, "Binary Search", searchDuration);
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Algorithm Performance Analysis ---");
        System.out.printf("%-15s | %-20s | %-15s%n", "Input Size", "Algorithm", "Execution Time");
        System.out.println("------------------------------------------------------------");

        // Testing for different input sizes (100, 500, 1000) 
        int[] sizes = {100, 500, 1000};
        for (int size : sizes) {
            runPerformanceTest(size);
        }
    }
}