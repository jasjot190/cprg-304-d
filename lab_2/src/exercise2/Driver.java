package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 10;

    public static void main(String[] args) {

        // Step 1: Generate a sorted array of integers
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();
        int randnum = rand.nextInt(UPPER_BOUND);
        nums[0] = randnum;

        for (int i = 1; i < SIZE; i++) {
            randnum = rand.nextInt(UPPER_BOUND);
            nums[i] = nums[i - 1] + randnum;
        }

        // Display the generated array (optional)
        System.out.println("Generated Sorted Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Step 2: Prompt the user for the target value
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();
        scanner.close();

        // Step 3: Perform binary search
        int result = binarySearch(nums, target);

        // Step 4: Display the result
        if (result == -1) {
            System.out.println("Target not found in the array. -1");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }

    // Binary Search Implementation
    public static int binarySearch(Integer[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids overflow
            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                low = mid + 1; // Search the upper half
            } else {
                high = mid - 1; // Search the lower half
            }
        }
        return -1; // Target not found
    }
}