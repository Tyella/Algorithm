package com.example.demo.dao;

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class List {
    //test leetcode
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode pcur=head;
        ListNode prev=null;
        while(pcur!=null) {
            ListNode ptmp=pcur;
            pcur=pcur.next;
            ptmp.next=prev;
            prev=ptmp;
        }
        return prev;
    }
}
