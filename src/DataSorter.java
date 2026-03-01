import java.util.Scanner;

public class DataSorter {

    // Member 2: Bubble Sort Implementation [cite: 97]
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);	
        
        // Requirement: Allow manual entry [cite: 93]
        System.out.println("Enter numbers separated by spaces (e.g., 5 2 9 1):");
        String input = scanner.nextLine();
        String[] items = input.split(" ");
        int[] data = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            data[i] = Integer.parseInt(items[i]);
        }

        // Requirement: Measure execution time [cite: 110]
        long startTime = System.nanoTime();
        bubbleSort(data);
        long endTime = System.nanoTime();

        // Requirement: Display sorted output [cite: 102]
        System.out.print("Sorted Output: ");
        for (int num : data) System.out.print(num + " ");
        
        System.out.println("\nExecution Time: " + (endTime - startTime) + " ns");
    }
}

