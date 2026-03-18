class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        
        while(current.next != null){
            ListNode nextNode = current.next; 
            if(current.val == nextNode.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }

        return head;
        
    }
}