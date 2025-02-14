package exercise3;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 1000;

    public static void main(String[] args) {
        // Step 1: Generate the array of random integers
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            nums[i] = rand.nextInt(UPPER_BOUND);
        }

        // Step 2: Display the array before sorting
        System.out.println("Array before sorting:");
        printArray(nums);

        // Step 3: Prompt the user for the sorting algorithm choice
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sorting algorithm choice (b, i, s, or q): ");
        char choice = scanner.next().charAt(0); // Read the first character of the input
        scanner.close();

        // Step 4: Sort the array based on the chosen algorithm
        switch (choice) {
            case 'b':
                bubbleSort(nums);
                System.out.println("Sorted using Bubble Sort.");
                break;
            case 'i':
                insertionSort(nums);
                System.out.println("Sorted using Insertion Sort.");
                break;
            case 's':
                selectionSort(nums);
                System.out.println("Sorted using Selection Sort.");
                break;
            case 'q':
                quickSort(nums, 0, nums.length - 1);
                System.out.println("Sorted using QuickSort.");
                break;
            default:
                System.out.println("Invalid choice. Please use b, i, s, or q.");
                return;
        }

        // Step 5: Display the array after sorting
        System.out.println("Array after sorting:");
        printArray(nums);
    }

    // Bubble Sort Algorithm (Descending Order)
    public static void bubbleSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) { // Swap if the current element is smaller than the next
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort Algorithm (Descending Order)
    public static void insertionSort(Integer[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < key) { // Move elements smaller than key to the right
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Selection Sort Algorithm (Descending Order)
    public static void selectionSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) { // Find the maximum element
                    maxIndex = j;
                }
            }
            // Swap the found maximum element with the current element
            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }

    // QuickSort Algorithm (Descending Order)
    public static void quickSort(Integer[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high); // Partition the array
            quickSort(array, low, pivotIndex - 1); // Sort the left subarray
            quickSort(array, pivotIndex + 1, high); // Sort the right subarray
        }
    }

    // Helper method for QuickSort (Partitioning)
    public static int partition(Integer[] array, int low, int high) {
        int pivot = array[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element
        for (int j = low; j < high; j++) {
            if (array[j] >= pivot) { // Move elements greater than or equal to the pivot to the left
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap the pivot element with the element at i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1; // Return the pivot index
    }

    // Helper method to print the array
    public static void printArray(Integer[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}