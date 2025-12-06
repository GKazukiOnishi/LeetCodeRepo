package linkedList;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = null;
        ListNode aux = current.next;
        current.next = null;

        while (aux != null) {
            next = aux;
            aux = next.next;
            next.next = current;
            current = next;
        }
        return next;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode reversed = reverseLinkedList.reverseList(l1);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}
