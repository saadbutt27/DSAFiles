public class StackFloat {
    int top;
    float[] arr;
    int size;

    public StackFloat(int size) {
        this.size = size;
        top = -1;
        arr = new float[size];
    }

    public void push (float value) {
        if (top == size - 1) {
            System.out.print("StackOverflow! ");
        } else {
            arr[++top] = value;
        }
    }

    public float pop () {
        if (top == -1) {
            System.out.print("StackUnderflow! ");
            return -1;
        } else {
            return arr[top--];
        }
    }

    public float peek () {
        if (top == -1) {
            System.out.print("Stack is empty! ");
            return -1;
        } else {
            return arr[top];
        }
    }
}
