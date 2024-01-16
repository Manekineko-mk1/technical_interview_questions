package Java;

import java.util.HashMap;
import java.util.Map;

/*
1. Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
2. You may assume that each input would have exactly one solution, and you may not use the same element twice.
3. You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/

public class two_sum {
    // Time complexity: O(n^2) because of nested for loops
    // Space complexity: O(1) because no extra space is used
    // This approach is not recommended because of the time complexity
    // This approach is harder to understand because of nested for loops
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if ((nums[i]+nums[j]) == target){
                    return new int[] {i,j};
                }
            }
        }

        // If no solution found
        return new int[] {-1,-1};    
    }

    // Advantages: Faster than brute force, Time complexity: O(n) because of HashMap
    // Disadvantages: Uses extra space, Space complexity: O(n) because of HashMap
    // This approach is easier to understand because of HashMap and single for loop
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }

        // If no solution found
        return null;
    }
    
}
