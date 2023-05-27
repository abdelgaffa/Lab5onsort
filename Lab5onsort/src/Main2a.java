import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2a {
    public static void main(String[] args) {
        int[] array = {43, 12, 2, 8, 65, 27, 91, 34}; // Example array (you can modify it as per your needs)

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        digitalSortUsingArrayList(array);

        System.out.println("\nArray after digital sort (using ArrayList):");
        System.out.println(Arrays.toString(array));
    }

    public static void digitalSortUsingArrayList(int[] array) {
        List<Integer>[] digitBuckets = new List[10]; // Create 10 digit buckets

        for (int i = 0; i < digitBuckets.length; i++) {
            digitBuckets[i] = new ArrayList<>();
        }

        boolean sorted = false;
        int divisor = 1;

        while (!sorted) {
            sorted = true;

            // Distribute the elements into digit buckets
            for (int num : array) {
                int digit = (num / divisor) % 10;
                if (digit != 0) {
                    sorted = false;
                }
                digitBuckets[digit].add(num);
            }

            // Gather the elements from the digit buckets back into the original array
            int index = 0;
            for (List<Integer> bucket : digitBuckets) {
                for (int num : bucket) {
                    array[index++] = num;
                }
                bucket.clear();
            }

            divisor *= 10; // Move to the next digit
        }
    }
}
