public class StackChar {
    int top;
    char[] arr;
    int size;

    public StackChar(int size) {
        this.size = size;
        arr = new char[size];
        top = -1;
    }

    public void push (char value) {
        if (top == size-1) {
            System.out.print("StackOverflow! ");
        } else {
            arr[++top] = value;
        }
    }

    public void reverse () {
        if (top == -1) {
            return;
        } else {
            System.out.print(arr[top--]);
            reverse();
        }
    }

    public char pop () {
        if (top == -1) {
            System.out.print("StackUnderflow! ");
            return '1';
        } else {
            return arr[top--];
        }
    }
    
    public char peek () {
        if (top == -1) {
            System.out.print("Stack is empty! ");
            return '1';
        } else {
            return arr[top];
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

}
