package Java;

/*

1. Given the head of a singly linked list, return the middle node of the linked list.
2. If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class middle_of_the_linked_list {
    // Time complexity : O(n) because we need to traverse the whole list of size n once.
    // Space complexity : O(1) because we don't use any extra space.
    // If we see this question in an interview, the first step we should take is to clarify the question with the interviewer.
    // Asking questions like "Is the input always valid?" or "Will the linked list have even or odd number of elements?" can help us to better understand the problem.
    // The second step is to think about the brute force solution.
    // The brute force solution is to traverse the whole linked list and count the number of nodes.
    // Then traverse the list again and return the middle node.
    // The time complexity of this solution is O(n) because we need to traverse the whole list twice.
    // The space complexity of this solution is O(1) because we don't use any extra space.
    // The third step is to think about a better solution.
    // We can use two pointers to solve this problem such as the approach we used below.
    // Edge case for this problem is when the linked list has even number of elements.
    // In this case, we need to return the second middle node.
    // Another edge case is when the linked list is empty.
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;

            if (fast == null) return slow;
        }
        
        return slow;
    }
}

//