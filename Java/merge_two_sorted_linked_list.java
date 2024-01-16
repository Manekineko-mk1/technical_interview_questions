package Java;

/*
1. You are given the heads of two sorted linked lists list1 and list2.
2. Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
3. Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// The intuition behind this problem is that we will compare the first element of both the lists 
// and then we will add the smaller element to the new list 
// and then we will call the function again with the next element of the list which had the smaller element. 
// We will keep on doing this until one of the list becomes null. 
// Then we will add the remaining elements of the other list to the new list.
// For example:
// list1 = [1,2,4], list2 = [1,3,4]
// We will compare 1 and 1 and add 1 to the new list and then we will call the function again with list1.next and list2
// Now we will compare 2 and 1 and add 1 to the new list and then we will call the function again with list1.next and list2
// Now we will compare 2 and 3 and add 2 to the new list and then we will call the function again with list1.next and list2.next
// Now we will compare 4 and 3 and add 3 to the new list and then we will call the function again with list1 and list2.next
// Now we will compare 4 and 4 and add 4 to the new list and then we will call the function again with list1.next and list2.next
// Now we will compare 4 and null and add 4 to the new list and then we will call the function again with list1.next and list2.next
// Now we will compare null and null and return null
// Now we will add the remaining elements of the other list to the new list
// So the final list will be [1,1,2,3,4,4]
public class merge_two_sorted_linked_list {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list1 != null && list2 != null){
            if(list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } 
            else {
                list2.next = mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        
        
            
        return list1;
    }
}