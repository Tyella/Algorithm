package Algorithm;

public class GetIntersectionNode {
    /*
    链表中不存在环,我们可以用环的思想来做.我们让两条链表从各自的头开始遍历。
    如果一条链表到结尾了，则切换到另一条。当两个节点相遇时，只有一种情况，
    说明此位置是它们的交点，因为两个节点走过的路程相同。如果没有相遇，则为null
     */
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null || headB==null)
            return null;
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
            a=(a!=null)?a.next:headB;
            b=(b!=null)?b.next:headA;
        }
        return a;
    }
}
