// Best Time to Buy and Sell Stock
// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
// Note that you cannot sell a stock before you buy one.

// Example 1:
// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Not 7-1 = 6, as selling price needs to be larger than buying price.

// Example 2:
// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

public class Main {
    public int maxProfit(int[] array) {
        int max = 0;
        int start = array[0];
        for (int i : array) {
            if (start > i) {
                start = i;
            } else {
                if (i - start > 0) {
                    max = Math.max(max, i - start);
                }
            }
        }
        return max;
    }
    
    //Permitted to complete at most two transaction
    //Return the max sum of the two transaction

    public int maxProfitFollowUp(int[] array) {
        int max1 = 0;
        int max2 = 0;
        int start1 = array[0];
        int start2 = array[1];

        for (int i = 1; i < array.length; i++) {
            if (start1 > array[i]) {
                start1 = array[i];
                start2 = array[i + 1];
            } else if (start2 > array[i]) {
                start2 = array[i];
            } else {
                if (array[i] - start1 > 0) {
                    if (max1 >= max2) {
                        max2 = Math.max(max2, array[i] - start1);
                    } else {
                        max1 = Math.max(max1, array[i] - start1);
                    }
                }
                if (array[i] - start2 > 0) {
                    if (max1 >= max2) {
                        max2 = Math.max(max2, array[i] - start2);
                    } else {
                        max1 = Math.max(max1, array[i] - start2);
                    }
                }
            }
        }
        return max1 + max2;
    }
}
