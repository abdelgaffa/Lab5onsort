import java.util.Arrays;

public class Main1a {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3, 5, 2, 8, 5}; // Example array (you can modify it as per your needs)

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        countingSortEqualToKey(array);

        System.out.println("\nArray after counting sort (using the number of elements equal to the key):");
        System.out.println(Arrays.toString(array));
    }

    public static void countingSortEqualToKey(int[] array) {
        int max = Arrays.stream(array).max().getAsInt(); // Find the maximum element in the array

        int[] count = new int[max + 1]; // Create a count array with size max+1

        // Count the occurrences of each element in the array
        for (int num : array) {
            count[num]++;
        }

        int index = 0;
        // Build the sorted array by placing the elements in count array back into the original array
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
            }
        }
    }
}
