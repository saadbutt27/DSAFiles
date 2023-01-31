public class CircularQueue {
    private int front;
    private int rear;
    private int[] arr;
    private int size;
    private int count;

    public CircularQueue(int size) {
        front = 0;
        rear = -1;
        this.size = size;
        count = 0;
        arr = new int[size];
    }

    public void enqueue(int data) {
        if(count == size) {
            System.out.println("Queue is full!");
        } else {
            rear = (rear+1) % size;
            arr[rear] = data;
            count++;
        }
    }

    public int dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            int temp = arr[front];
            front = (front+1) % size;
            count--;
            return temp;
        }
    }

    public int peek() {
        if (count == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }
}
