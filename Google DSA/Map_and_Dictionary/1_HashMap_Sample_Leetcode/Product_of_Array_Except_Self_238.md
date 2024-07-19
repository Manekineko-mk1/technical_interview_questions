### LeetCode Problem 238, "Product of Array Except Self"

### Problem Statement
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

### Solution Approach
**Two-Pass Method Using Extra Space:**
- **First Pass (Left Products):** Calculate the cumulative product of elements to the left of each index.
- **Second Pass (Right Products):** Adjust each index with the cumulative product of elements to the right.

### Solution Code

**Java Solution:**
```java
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Left products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Right products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        
        return answer;
    }
}
```

**Python Solution:**
```python
class Solution:
    def productExceptSelf(self, nums):
        n = len(nums)
        answer = [1] * n

        # Left products
        for i in range(1, n):
            answer[i] = answer[i - 1] * nums[i - 1]

        # Right products
        right = 1
        for i in reversed(range(n)):
            answer[i] *= right;
            right *= nums[i]

        return answer
```

### Test Cases

**Java Test Code:**
```java
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] result1 = solution.productExceptSelf(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(result1));  // Output: [24, 12, 8, 6]

        // Test case 2
        int[] result2 = solution.productExceptSelf(new int[] {-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(result2));  // Output: [0, 0, 9, 0, 0]
    }
}
```

**Python Test Code:**
```python
def test_product_except_self():
    sol = Solution()
    print(sol.productExceptSelf([1, 2, 3, 4]))  # Output: [24, 12, 8, 6]
    print(sol.productExceptSelf([-1, 1, 0, -3, 3]))  # Output: [0, 0, 9, 0, 0]

test_product_except_self()
```

### Time and Space Complexity
- **Time Complexity:** O(n) for both solutions. Each solution makes two passes over the input array (`nums`), where `n` is the number of elements in the array.
- **Space Complexity:** O(n) for both solutions if the output array is considered part of the space complexity. If not, then it's O(1) since we're only using constant extra space apart from the input and output arrays.
