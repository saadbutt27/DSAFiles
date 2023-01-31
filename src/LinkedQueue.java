public class LinkedQueue {
    QueueNode front;
    QueueNode rear;


    public LinkedQueue () {
        front = null;
        rear = null;
    }

    public void enqueue(int data) {
        QueueNode n = new QueueNode(data);
        if (front == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }

    public QueueNode dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return null;
        } else if (front == rear) {
            QueueNode temp = front;
            front = rear = null;
            return temp;
        }
        QueueNode temp = front;
        front = front.next;
        return temp;
    }

    public QueueNode peek() {
        return front;
    }
}
