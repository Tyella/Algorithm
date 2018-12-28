package Algorithm;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)  //空链表或者只有单个结点
            return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){  //使用快慢指针寻找中间 结点
            slow = slow.next;

            fast = fast.next;
            if(fast.next != null)
                fast = fast.next;
        }

        ListNode ptr1 = slow.next;
        slow.next = null;                 //防止堆栈溢出

        ListNode tmp1 = sortList(head);
        ListNode tmp2 = sortList(ptr1);
        return merge(tmp1, tmp2);
    }
    public ListNode merge(ListNode start1,  ListNode start2){
        ListNode header=new ListNode(-1);
        ListNode ptr=header;
        while(start1!=null && start2!=null) {
            if(start1.val<=start2.val) {
                ptr.next=start1;
                ptr=start1;
                start1=start1.next;
            }
            else {
                ptr.next=start2;
                ptr=start2;
                start2=start2.next;
            }
        }
        while(start1!=null) {
            ptr.next=start1;
            ptr=start1;
            start1=start1.next;
        }
        while(start2!=null) {
            ptr.next=start2;
            ptr=start2;
            start2=start2.next;
        }
        return header.next;
    }
}
