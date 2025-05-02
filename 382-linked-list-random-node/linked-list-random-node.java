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
Random rand;
List<Integer> values;
    public Solution(ListNode head) {
        values=new ArrayList<>();
        rand=new Random();
        ListNode temp = head;
        while(temp!=null){
            values.add(temp.val);
            temp=temp.next;
        }
    }
    
    public int getRandom() {
       int index=rand.nextInt(values.size());
       return values.get(index);
    }
}
