import java.util.Arrays;

//Given array and n, sort the array and create a spiral matrix with width n.
//If array has more numbers, ignore them. If array has less numbers, use 0 to supple.
/*
Given [1,2,3,4,5,6,7] and n = 3, the matrix is like:
1 0 7
2 0 6
3 4 5
*/
public class SpiralNum {
    public void SpiralNum(int[] array, int n) {
        int[][] result = new int[n][n];
        
        Arrays.sort(array);
        if (array.length < n * n) {
            int[] newArray = new int[n * n];
            for (int i = 0; i < newArray.length; i++) {
                if (i < array.length) {
                    newArray[i] = array[i];
                } else {
                    newArray[i] = 0;
                }
            }
            array = newArray;
        }

        int x = 0;
        int y = 0;
        int circle = (n + 1) / 2;
        int count = 0;

        for (int i = 0; i < circle; i++) {
            if ((i == circle - 1) && (n % 2 == 1)) {
                result[x][y] = array[count];
            } else {
                int side = n - i * 2 - 1;
                for (int j = 0; j < side; j++) {
                    result[x][y] = array[count];
                    x++;
                    count++;
                }

                for (int j = 0; j < side; j++) {
                    result[x][y] = array[count];
                    y++;
                    count++;
                }
                for (int j = 0; j < side; j++) {
                    result[x][y] = array[count];
                    x--;
                    count++;
                }
                for (int j = 0; j < side; j++) {
                    result[x][y] = array[count];
                    y--;
                    count++;
                }
                x += 1;
                y += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
