import java.io.NotActiveException;

public class LinearSearch {
    // Change to true to search in the sorted array
    static boolean sorted = false;
    public static void main(String[] args) {
        // Array with random numbers
        int[] unsortedNumbers = new int[] {10, 15, 19, 2, 5, 1, 22, 8, 7, 9, 12, 20, 11, 6, 13, 4, 20, 18};
        // Array with sorted numbers
        int[] sortedNumbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        // Pick a random number to find
        int toFind = (int)(Math.random() * 30 - 5);
        int[] numbers;
        if(sorted) {
            System.out.println("Using a sorted array...");
            numbers = sortedNumbers;
        } else {
            System.out.println("Using a unsorted array...");
            numbers = unsortedNumbers;
        }

        // Welcome message
        System.out.println("Searching for the number " + toFind + "...");
        // Find the number
        int pos = linearSearch(numbers, toFind);
        
        // Result message
        if(pos != -1) {
            // In case youfind it
            System.out.println("Found at position  " + pos);
        } else {
            // Otherwise...
            System.out.println("Number not found!");
        }
    }

    // Linear Search
    public static int linearSearch(int[] numbers, int toFind ) {
        // This variable will be returned with the position
        // -1 if not found
        int pos = -1;
        // To count how many times we make comparisons
        int steps = 1;
        // Start at the first position, keep comparing towards the end of the array
        for(int i = 0; i < numbers.length; i++) {
            // If the number is there
            if(numbers[i] == toFind) {
                pos = i;
                break; // Never do that :-)
            }
            // One more comparison
            steps++;
        }
        // Print the number of comparisons, just for fun
        System.out.printf("After %d steps...%n", steps);
        // Return the position
        return pos;
    }
}