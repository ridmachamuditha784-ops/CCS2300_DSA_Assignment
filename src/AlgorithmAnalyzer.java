
	import java.util.Arrays;

	/**
	 * Module 3: Algorithm Performance Analyzer
	 * Responsibilities: Searching Algorithms, Performance Measurement, and Integration.
	 */
	public class AlgorithmAnalyzer {

	    // 1. Implementation of Binary Search Algorithm
	    public static int binarySearch(int[] arr, int target) {
	        int low = 0;
	        int high = arr.length - 1;

	        while (low <= high) {
	            int mid = low + (high - low) / 2;

	            if (arr[mid] == target) {
	                return mid; // Target found
	            }
	            if (arr[mid] < target) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return -1; // Target not found
	    }

	    // 2. Method to analyze and display performance in a tabular format
	    public static void runPerformanceTest(int size) {
	        int[] data = new int[size];
	        for (int i = 0; i < size; i++) {
	            data[i] = i; // Populating sorted data for Binary Search
	        }

	        int target = size - 1; // Searching for the last element (Worst Case)

	        // Measuring start time in nanoseconds
	        long startTime = System.nanoTime();

	        // Executing the algorithm
	        binarySearch(data, target);

	        // Measuring end time
	        long endTime = System.nanoTime();

	        long duration = endTime - startTime;

	        // Displaying results in a table-like format
	        System.out.printf("%-15d | %-20s | %-15d ns%n", size, "Binary Search", duration);
	    }

	    public static void main(String[] args) {
	        System.out.println("--- Algorithm Performance Analysis ---");
	        System.out.printf("%-15s | %-20s | %-15s%n", "Input Size", "Algorithm", "Execution Time");
	        System.out.println("------------------------------------------------------------");

	        // Testing for different input sizes as required (100, 500, 1000)
	        runPerformanceTest(100);
	        runPerformanceTest(500);
	        runPerformanceTest(1000);
	        
	        System.out.println("------------------------------------------------------------");
	    }
	}

