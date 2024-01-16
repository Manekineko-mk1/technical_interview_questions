package Java;

import java.util.Arrays;

/*
1. Given two strings s and t, return true if t is an anagram of s, and false otherwise.
2. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/

// Intuition:
// 1. We need to check if the two strings are anagrams.
// 2. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//    For example: "cat" and "act" are anagrams.
// 4. Brute force approach: We can use nested loops, check to see if each character in s is in t, but we will need to remove the character from t if it is found.
// 5. Easier approach: We can convert the strings to char arrays, sort them, and compare them.
public class valid_anagram  {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()) {
            return false;
        }

        return sortString(s).equals(sortString(t));
    }

    public String sortString(String str){
        char c[] = str.toCharArray();
        Arrays.sort(c);
        return new String(c);   
    }
}