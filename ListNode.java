class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // Handle cases where the head itself needs to be removed
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode current = head;

        // Iterate through the linked list and remove nodes with the specified value
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        printList(head);

        RemoveLinkedListElements remover = new RemoveLinkedListElements();
        int valToRemove = 6;
        ListNode newHead = remover.removeElements(head, valToRemove);

        System.out.println("\nLinked List after removing nodes with value " + valToRemove + ":");
        printList(newHead);
    }
}
