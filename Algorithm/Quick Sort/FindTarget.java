//Sort array.
public class FindTarget {
    public int findTarget(int[] array, int low, int high, int targetIndex) {
        if (low < high) {
            int index = partition(array, low, high);
            if (index > targetIndex) {
                return findTarget(array, low, index - 1, targetIndex);
            } else if (index < targetIndex) {
                return findTarget(array, index + 1, high, targetIndex);
            } else {
                return array[index];
            }
        } else {
            return array[low];
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
