public class PriorityQueue {
    QueueNode front;
    QueueNode rear;

    public PriorityQueue () {
        front = null;
        rear = null;
    }

    public void enqueue(int data, int priority) {
        QueueNode n = new QueueNode(data, priority);
        if (front == null) {
            front = rear = n;
            return;
        }
        if (priority > front.priority) {
            n.next = front;
            front = n;
            return;
        }
        QueueNode current = front;
        while (current.next != null && priority > current.next.priority) {
            current = current.next;
        }
        n.next = current.next;
        current.next = n;

    }


    public QueueNode peek() {
        return front;
    }
}
