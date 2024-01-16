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
