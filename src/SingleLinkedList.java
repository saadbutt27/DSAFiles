import java.util.Stack;

public class SingleLinkedList {
    public SLLNode head;
    SLLNode tail;

    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    public void insertNode (int data) {
        SLLNode n = new SLLNode(data);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
    }

    public void traverseList() {
        SLLNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    public void traverseListReverse(SLLNode current) {
        if (current != null) {
            traverseListReverse(current.next);
            System.out.print(current.data + ", ");
        }
    }

    public SLLNode reverse(SLLNode head) {
//        Node prev = null;
//        Node current = head;
//        Node tempNext = null;
//        while (current != null) {
//            tempNext = current.next;
//            current.next = prev;
//            prev = current;
//            current = tempNext;
//        }
//        head = prev;
//        return head;

        Stack<SLLNode> s = new Stack<>();
        SLLNode current = head;
        while(current.next != null) {
            s.add(current);
            current = current.next;
        }
        head = current;
        while (!s.isEmpty()) {
            current.next = s.pop();
            current = current.next;
        }
        current.next = null;
        return head;
    }

    static boolean compareLists(SLLNode head1, SLLNode head2) {
        int lengthList1 = 0;
        int lengthList2 = 0;
        SLLNode curr1 = head1;
        SLLNode curr2 = head2;
        while(curr1 != null) {
            lengthList1++;
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            lengthList2++;
            curr2 = curr2.next;
        }
        if (lengthList1 == lengthList2) {
             curr1 = head1;
             curr2 = head2;
            while (curr1.next != null && curr2.next != null) {
                if (curr1.data != curr2.data) {
                    return false;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        } else {
            return false;
        }
        return true;
    }

    static SLLNode mergeLists(SLLNode head1, SLLNode head2) {
        SLLNode curr1 = head1;
        while (curr1.next != null) {
            curr1 = curr1.next;
        }
        curr1.next = head2;
        head2 = sortList(head1);
        System.out.println(head2.data);
        return head2;
    }
    static SLLNode sortList(SLLNode head) {
        SLLNode curr = head;
        SLLNode min = null;
        SLLNode currPrev = null;
        SLLNode minPrev = null;
        SLLNode next = null;
        boolean flag = false;

        while (curr != null) {
            min = curr;
            SLLNode temp = curr;
            while (temp.next != null) {
                if (min.data > temp.next.data) {
                    minPrev = temp;
                    min = temp.next;
                    next = min.next;
                    flag = true;
                }
                temp = temp.next;
            }
            if (flag) {
                if (head != curr) {
                    currPrev.next = min;
                }
                min.next = (minPrev == curr) ? curr : curr.next;
                minPrev.next = (minPrev == curr) ? next : curr;
                curr.next = next;
                head = (curr == head) ? min : head;
                curr = min;
                flag = false;
            }
            currPrev = curr;
            curr = curr.next;
        }
            return head;
    }

    static void traverseList1(SLLNode head) {
        SLLNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }


    public void searchNode(int searchValue) {
        SLLNode temp = head;
        int count = 0;
        boolean flag = false;
        while (temp.next != null) {
            count++;
            if (temp.data == searchValue) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println(searchValue + " exists in the List at position " + count);
        } else {
            System.out.println(searchValue + " doesn't exist in List");
        }
    }

    public void updateNode(int searchValue, int newValue) {
        SLLNode temp = head;
        int count = 0;
        boolean flag = false;
        while (temp.next != null) {
            count++;
            if (temp.data == searchValue) {
                temp.data = newValue;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println(searchValue + " updated at position " + count + " to " + newValue);
        } else {
            System.out.println(searchValue + " doesn't exist in List");
        }
    }

    public void insertNodeBefore(int data, SLLNode n) {
        if (head.data == data) {
            n.next = head;
            head = n;
        } else {
            SLLNode temp = head;
            boolean flag = false;
            while (temp.next != null) {
                if (temp.next.data == data) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                n.next = temp.next;
                temp.next = n;
            }
        }
    }

    public void insertNodeAfter(int d, SLLNode n) {
        SLLNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.data == d) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            n.next = temp.next;
            temp.next = n;
        }
    }

    public void deleteNode(int dataToDelete) {
        if (head.data == dataToDelete) {
            head = head.next;
        } else {
            SLLNode current = head;
            boolean flag = false;
            while (current.next != null) {
                if (dataToDelete == tail.data) {
                    tail = current;
                    tail.next = null;
                    flag  = true;
                } else if (current.next.data == dataToDelete){
                    current.next = current.next.next;
                    flag = true;
                    break;
                }
                current = current.next;
            }
            if (!flag)
                System.out.println("Data to be deleted does not exist in the list");
        }
    }

    public void swapNodes(int x, int y) {
        SLLNode current = head;
        SLLNode temp1 = null;
        SLLNode temp2 = null;
        if (head.data == x) {
            temp1 = head;
        } else {
            while(current != null) {
                if(current.next.data == x){
                    temp1 = current;
                    break;
                }
                current = current.next;
            }
        }

        current = head;
        if (head.data == y) {
            temp2 = head;
        } else {
            while(current != null) {
                if(current.next.data == y){
                    temp2 = current;
                    break;
                }
                current = current.next;
            }
        }

        SLLNode n1 = temp1.next;
        SLLNode s2 = temp2.next.next;

        temp1.next = temp2.next;
        temp1.next.next = n1.next;

        temp2.next = n1;
        n1.next = s2;

    }
    public void insertNodeAtHead(SLLNode n) {
        if (head == null) {
            tail = n;
        }
        n.next = head;
        head = n;
    }
    public void arrangeOrder() {
        SLLNode oddNode = head;
        SLLNode move;
        SingleLinkedList evenList = new SingleLinkedList();

        while (oddNode.next != null) {
            move = oddNode.next;
            if (oddNode.next == tail) {
                tail = oddNode;
                tail.next = null;
            } else {
                oddNode.next = oddNode.next.next;
                oddNode = oddNode.next;
            }

            evenList.insertNodeAtHead(move);
        }

        tail.next = evenList.head;
        tail = evenList.tail;
    }
}
