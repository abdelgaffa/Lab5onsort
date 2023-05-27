import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockSort {
    public static void main(String[] args) {
        double[] array = {0.63, 0.19, 0.09, 0.46, 0.61, 0.85, 0.40, 0.60, 0.71, 0.41};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        blockSort(array);

        System.out.println("\nArray after block sort:");
        System.out.println(Arrays.toString(array));
    }

    public static void blockSort(double[] array) {
        int n = array.length;
        int numBlocks = (int) Math.sqrt(n);

        // Create empty blocks
        List<Double>[] blocks = new List[numBlocks];
        for (int i = 0; i < numBlocks; i++) {
            blocks[i] = new ArrayList<>();
        }

        for (double num : array) {
            int blockIndex = (int) (num * numBlocks);
            blocks[blockIndex].add(num);
        }

        for (List<Double> block : blocks) {
            insertionSort(block);
        }

        int index = 0;
        for (List<Double> block : blocks) {
            for (double num : block) {
                array[index++] = num;
            }
        }
    }

    public static void insertionSort(List<Double> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            double key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
