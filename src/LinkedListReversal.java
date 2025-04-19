class LinkedListReversal {
    public static ListNode reverseLinkedList (ListNode SlowPtr) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = SlowPtr;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}