/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Your highly efficient iterative reverse function
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        // Base case: empty list or single element is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }
        
        // 1. Find the end of the first half using fast/slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse the second half of the list
        // 'slow.next' is the start of the second half
        ListNode firstHalfEnd = slow;
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        
        // 3. Check if the values match
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean isPalindrome = true;
        
        while (p2 != null) { // We only need to check up to the end of the second half
            if (p1.val != p2.val) {
                isPalindrome = false;
                break; // Break early if asymmetry is found
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // 4. Clean up: Restore the original list structure
        firstHalfEnd.next = reverseList(secondHalfStart);
        
        return isPalindrome;
    }
}
