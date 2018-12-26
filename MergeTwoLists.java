package Algorithm;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l2==null)
            return l1;
        if(l1==null)
            return l2;
        ListNode l=null;
        if(l1.val>l2.val){
            l=new ListNode(l2.val);
            l.next=mergeTwoLists(l1,l2.next);
        }else{
            l=new ListNode(l1.val);
            l.next=mergeTwoLists(l1.next,l2);
        }
        return l;
    }
}
