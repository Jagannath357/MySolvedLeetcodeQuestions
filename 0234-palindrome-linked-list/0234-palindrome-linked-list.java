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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next; // 1. Temporarily store the next node
            curr.next = prev; // 2. Reverse the link (point backwards)
            prev = curr; // 3. Move 'prev' one step forward
            curr = next; // 4. Move 'curr' one step forward
        }

        // 'prev' is now pointing to the new head of the reversed list
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int l = 0;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        if(l == 0 || l == 1) return true;
        int n = l / 2;
        temp = head;
        while (n != 0) {
            temp = temp.next;
            n--;
        }
        ListNode newNode = null;
        if (l % 2 == 0) {
            newNode = temp;
        } else {
            newNode = temp.next;
        }
        newNode = reverseList(newNode);
        temp = head;
        while (newNode != null) {
            if (temp.val != newNode.val)
                return false;
            temp = temp.next;
            newNode = newNode.next;
        }
        return true;
    }
}