import java.util.Arrays;
public class BubbleSort {
    public static void main(String[]args) {
        // Our array with sorted numbers and a few empty spaces
        int[] data = new int[] {3, 9, 1, 7, 2, 5, 0, 10, 4, 8} ;
        // Track how many items we have in the array
        int numItems = data.length;

        // Print the array
        System.out.println("The original array");
        System.out.println(Arrays.toString(data));

        // Print the sorted array
        System.out.println("The sorted array");
        System.out.println(Arrays.toString(bubbleSort(data, numItems)));        
    }

    public static int[] bubbleSort(int[] data, int numItems) {  
        int[] numbers = new int[numItems];
        System.arraycopy(data, 0, numbers, 0, numItems);
        int size = numItems;  
        int temp = 0;  
        for(int i = 0; i < size; i++){  
            for(int j = 1; j < size - i; j++){  
                if(numbers[j-1] > numbers[j]){  
                    //swap elements  
                    temp = numbers[j-1];  
                    numbers[j-1] = numbers[j];  
                    numbers[j] = temp;  
                }                      
            }
        }
        return numbers;  
    } 
}

