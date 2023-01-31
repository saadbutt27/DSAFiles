public class StackList {
    StackNode top;
    public StackList (int size) {
        top = null;
    }

    public void push (int value) {
        StackNode n = new StackNode(value);
        if (top != null) {
            n.next = top;
        }
        top = n;
    }

    public int pop () {
        if (top == null) {
            System.out.print("StackUnderflow! ");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek () {
        if (top == null) {
            System.out.print("Stack is empty! ");
            return -1;
        }
        return top.data;
    }
}
