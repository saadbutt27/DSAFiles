public class StackInt {
    int top;
    int[] arr;
    int size;

    public StackInt(int size) {
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    public void push (int value) {
        if (top == size - 1) {
            System.out.print("StackOverflow! ");
        } else {
            arr[++top] = value;
        }
    }

    public int pop () {
        if (top == -1) {
            System.out.print("StackUnderflow! ");
            return -1;
        } else {
            return arr[top--];
        }
    }

    public int peek () {
        if (top == -1) {
            System.out.print("Stack is empty! ");
            return -1;
        } else {
            return arr[top];
        }
    }
}
