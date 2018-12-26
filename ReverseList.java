package Algorithm;

public class ReverseList {
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode pcur=head;
        ListNode prev=null;
        while(pcur!=null){
            ListNode ptmp=pcur;
            pcur=pcur.next;
            ptmp.next=prev;
            prev=ptmp;
        }
        return prev;
    }
}
