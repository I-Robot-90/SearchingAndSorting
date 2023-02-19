import java.util.Arrays;

public class MergeSort {
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
        mergeSort(numbers, 0, numItems-1);      
        // Print the sorted array
        System.out.println("The sorted array");
        System.out.println(Arrays.toString(numbers));   
    }

	public static void mergeSort(int[] numbers, int begin, int end)
	{
		if (begin < end) {
			// Find the middle point
			int mid = begin + (end - begin) / 2;

			// Sort first and second halves
			mergeSort(numbers, begin, mid);
			mergeSort(numbers, mid + 1, end);

			// Merge the sorted halves
			merge(numbers, begin, mid, end);
		}
	}

	// Merges two subarrays
	//  Left subarray is numbers[begin..mid]
	//  Right subarray is numbers[mid+1..right]
	public static void merge(int[] numbers, int begin, int mid, int end)
	{
		// Find sizes of two subarrays to be merged
		int sizeLeft = mid - begin + 1;
		int sizeRight = end - mid;

		/* Create temp arrays */
		int[] left = new int[sizeLeft];
		int[] right = new int[sizeRight];

		/*Copy data to temp arrays*/
		for (int i = 0; i < sizeLeft; ++i) {
			left[i] = numbers[begin + i];
        }
		for (int j = 0; j < sizeRight; ++j) {
			right[j] = numbers[mid + 1 + j];
        }

		// Merge the arrays back
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = begin;
		while (i < sizeLeft && j < sizeRight) {
			if (left[i] <= right[j]) {
				numbers[k] = left[i];
				i++;
			}
			else {
				numbers[k] = right[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of left[] if any
		while (i < sizeLeft) {
			numbers[k] = left[i];
			i++;
			k++;
		}

		// Copy remaining elements of right[] if any 
		while (j < sizeRight) {
			numbers[k] = right[j];
			j++;
			k++;
		}
	}
}