import java.util.Arrays;
public class OrderedInsertion {
    public static void main (String[] args) {
        // Our array with sorted numbers and a few empty spaces
        int[] data = new int[] {1, 3, 5, 7, 8, 9, 0, 0, 0, 0};
        // Track how many items we have in the array
        int numItems = 6;
        // The number to add into the array        
        int toInsert;

        // Print the array
        System.out.println("The original array");
        System.out.println(Arrays.toString(data));

        // Try to insert number 10
        toInsert = 10;
        System.out.println("Inserting the number: " + toInsert);
        numItems = orderedInsertion(data, numItems, toInsert);
        System.out.println(Arrays.toString(data));

        // Try to insert number 2
        toInsert = 2;
        System.out.println("Inserting the number: " + toInsert);
        numItems = orderedInsertion(data, numItems, toInsert);
        System.out.println(Arrays.toString(data));

        // Try to insert number 0
        toInsert = 0;
        System.out.println("Inserting the number: " + toInsert);
        numItems = orderedInsertion(data, numItems, toInsert);
        System.out.println(Arrays.toString(data));

        // Try to insert number 11
        toInsert = 11;
        System.out.println("Inserting the number: " + toInsert);
        numItems = orderedInsertion(data, numItems, toInsert);
        System.out.println(Arrays.toString(data));

        // Try to insert number 4, it will not work, the array is already full
        toInsert = 4;
        System.out.println("Inserting the number: " + toInsert);
        numItems = orderedInsertion(data, numItems, toInsert);
        System.out.println(Arrays.toString(data));

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