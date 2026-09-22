public class DeleteNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node deleteNode(Node head, int value) {

        if (head == null) {
            return null;
        }

        // If head needs to be deleted
        if (head.data == value) {

            if (head.next == head) {
                return null;
            }

            Node last = head;

            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;

            return head;
        }

        Node current = head;

        while (current.next != head) {

            if (current.next.data == value) {

                current.next = current.next.next;
                return head;
            }

            current = current.next;
        }

        return head;
    }

    public static void printList(Node head) {

        if (head == null) {
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = head;

        head = deleteNode(head, 30);

        printList(head);
    }
}