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
// 1. We need to check if the two strings are anagrams. Is it possible to arrange the characters from s such that it became t, such as "cat" to "act".
// 2. Brute force approach: We can use nested loops, check to see if each character in s is in t, remove the character from t if it is found.
// 3. Easier approach: We can convert the strings to char arrays, sort them, and compare them.
// Questions we can ask before coding:
// 1. Is it case insensitive? Can we consider cAt and act as anagrams?
public class valid_anagram {
    public boolean isAnagramBruteForce(String s, String t) {
        if(s.length()!= t.length() || s == null || t == null) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i));
            if(index == -1) {
                return false;
            }
            t = t.substring(0, index) + t.substring(index + 1);
        }
        return true;
    }

    public boolean isAnagramImproved(String s, String t) {
        if(s.length()!= t.length() || s == null || t == null) {
            return false;
        }

        return sortString(s).equals(sortString(t));
    }

    public String sortString(String str){
        char c[] = str.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);   
    }


    public static void main(String[] args) {
        valid_anagram solution = new valid_anagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagramBruteForce(s, t));
        System.out.println(solution.isAnagramImproved(s, t));
        
    }
}