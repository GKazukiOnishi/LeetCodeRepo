package linkedList;

public class MiddleOfTheLinkedList {
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

    public ListNode middleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList middler = new MiddleOfTheLinkedList();

        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        printResult(middler, l1);

        l3 = new ListNode(3);
        l2 = new ListNode(2, l3);
        l1 = new ListNode(1, l2);

        printResult(middler, l1);

        l2 = new ListNode(2);
        l1 = new ListNode(1, l2);

        printResult(middler, l1);

        l1 = new ListNode(1);

        printResult(middler, l1);
    }

    private static void printResult(MiddleOfTheLinkedList middler, ListNode l1) {
        System.out.println("Resultado:");

        ListNode middle = middler.middleOfList(l1);
        while (middle != null) {
            System.out.println(middle.val);
            middle = middle.next;
        }
    }
}
