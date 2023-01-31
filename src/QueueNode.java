public class QueueNode {
    int data;
    int priority;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        next = null;
    }
    public QueueNode(int data, int priority) {
        this.data = data;
        this.priority = priority;
        next = null;
    }
}
