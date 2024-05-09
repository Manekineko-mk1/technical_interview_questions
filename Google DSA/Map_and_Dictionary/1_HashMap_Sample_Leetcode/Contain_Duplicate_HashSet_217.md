### LeetCode Problem: Design a HashSet without using any built-in hash table libraries.

#### Problem Statement:
- Given an integer array ```nums```, return ```true``` if any value appears at least twice in the array, and return ```false``` if every element is distinct.

    1. Example 1:

        - Input
            ```java
            nums = [1,2,3,1]
            ```
        - Output
            ```java
            true
            ```

    2. Example 2:

        - Input
            ```java
            nums = [1,2,3,1]
            ```
        - Output
            ```java
            false
            ```
    
    3. Example 3:

        - Input
            ```java
            nums = [1,1,1,3,3,4,3,2,4,2]
            ```
        - Output
            ```java
            true
            ```

        - Constraints:
            ```
            1 <= nums.length <= 10^5
            -109 <= nums[i] <= 10^9

            ```
#### Solution:
**Java Solution:**
```java
class Solution {
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
```

**Python Solution:**
```python
class Solution:
    def containsDuplicate(self, numbers):
        if len(numbers) <= 1:
            return False

        unique_set = set()

        for number in numbers:
            if number in unique_set:
                return True
            else:
                unique_set.add(number)

        return False
```
