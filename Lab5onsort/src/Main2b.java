import java.util.Arrays;

public class Main2b {
    public static void main(String[] args) {
        int[] array = {43, 12, 2, 8, 65, 27, 91, 34}; // Example array (you can modify it as per your needs)

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        digitalSortByDigit(array);

        System.out.println("\nArray after digital sort (using explicit call to digit sort):");
        System.out.println(Arrays.toString(array));
    }

    public static void digitalSortByDigit(int[] array) {
        int max = Arrays.stream(array).max().getAsInt(); // Find the maximum element in the array

        int divisor = 1;
        while (max / divisor > 0) {
            digitSort(array, divisor);
            divisor *= 10;
        }
    }

    public static void digitSort(int[] array, int divisor) {
        int[] count = new int[10]; // Count array to store the frequency of each digit (0-9)
        int[] temp = new int[array.length]; // Temporary array to store the sorted elements

        // Count the frequency of each digit at the current divisor position
        for (int num : array) {
            int digit = (num / divisor) % 10;
            count[digit]++;
        }

        // Calculate the cumulative count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array by placing the elements in temp array based on their positions
        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / divisor) % 10;
            temp[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(temp, 0, array, 0, array.length);
    }
}
