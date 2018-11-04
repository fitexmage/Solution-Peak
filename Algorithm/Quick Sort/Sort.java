//Sort array.
public class Sort {
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int key = array[low];

        while (low < high) {
            while (low < high && key <= array[high]) {
                high--;
            }
            array[low] = array[high];
            while (low < high && key >= array[low]) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }
}
