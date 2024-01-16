package Java;

import java.util.Stack;

/*
1. Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
*/

// Intuition:
// 1. We can check if the string is valid parentheses by using a stack.
// 2. If the character is an opening bracket, push it onto the stack.
// 3. If the character is a closing bracket, check if the stack is empty.
//    If the stack is empty, meaning there is no opening bracket to match the closing bracket, return false.
//    If the stack is not empty, pop the top of the stack and check if the top of the stack matches the closing bracket.
//    If the top of the stack does not match the closing bracket, return false.
// 4. After the loop, if the stack is empty, return true.
//    If the stack is not empty, return false.
public class valid_parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { // If the character is a closing bracket
                
                // If the stack is empty, meaning there is no opening bracket to match the closing bracket
                if (stack.isEmpty()) return false;

                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // empty = all brackets matched
        // not empty = not all brackets matched
        return stack.isEmpty();
    }
}