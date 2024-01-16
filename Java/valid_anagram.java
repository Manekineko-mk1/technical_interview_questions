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