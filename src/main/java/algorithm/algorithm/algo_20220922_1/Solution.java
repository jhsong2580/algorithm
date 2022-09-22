package algorithm.algorithm.algo_20220922_1;

import algorithm.algorithm.algo_20220906_1.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode next = head;
        int count=0;
        while(next != null){
            count++;
            next = next.next;
        }
        next = head;
        ListNode before = null;
        for(int i = 0; i<count-n;i++){
            before = next;
            next = next.next;
        }

        if(next == head){//맨 앞을 지운다면
            return next.next;
        }

        before.next = next.next;
        //a -> next -> b
        // a.next -> next.next;
        //
        return head;
    }
}
