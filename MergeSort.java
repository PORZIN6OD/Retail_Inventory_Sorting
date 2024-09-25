/* merge sort
Write a "mergeSort" method in Java and test it.

mergeSort(a,  tempArray,  first, last)


Refer to the algorithm described in chapter 16.
Algorithm  mergeSort(a,  tempArray,  first, last)
// Sorts the array entries a[first..last] recursively.
if (first < last)
{
mid = approximate midpoint between first and last 
mergeSort(a, tempArray,  first,  mid) 
mergeSort(a, tempArray, mid + 1, last)
Merge the sorted halves a[first..mid] and a[mid + 1..last] using the array tempArray
}

Submission Guide:

Upload a program and a screenshot.

*/
import java.io.*;
import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) throws IOException {
        int array[] = {16, 13, 90, 77}; // Example: 16 socks, 13 shirts, 90 shorts, 77 sweaters. Helps company with inventory counts
        int SIZE = array.length;
        int tempArray[] = new int[SIZE];
        
        System.out.println("Before sorting...");
        System.out.println(Arrays.toString(array));
        
        mergeSort(array, tempArray, 0, SIZE - 1);
        
        System.out.println("\nAfter sorting...");
        System.out.println(Arrays.toString(array));  // Print the sorted array
		System.out.println("Now we know what items to prioritize");
    }
    
    public static void mergeSort(int[] array, int[] tempArray, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, tempArray, first, mid);
            mergeSort(array, tempArray, mid + 1, last);
            merge(array, tempArray, first, mid, last);
        }
    }

    public static void merge(int[] array, int[] tempArray, int first, int mid, int last) {
        int beginHalf1 = first, endHalf1 = mid;
        int beginHalf2 = mid + 1, endHalf2 = last;
        
        int index = first;  // Use first as the starting index for the temp array
        while (beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2) {
            if (array[beginHalf1] <= array[beginHalf2]) {
                tempArray[index] = array[beginHalf1];
                beginHalf1++;
            } else {
                tempArray[index] = array[beginHalf2];
                beginHalf2++;
            }
            index++;
        }

        // Copy any remaining elements from the first half
        while (beginHalf1 <= endHalf1) {
            tempArray[index] = array[beginHalf1];
            beginHalf1++;
            index++;
        }

        // Copy any remaining elements from the second half
        while (beginHalf2 <= endHalf2) {
            tempArray[index] = array[beginHalf2];
            beginHalf2++;
            index++;
        }

        // Copy sorted subarray back to the original array
        for (index = first; index <= last; index++) {
            array[index] = tempArray[index];
        }
    }
}
