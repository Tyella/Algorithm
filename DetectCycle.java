package Algorithm;

import java.util.HashSet;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        /*if(head==null || head.next==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            //当快慢节点相遇时
            if(fast==slow)
            {
                fast=head;
                //快慢节点再次相遇
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;*/
        if(head==null || head.next==null)
            return null;
        HashSet<ListNode> hs=new HashSet<ListNode>();
        while(head!=null)
        {
            if(!hs.add(head))
                return head;
            head=head.next;
        }
        return null;
    }
}
