import java.util.*;

class Solution3 {
    public static boolean Palindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revertData = LinkedListReversal.reverseLinkedList(slow);
        boolean check = compareTwo(head, revertData);
        LinkedListReversal.reverseLinkedList(revertData);
        if (check){
            return true;
        }
        return false;
    }
    public static boolean compareTwo (ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }
    public static void main( String args[] ) {

        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(2, 4, 6, 4, 2),
                Arrays.asList(0, 3, 5, 5, 0),
                Arrays.asList(9, 27, 4, 4, 27, 9),
                Arrays.asList(5, 4, 7, 9, 4, 5),
                Arrays.asList(5, 10, 15, 20, 15, 10, 5)
        );

        for(int i=0; i<inputList.size(); i++){
            System.out.print(i+1);
            LinkedList list = new LinkedList(inputList.get(i));
            System.out.print(".\tLinked list:  ");
            PrintList.display(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = Palindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}