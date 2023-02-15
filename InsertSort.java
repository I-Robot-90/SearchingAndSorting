import java.util.Arrays;
public class InsertSort {
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
        System.out.println(Arrays.toString(insertSort(data, numItems)));        
    }

    public static int[] insertSort(int[] data, int numItems) {
        // Create a new empty array of the same size
        int[] numbers = new int[numItems];
        // Deep copy all the numbers
        System.arraycopy(data, 0, numbers, 0, numItems);
        // For each element in the array, insert the first element of the
        // unsorted part in the correct position of the sorted part
        // We consider that the first number is already sorted
        for(int i = 1; i < numItems; i++) {
            orderedInsertion(numbers, i, numbers[i]);
        }
        // Return the sorted copy of the array
        return numbers;
    }
   

    public static int orderedInsertion(int[] data, int numItems, int toInsert) {
        if(numItems >= data.length) {
            // Sorry, the array is already full
            return numItems;
        }
        boolean found = false;
        int index = numItems - 1;
        // Start from the end
        while(index >= 0 && !found) {
            // If the new number is grather
            if(toInsert > data[index]) {
                // We found the position
                found = true;                
            } else {
                // Otherwise, we shift the last checked number one position over
                data[index+1] = data[index];
                index--;
            }
        }
        // Add the new number at the right position
        data[index+1] = toInsert;
        // Update the number of elementes in the array
        return numItems+1;
    }    
}
