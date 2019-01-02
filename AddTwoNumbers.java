package Algorithm;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        int carry=0;
        while(l1!=null || l2!=null){
            int d1=l1==null?0:l1.val;
            int d2=l2==null?0:l2.val;
            int sum=d1+d2+carry;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            carry=sum>=10?1:0;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1)
            cur.next=new ListNode(carry);
        return head.next;
    }
}
