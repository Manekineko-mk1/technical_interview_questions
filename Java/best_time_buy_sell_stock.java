package Java;

/* 
1. You are given an array prices where prices[i] is the price of a given stock on the ith day.
2. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
3. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

// Intuition:
// 1. We need to find the lowestPrice and the maxProfit.
// 2. To get the lowestPrice, we can loop through the prices array and compare the current price with the lowestPrice.
// 3. To get the max profit, we need two counters: one counter to keep track of the profit if we sell today and another counter to keep track of the maxProfit.
// 4. We will update the maxProfit if the profit if we sell today is greater than the maxProfit.
// 5. After the loop, we will return get the max profit.
public class best_time_buy_sell_stock  {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;   // lowest price so far
        int maxProfit = 0;                     // max profit so far
        int profitIfSoldToday = 0;             // profit if sold today

        // Loop through the prices array
        // If the current price is less than lowestPrice, set lowestPrice to that price (so lowestPrice will always have smallest element)
        // Assign profitIfSoldToday = (current price - lowestPrice)
        // If maxProfit is smaller than profitIfSoldToday, set maxProfit to profitIfSoldToday
        // For example: [7,1,5,3,6,4]
        // i = 0, prices[i] = 7, lowestPrice = 7, profitIfSoldToday = 0, maxProfit = 0
        // i = 1, prices[i] = 1, lowestPrice = 1, profitIfSoldToday = 0, maxProfit = 0
        // i = 2, prices[i] = 5, lowestPrice = 1, profitIfSoldToday = 4, maxProfit = 4
        // i = 3, prices[i] = 3, lowestPrice = 1, profitIfSoldToday = 2, maxProfit = 4
        // i = 4, prices[i] = 6, lowestPrice = 1, profitIfSoldToday = 5, maxProfit = 5
        // i = 5, prices[i] = 4, lowestPrice = 1, profitIfSoldToday = 3, maxProfit = 5
        // return maxProfit = 5
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lowestPrice){
                lowestPrice = prices[i];
            }
            profitIfSoldToday = prices[i] - lowestPrice;
            if(maxProfit < profitIfSoldToday){
                maxProfit = profitIfSoldToday;
            }
        }
        return maxProfit;
    }
}