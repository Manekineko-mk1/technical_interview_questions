package Java;

import java.util.HashSet;
import java.util.Set;

/*
1. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. 

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/

public class contains_duplicate {
    // Time complexity : O(n) because we need to traverse the whole array of size n once.
    // Space complexity : O(n) because we use a HashSet to store the elements of the array.
    // Brute force solution is to use two for loops and compare each element with the rest of the elements.
    
    public boolean containsDuplicate(int[] numbers) {
        if(numbers.length <= 1) return false;

        Set<Integer> uniqueSet = new HashSet<>();
        
        for (int number : numbers) {
            if (uniqueSet.contains(number)) {
                return true;
            } else {
                uniqueSet.add(number);
            }
        }

        return false;
    }    
}
