package Java;

import java.util.HashMap;

/*
1. Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
2. Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
*/

public class ransom_note {
    // Time complexity of this approach is O(n^2) because we are using the indexOf() method which has a time complexity of O(n) and we are using it n times
    // Space complexity of this approach is O(1) because we are not using any extra space
    // The intuition behind this problem is that we will iterate over the ransomNote string and check if the character is present in the magazine string or not
    // and if the character is present in the magazine string then we will remove that character from the magazine string
    // and if the character is not present in the magazine string then we will return false
    // and if we are able to iterate over the whole ransomNote string then we will return true
    // Advantages: Easy to understand and implement
    // Disadvantages: Time complexity is O(n^2)
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int index = magazine.indexOf(ch);
            if (index == -1) {
                return false;
            }
            magazine = magazine.substring(0, index) + magazine.substring(index + 1);
        }

        return true;
    }

    // This is a better approach than the above one because the time complexity of the above approach is O(n^2) and the time complexity of this approach is O(n)
    // but the space complexity of this approach is O(n) and the space complexity of the above approach is O(1)
    // So, if the space complexity is not a problem then this approach is better than the above one.
    // The intuition behind this problem is that we will create a HashMap of the characters of the magazine string
    // and then we will iterate over the ransomNote string and check if the character is present in the HashMap or not
    // and if the character is present in the HashMap then we will decrease the value of that character by 1
    // and if the value of that character is 0 then we will remove that character from the HashMap
    // and if the character is not present in the HashMap then we will return false
    // and if we are able to iterate over the whole ransomNote string then we will return true
    // Advantages: Time complexity is O(n)
    // Disadvantages: Space complexity is O(n) and it is more difficult to understand and implement than the above approach
    public boolean canConstructHashMap(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
    
}
