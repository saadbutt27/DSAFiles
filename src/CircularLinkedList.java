public class CircularLinkedList {
    CircularNode head;
    CircularNode tail;

    public  CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void insertNode(int data) {
        CircularNode node = new CircularNode(data);
        if(head == null) {
            head = node;
            tail = node;
            head.prev = tail;
            head.next = tail;
            tail.prev = head;
            tail.next = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void traverse() {
        CircularNode current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        }
        while (current != head);
        System.out.println();
    }
}
