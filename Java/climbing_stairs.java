package Java;

/*
1. You are climbing a staircase. It takes n steps to reach the top.
2. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints: 1 <= n <= 45
*/
// The int
public class climbing_stairs {
    // Time complexity: O(n) because we iterate through n steps.
    // Space complexity: O(n) because we create an array of size n + 2.
    // This solution uses dynamic programming. We create an array to store the number of ways to reach each step.
    // The number of ways to reach the current step is the sum of the ways to reach the previous two steps.
    // The result is the number of ways to reach the final step (step n).
    // The array is of size n + 2 because we need to store the number of ways to reach step 0 and step 1.
    // The number of ways to reach step 0 is 0
    // The number of ways to reach step 1 is 1.
    // The number of ways to reach step 2 is the sum of the number of ways to reach step 0 and step 1.
    // The number of ways to reach step 3 is the sum of the number of ways to reach step 1 and step 2.
    // And so on.
    // The # of ways to reach the final step (step n) is the sum of the # of ways to reach step (n - 1) and step (n - 2).
    public int climbStairs(int n) {        
        // Create an array to store the number of ways to reach each step.
        int[] dp = new int[n + 2];
        
        // Base cases: There is 0 way to reach step 0, and 1 way to reach step 1.
        dp[0] = 0;
        dp[1] = 1;
        
        // Iterate through the steps, starting from step 2.
        for (int i = 2; i <= n + 1; i++) {
            // The number of ways to reach the current step is the sum of
            // the ways to reach the previous two steps.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The result is the number of ways to reach the final step (step n).
        return dp[n + 1];
    }
}
