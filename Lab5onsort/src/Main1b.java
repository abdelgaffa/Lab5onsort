import java.util.Arrays;

public class Main1b {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3, 5, 2, 8, 5}; // Example array (you can modify it as per your needs)

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        countingSortLessThanOrEqualToKey(array);

        System.out.println("\nArray after counting sort (using the number of elements less than or equal to the key):");
        System.out.println(Arrays.toString(array));
    }

    public static void countingSortLessThanOrEqualToKey(int[] array) {
        int max = Arrays.stream(array).max().getAsInt(); // Find the maximum element in the array

        int[] count = new int[max + 1]; // Create a count array with size max+1

        // Count the occurrences of each element in the array
        for (int num : array) {
            count[num]++;
        }

        // Calculate the cumulative count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sortedArray = new int[array.length];

        // Build the sorted array by placing the elements in count array based on their positions
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }
}
