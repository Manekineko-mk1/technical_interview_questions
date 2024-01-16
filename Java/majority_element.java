package Java;

public class majority_element {

    /*
    1. Given an array nums of size n, return the majority element.
    2. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    */
    // Time Complexity: O(n) because we traverse the array once
    // Space Complexity: O(1) because we don't use any extra space
    // This approach is called Moore's Voting Algorithm and it is used to find the majority element in an array
    // The idea is that if we cancel out each occurrence of an element e with all the other elements that are different from e 
    //  then e will exist till end if it is a majority element.
    // For example, if we have an array [2, 3, 4, 1, 1, 1, 1] and we start from the first element
    // first iteration: num = 2, candidate = 0, (count == 0) is true => candidate = num = 2, (num == candidate) is true => count++ => count = 1
    // second iteration: num = 3, candidate = 2, (count == 0) is false, (num == candidate) is false, count-- => count = 0
    // third iteration: num = 4, candidate = 2, (count == 0) is true => candidate = num = 4, (num == candidate) => count++ => count = 1
    // fourth iteration: num = 1, candidate = 4, (count == 0) is false, (num == candidate) is false, count-- => count = 0
    // fifth iteration: num = 1, candidate = 4, (count == 0) is true => candidate = num = 1, (num == candidate) is true => count++ => count = 1
    // sixth iteration: num = 1, candidate = 1, (count == 0) is false, (num == candidate) is true => count++ => count = 2
    // seventh iteration: num = 1, candidate = 1, (count == 0) is false, (num == candidate) is true => count++ => count = 3
    // end of loop, return candidate = 1
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1};
        majority_element obj = new majority_element();
        System.out.println(obj.majorityElement(nums));
    }
}
