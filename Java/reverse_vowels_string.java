package Java;

/*
1. Given a string s, reverse only all the vowels in the string and return it.
2. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"
*/

public class reverse_vowels_string {
    public String reverseVowels(String str) {
        int i = 0;                  // i is the first index
        int j = str.length() - 1;   // j is the last index
        char temp;              
        char[] s = str.toCharArray();
        
        // Swap the first and last index until i >= j
        // For example, if the string is "hello"
        // s = ["h","e","l","l","o"] => i = 0, j = 4 => temp = s[0] = "h" => s[0] = s[4] = "o" => s[4] = temp = "h" => s = ["o","e","l","l","h"]
        // s = ["o","e","l","l","h"] => i = 1, j = 3 => temp = s[1] = "e" => s[1] = s[3] = "l" => s[3] = temp = "e" => s = ["o","l","l","e","h"]
        // s = ["o","l","l","e","h"] => i = 2, j = 2 => temp = s[2] = "l" => s[2] = s[2] = "l" => s[2] = temp = "l" => s = ["o","l","l","e","h"]
        // i >= j => exit loop
        while (i < j) {
            if (isVowel(s[i]) && isVowel(s[j])) {
                temp = s[i];
                s[i++] = s[j];
                s[j--] = temp;
            }
            else if (!isVowel(s[i])) {
                i++;
            }
            else if (!isVowel(s[j])) {
                j--;
            }
        }
        return new String(s);
    }

    private boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        
        return vowels.indexOf(c) != -1; // -1 means not found
    }
    
}
