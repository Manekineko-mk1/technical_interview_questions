package Java;

import java.util.ArrayList;
import java.util.List;

/*
1. Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
*/

// Intuition:
// 1. We need to loop through the numbers from 1 to n.
// 2. If the number is divisible by 3 and 5, add "FizzBuzz" to the list.
// 3. If the number is divisible by 3, add "Fizz" to the list.
// 4. If the number is divisible by 5, add "Buzz" to the list.
// 5. If the number is not divisible by 3 or 5, add the number as a string to the list.
// 6. Return the list.
// The trick for the problem:
// 1. We need to check if the number is divisible by 3 and 5 first, if not, we will never reach the condition where the number is divisible by 3 and 5.
// 2. Understand the % operator and how it works. The % operator returns the remainder of the division
//    For example, 5 % 3 = 2 because 5 divided by 3 is 1 with a remainder of 2.
public class fizz_buzz {
    // This is the traditional solution
    public List<String> fizzBuzzTraditionalSolution(int n) {
        List<String> result = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                result.add("FizzBuzz");
            } else if (divisibleBy3) {
                result.add("Fizz");
            } else if (divisibleBy5) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }


    // This solution is more efficient because it uses StringBuilder
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            StringBuilder sb = new StringBuilder();
            if (divisibleBy3) {
                sb.append("Fizz");
            }
            if (divisibleBy5) {
                sb.append("Buzz");
            }
            if (!divisibleBy3 && !divisibleBy5) {
                sb.append(i);
            }

            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        fizz_buzz obj = new fizz_buzz();
        System.out.println(obj.fizzBuzz(15));
    }
}


