import java.util.Arrays;

public class QuickSort {
    public static void main(String[]args) {
        // Our array with sorted numbers and a few empty spaces
        int[] data = new int[] {3, 9, 1, 7, 2, 5, 0, 10, 4, 8} ;
        // Track how many items we have in the array
        int numItems = data.length;

        // Print the array
        System.out.println("The original array");
        System.out.println(Arrays.toString(data));

        // Copy the array
        int[] numbers = new int[numItems];
        System.arraycopy(data, 0, numbers, 0, numItems);  
        quickSort(numbers, 0, numItems-1);      
        // Print the sorted array
        System.out.println("The sorted array");
        System.out.println(Arrays.toString(numbers));   
    }

    public static void quickSort(int numbers[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(numbers, begin, end);
            quickSort(numbers, begin, partitionIndex-1);
            quickSort(numbers, partitionIndex+1, end);
        }
    }

    private static int partition(int numbers[], int begin, int end) {
        int pivot = numbers[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (numbers[j] <= pivot) {
                i++;
    
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    
        int temp = numbers[i+1];
        numbers[i+1] = numbers[end];
        numbers[end] = temp;
    
        return i+1;
    }
}
