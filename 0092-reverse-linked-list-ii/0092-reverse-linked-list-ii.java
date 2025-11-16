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
class Solution 
{
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: move prev to node before 'left'
        for (int i = 1; i < left; i++) 
        {
            prev = prev.next;
        }

        // Step 2: reverse sublist
        ListNode temp = prev.next;
        for (int i = 0; i < right - left; i++) 
        {
            ListNode nxt = temp.next;
            temp.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }

        return dummy.next;
    }
}
