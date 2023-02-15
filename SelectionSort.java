import java.util.Arrays;

public class SelectionSort {
    public static void main (String[] args) {
        // Our array with sorted numbers and a few empty spaces
        int[] data = new int[] {3, 9, 1, 7, 2, 5, 0, 10, 4, 8} ;
        // Track how many items we have in the array
        int numItems = data.length;

        // Print the array
        System.out.println("The original array");
        System.out.println(Arrays.toString(data));

        // Print the sorted array
        System.out.println("The sorted array");
        System.out.println(Arrays.toString(selectionSort(data, numItems)));        
    }    

    public static int[] selectionSort(int[] data, int numItems) {
        // Create a new empty array of the same size
        int[] numbers = new int[numItems];
        // Deep copy all the numbers
        System.arraycopy(data, 0, numbers, 0, numItems);
        // For each element
        for(int i = 0; i < numItems - 1; i++) {
            // Find the smallest one
            int small = numbers[i];
            int pos = i;
            for(int j = i + 1; j < numItems; j++) {
                if(numbers[j] < small) {
                    small = numbers[j];
                    pos = j;
                }
            }
            // Bring the smallest number to the beginning of the array
            numbers[pos] = numbers[i];
            numbers[i] = small;
        }
        // Return the sorted array
        return numbers;
    }
}
