public class BinarySearch {
    // Change it to true to follow the steps of the search
    static boolean output = false;
    public static void main(String[] args) {
        // Array with random numbers
        int[] unsortedNumbers = new int[] {10, 15, 2, 5, 1, 22, 8, 7, 9, 12, 20, 11, 6, 13, 4, 20, 18};
        // Array with sorted numbers
        int[] sortedNumbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        // Pick a random number to find
        int toFind = (int)(Math.random() * 31 - 5);

        // Welcome message
        System.out.println("Searching for the number " + toFind + "...");
        // Find the number
        int pos = binarySearch(sortedNumbers, toFind);
        
        // Result message
        if(pos != -1) {
            // In case youfind it
            System.out.println("Found at position  " + pos);
        } else {
            // Otherwise...
            System.out.println("Number not found!");
        }
    }

    public static int binarySearch(int[] numbers, int toFind) {
        // This variable will be returned with the position
        // -1 if not found
        int pos = -1;
        // To count how many times we make comparisons
        int steps = 1;       
        // Start with the first position as the lower bound 
        int min = 0;
        // Start with the last position as the upper bound
        int max = numbers.length - 1;
        // Find the mid of the search area
        int mid = (max + min) / 2;
        // Loop until the bounds are at the same position
        while(min <= max) {
            // Print the search step
            if(output) System.out.printf("Min: %2d - Mid: %2d - Max: %2d - ToFind: %2d - Found: %2d%n", min, mid, max, toFind, numbers[mid]);
            // If the number is at the middle of the search area
            if(numbers[mid] == toFind) {
                pos = mid;
                break; // NEVER do this :-)
            }
            // If the number is greater, we can cut to left part of the search area
            if(toFind > numbers[mid]) {
                min = mid + 1;
            } else {
                // Otherwise, we can cut off the right part of the search area
                max = mid - 1;
            }
            // Update the mid point
            mid = (max + min) / 2;
            // Count the steps of the search
            steps++;
        }
        // Print the number of comparisons, just for fun
        System.out.printf("After %d steps...%n", steps);
        // Return the position        
        return pos;
    }    
}
