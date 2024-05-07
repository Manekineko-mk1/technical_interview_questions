### LeetCode Problem: Longest Substring Without Repeating Characters

- A more challenging and interesting problem that also utilizes hash maps effectively is the **"Longest Substring Without Repeating Characters"** problem from LeetCode. This problem is a step up in complexity and is excellent for testing understanding of hash maps and sliding windows techniques.

#### Problem Statement:
Given a string `s`, find the length of the longest substring without repeating characters.

**Examples:**
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

**Constraints:**
- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

#### A. Possible Clarification Questions:
1. Should the function return just the length of the substring or the substring itself?
2. How should the function handle empty input strings?

#### B. Concise Solution Intuition:
Utilize a sliding window approach with two pointers and a hash map. The hash map stores characters and their indices. As you expand the right pointer to explore the string, update the map and adjust the left pointer to maintain the longest substring without repeating characters. This ensures that each character between the two pointers is unique.

#### C. Identify Edge Cases:
1. Empty string input (should return 0).
2. String with all identical characters (e.g., "aaaaa").
3. String where the longest substring is at the very end (e.g., "abcdef").

#### D. Solution Code:
**Java Solution:**
```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;
    for (int i = 0, j = 0; j < s.length(); j++) {
        if (map.containsKey(s.charAt(j))) {
            i = Math.max(map.get(s.charAt(j)) + 1, i);
        }
        map.put(s.charAt(j), j);
        maxLength = Math.max(maxLength, j - i + 1);
    }
    return maxLength;
}
```

**Python Solution:**
```python
def lengthOfLongestSubstring(s):
    charMap = {}
    maxLength, start = 0, 0
    for i, char in enumerate(s):
        if char in charMap and charMap[char] >= start:
            start = charMap[char] + 1
        charMap[char] = i
        maxLength = max(maxLength, i - start + 1)
    return maxLength
```

#### E. Test Cases (Concise Verbal on How to Test):
1. Test with the examples given in the problem statement.
2. Test with a string containing all unique characters.
3. Test with a single-character string.
4. Test with a string containing various types of characters (e.g., symbols, numbers).

#### F. Test Cases Code:

You're right! Let's add the Java test cases for the "Longest Substring Without Repeating Characters" problem:

**Java Test Cases:**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));     // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));    // Output: 3
        System.out.println(lengthOfLongestSubstring(""));          // Output: 0
        System.out.println(lengthOfLongestSubstring("abcdef"));    // Output: 6
        System.out.println(lengthOfLongestSubstring("abba"));      // Output: 2
    }
}
```

**Explanation of the Test Cases:**
- `"abcabcbb"`: Tests for a repeating pattern that resets and should identify the longest substring without repeats (`"abc"`).
- `"bbbbb"`: Tests for a string where all characters are the same, checking the function's ability to handle minimal substrings.
- `"pwwkew"`: Tests for a scenario where the longest substring appears in the middle of the string, requiring the function to accurately move the starting index of the substring.
- `""`: Tests for an empty string, which should return a length of 0.
- `"abcdef"`: Tests for a string with all unique characters, where the entire string is the longest substring.
- `"abba"`: Ensures the function handles cases where characters repeat but are not adjacent.

**Python Test Cases:**
```python
print(lengthOfLongestSubstring("abcabcbb"))  # Output: 3
print(lengthOfLongestSubstring("bbbbb"))     # Output: 1
print(lengthOfLongestSubstring("pwwkew"))    # Output: 3
print(lengthOfLongestSubstring(""))          # Output: 0
print(lengthOfLongestSubstring("abcdef"))    # Output: 6
```

This problem effectively tests your ability to manage and update indices dynamically using hash maps, making it a great choice for a more challenging interview question.
