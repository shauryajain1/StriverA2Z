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
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       ListNode head1 = prev;
       ListNode head2 = head;
       while(head1 != null){
         max = Math.max(head1.val+head2.val,max);
         head1 = head1.next;
         head2 = head2.next;
       }
       return max;
    }
}