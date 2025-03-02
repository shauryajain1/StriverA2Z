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
    public ListNode oddEvenList(ListNode head) {
        ListNode head1=new ListNode(-1);
        ListNode curr1=head1;
        ListNode head2=new ListNode(-1);
        ListNode curr2=head2;
        boolean oddPosition=false;
        while(head!=null)
        {
            ListNode temp=head;
            head=head.next;
            temp.next=null;
            if(oddPosition)
            {
                curr2.next=temp;
                curr2=temp;
                oddPosition=false;
            }
            else
            {
                curr1.next=temp;
                curr1=temp;
                oddPosition=true;
            }
        }
        curr1.next=head2.next;
        return head1.next;
    }
}