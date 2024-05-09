### LeetCode Problem: Design a HashSet without using any built-in hash table libraries.

#### Problem Statement:

- Given two integer arrays ```nums1``` and ```nums2```, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

  1. Example 1:

     - Input
       ```java
       nums1 = [1,2,2,1], nums2 = [2,2]
       ```
     - Output
       ```java
       [2]
       ```

  2. Example 2:

     - Input
       ```java
       nums1 = [4,9,5], nums2 = [9,4,9,8,4]
       ```
     - Output
       ```java
       [9,4] or [4,9]
       ```

- Constraints:
  ```
  1 <= nums1.length, nums2.length <= 1000
  0 <= nums1[i], nums2[i] <= 1000
  ```


- For the "Intersection of Two Arrays" problem, the goal is to find the set of elements that are present in both arrays, ensuring that each element in the result is unique. We can approach this problem effectively using a hash set to keep track of the elements of one array and then check for common elements with the other array.

### A. Possible Clarification Questions:
1. Can the arrays contain negative numbers or are they strictly non-negative as suggested by the constraints?
2. What should be the output if there is no intersection between the two arrays (empty array or null)?
3. Are the arrays always sorted or can they be in any order?

### B. Concise Solution Intuition:
Using hash sets is ideal for this problem because hash sets automatically handle duplicate values and allow for average \(O(1)\) time complexity for checks. The plan is:
- Use a hash set to store all elements of `nums1`.
- Iterate over `nums2`, adding elements to the result set if they exist in the `nums1` set.
- Convert the result set to a list or array since sets naturally eliminate duplicates, ensuring each element is unique.

### C. Identify Edge Cases:
1. **Empty Input:** One or both input arrays are empty (`[]`), resulting in an empty intersection.
2. **No Common Elements:** Arrays do not share any common elements, e.g., `[1,2,3]` and `[4,5,6]`.
3. **Duplicate Elements:** Arrays contain duplicates, which should not appear in the output more than once.
4. **Varying Sizes:** Arrays are of significantly different sizes.

### D. Solution Code:
**Java Solution:**
```java
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }
        
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
```

**Python Solution:**
```python
class Solution:
    def intersection(self, nums1, nums2):
        set1 = set(nums1)
        intersection = set(num for num in nums2 if num in set1)
        return list(intersection)
```

### E. Test Cases (Concise Verbal on How to Test):
1. Test with both arrays containing the same single element.
2. Test with completely distinct arrays.
3. Test with one array being a subset of the other.
4. Test with mixed numbers and multiple duplicates.

### F. Test Cases Code:
**Java Test Code:**
```java
public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.intersection(new int[]{1,2,2,1}, new int[]{2,2})));  // Output: [2]
    System.out.println(Arrays.toString(solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));  // Output: [4, 9]
    System.out.println(Arrays.toString(solution.intersection(new int[]{}, new int[]{1,2,3})));  // Output: []
    System.out.println(Arrays.toString(solution.intersection(new int[]{1,1,1,1}, new int[]{1,1})));  // Output: [1]
}
```

**Python Test Code:**
```python
if __name__ == "__main__":
    solution = Solution()
    print(solution.intersection([1,2,2,1], [2,2]))  # Output: [2]
    print(solution.intersection([4,9,5], [9,4,9,8,4]))  # Output: [9, 4]
    print(solution.intersection([], [1,2,3]))  # Output: []
    print(solution.intersection([1,1,1,1], [1,1]))  # Output: [1]
```
