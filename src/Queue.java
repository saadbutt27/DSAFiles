public class Queue {
    private int front;
    private int rear;
    private int[] arr;
    private int size;

    public Queue(int size) {
        front = rear = -1;
        this.size = size;
        arr = new int[size];
    }

    public void enqueue(int data) {
        if (rear == size-1) {
            System.out.println("Queue is full!");
            return;
        } else if (rear == -1 && front == -1) {
            front = rear = 0;
            arr[rear] = data;
        } else {
            arr[++rear] = data;
        }
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return -1;
        } else if (front == rear) {
            int temp = front;
            front = rear = -1;
            return arr[temp];
        }
        return arr[front++];
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

}
