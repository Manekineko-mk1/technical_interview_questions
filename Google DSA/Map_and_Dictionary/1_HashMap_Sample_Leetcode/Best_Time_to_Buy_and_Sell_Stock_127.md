### LeetCode Problem 121: Best Time to Buy and Sell Stock

### Problem Statement
Given an array `prices` where `prices[i]` is the price of a given stock on the `i`-th day, you want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

**Example 1:**
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
```

**Example 2:**
```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e., max profit = 0.
```

**Constraints:**
- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

### Solution Approach
The key to solving this problem efficiently is to use a single pass strategy, maintaining two variables to track the minimum price encountered so far and the maximum profit we can achieve.

#### A. Possible Clarification Questions
1. Is it guaranteed that the input array `prices` will have at least one day's price?
2. Are there any constraints on the number of transactions? (For this problem, it's only one transaction.)

#### B. Concise Solution Intuition
1. Track the minimum stock price as you iterate through the list and 
2. Calculate the potential profit at each day by subtracting the current day's price from the minimum price observed so far.
3. Update the maximum profit whenever a higher profit is computed.

#### C. Identify Edge Cases
1. All prices are decreasing, meaning the best profit is 0 (e.g., `[7, 6, 4, 3, 1]`).
2. Prices initially decrease and then increase (e.g., `[4, 3, 2, 5, 6]`).

#### D. Solution Code
**Python:**
```python
class Solution:
    def maxProfit(self, prices):
        min_price = float('inf')
        max_profit = 0
        for price in prices:
            if price < min_price:
                min_price = price
            elif price - min_price > max_profit:
                max_profit = price - min_price
        return max_profit
```
**Java:**

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price found so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update the maximum profit if current profit is higher
            }
        }
        
        return maxProfit;
    }
}
```

### Explanation:
- **minPrice** is initialized to the maximum value an integer can have, which effectively ensures that the first comparison updates minPrice to the price of the first day.
- **maxProfit** starts at 0, as no transactions have occurred yet.
- The loop goes through each price in the array:
  - If the current price is lower than the `minPrice`, update `minPrice`.
  - Otherwise, calculate the potential profit from selling on that day (`price - minPrice`) and update `maxProfit` if this profit exceeds the current `maxProfit`.


#### E. Test Cases (Concise Verbal on How to Test)
1. Test with prices steadily increasing.
2. Test with prices steadily decreasing.
3. Test with prices that increase, decrease, and then increase again.
4. Test with a list where the best profit occurs in the middle of the list.

#### F. Test Cases Code
**Python:**
```python
def test_max_profit():
    sol = Solution()
    print(sol.maxProfit([7,1,5,3,6,4]))  # Output: 5
    print(sol.maxProfit([7,6,4,3,1]))  # Output: 0
    print(sol.maxProfit([2,4,1]))  # Output: 2
    print(sol.maxProfit([3,3,5,0,0,3,1,4]))  # Output: 4

test_max_profit()
```

### Java Test Case Code

```java
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        // Tests the basic functionality where buying at the lowest point and selling at a subsequent high point yields a clear maximum profit.
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 Output: " + solution.maxProfit(prices1)); // Expected Output: 5

        // Test case 2
        // Ensures the algorithm correctly handles scenarios where no profit is possible (prices continuously decrease).
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2 Output: " + solution.maxProfit(prices2)); // Expected Output: 0

        // Test case 3
        // Verifies the solution with a small number of price changes.
        int[] prices3 = {2, 4, 1};
        System.out.println("Test Case 3 Output: " + solution.maxProfit(prices3)); // Expected Output: 2

        // Test case 4
        // Checks for profit calculation with a mixture of increases and decreases in prices.
        int[] prices4 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Test Case 4 Output: " + solution.maxProfit(prices4)); // Expected Output: 4
    }
}
```

### G. Time and Space Complexity

This solution approach ensures an efficient computation with a time complexity of O(n), where n is the number of days, and a space complexity of O(1), as it only uses a couple of extra variables.