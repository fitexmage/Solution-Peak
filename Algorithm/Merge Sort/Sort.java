import java.util.Arrays;

//Sort array.
public class Sort {
    public int[] mergeSort(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return array;
        } else {
            int mid = length / 2;
            int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
            int[] right = mergeSort(Arrays.copyOfRange(array, mid, length));
            int[] mergedArray = merge(left, right);
            return mergedArray;
        }
    }

    public int[] merge(int[] left, int[] right) {
        int totalLength = left.length + right.length;
        int[] mergedArray = new int[totalLength];
        int l = 0, r = 0;
        for (int i = 0; i < totalLength; i++) {
            if (l == left.length) {
                mergedArray[i] = right[r++];
            } else if (r == right.length) {
                mergedArray[i] = left[l++];
            } else {
                if (left[l] <= right[r]) {
                    mergedArray[i] = left[l++];
                } else {
                    mergedArray[i] = right[r++];
                }
            }
        }
        return mergedArray;
    }
}
