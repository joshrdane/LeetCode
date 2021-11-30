import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(array);
        // this should probably use left-right pointers somehow
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(array[i]);
                        list.add(array[j]);
                        list.add(array[k]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int removeDuplicates(int[] array) {
        int result = array.length;
        for (int i = 0; i < result; i++) {
            for (int j = i + 1; j < result; j++) {
                if (array[i] == array[j]) {
                    swap(array, j--, --result);
                }
            }
        }
        return result;
    }

    private static void swap(int[] array, int one, int two) {
        if (array[one] != array[two]) {
            array[one] ^= array[two];
            array[two] ^= array[one];
            array[one] ^= array[two];
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0 , array.length - 1);
    }

    public static void quickSort(int[] array, int low, int high)
    {
        while (low < high){
            int index = partition(array, low, high);

            if (index - low < high - index) {
                quickSort(array, low, index - 1);
                low = index + 1;
            } else {
                quickSort(array, index + 1, high);
                high = index - 1;
            }
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = (left - 1);

        for (int j = left; j <= right - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] array = new int[] {9,3,5,6,2,4,5,6,7,6,5,4,3,4,5,6,7};
        StringBuilder builder = new StringBuilder();
        for (int c : array) {
            builder.append(c);
            builder.append(" ");
        }
        System.out.println(builder);
        builder = new StringBuilder();
        int size = removeDuplicates(array);
        quickSort(array, 0, size - 1);
        for (int i = 0; i < size; i++) {
            builder.append(array[i]);
            builder.append(" ");
        }
        System.out.println(builder);
    }
}
