package Java;

/*
1. Write a function that reverses a string. The input string is given as an array of characters s.
2. You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

public class reverse_string {
    public void reverseString(char[] s) {
        int i = 0;              // i is the first index
        int j = s.length - 1;   // j is the last index
        char temp;              
        
        // Swap the first and last index until i >= j
        // For example, if the string is "hello"
        // s = ["h","e","l","l","o"] => i = 0, j = 4 => temp = s[0] = "h" => s[0] = s[4] = "o" => s[4] = temp = "h" => s = ["o","e","l","l","h"]
        // s = ["o","e","l","l","h"] => i = 1, j = 3 => temp = s[1] = "e" => s[1] = s[3] = "l" => s[3] = temp = "e" => s = ["o","l","l","e","h"]
        // s = ["o","l","l","e","h"] => i = 2, j = 2 => temp = s[2] = "l" => s[2] = s[2] = "l" => s[2] = temp = "l" => s = ["o","l","l","e","h"]
        // i >= j => exit loop
        while (i < j) {
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
    
}
