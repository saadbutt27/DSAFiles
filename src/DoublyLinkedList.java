 public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public void insertNode(int data) {
        DoublyNode n = new DoublyNode(data);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
            n.prev = tail;
        }
        tail = n;
    }

     public void insertAtFirst(int data) {
         DoublyNode n = new DoublyNode(data);
         if (head == null) {
             head = n;
             tail = n;
         } else {
             head.prev = n;
             n.next = head;
             head = n;
         }
     }

    public void traverseList() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseListReverse() {
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void searchNode(int searchValue) {
        DoublyNode temp = head;
        boolean flag = false;
        int position = 0;
        while (temp.next != null) {
            position++;
            if (temp.data == searchValue) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println(searchValue + " exists in the List at " + position);
        } else {
            System.out.println(searchValue + " doesn't exist in List");
        }
    }

    public boolean twoWaySearch(int key) {
        if (key == head.data) {
            return true;
        } else if (key == tail.data) {
            return true;
        } else {
            DoublyNode currentHead = head.next;
            DoublyNode currentTail = tail.prev;
            while ((currentHead != currentTail) && (currentHead.prev != currentTail.next) && (currentHead.prev != currentTail))
            {
                if (key == currentHead.data || key == currentTail.data) {
                    return true;
                }
                currentHead = currentHead.next;
                currentTail = currentTail.prev;
            }
            if (key == currentHead.data || key == currentTail.data) {
                return true;
            }
        }
        return false;
    }

    public boolean twoWaySearchU(int key) {
        if (head.data == key) {
            return true;
        }
        DoublyNode tempHead = head.next;
        DoublyNode tempTail = tail;
        while(tempTail.next != tempHead.prev) {
            if(tempHead.data == key || tempTail.data == key){
                return true;
            }
            tempHead = tempHead.next;
            if (tempHead != tempTail) {
                return false;
            }
            tempTail = tempTail.prev;
        }
        return false;
    }

    public void updateNode(int searchValue, int newValue) {
        DoublyNode temp = head;
        boolean flag = false;
        int position = 1;
        while (temp != null) {
            if (temp.data == searchValue) {
                temp.data = newValue;
                flag = true;
                break;
            }
            temp = temp.next;
            position++;
        }
        if (flag) {
            System.out.println(searchValue + " updated at " + position + " to " + newValue);
        } else {
            System.out.println(searchValue + " doesn't exist in List");
        }
    }

    public void insertNodeAt(int data, int pos) {
        DoublyNode n = new DoublyNode(data);
        if (pos == 1) {
            n.next = head;
            head.prev = n;
            head = n;
        } else {
            int position = 0;
            DoublyNode current = head;
            boolean flag = false;

            while(current != null) {
                position++;
                if (pos == position) {
                    flag = true;
                    break;
                }
                current = current.next;
            }
            if (flag) {
                current.prev.next = n;
                n.prev = current.prev;
                current.prev = n;
                n.next = current;
            }
        }
    }

    public void combineTwoLists(DoublyLinkedList list1, DoublyLinkedList list2) {
        list1.tail.next = list2.head;
        list2.head.prev = list1.tail;
        list1.tail = list2.tail;
    }

    public boolean deleteNode(int data) {
        if (data == head.data) {
            head = head.next;
            head.prev = null;
            return true;
        } else if (tail.data == data) {
//            while (current != null) {
//                if (current.next.next == null) {
//                    tail = current;
//                    tail.next = null;
//                    return true;
//                }
//                current = current.next;
//            }
            tail = tail.prev;
            tail.next = null;
            return true;
        } else {
            DoublyNode current = head.next;
            while (current != null) {
                if (current.data == data) {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public boolean twoWayDelete(int key){
        if(head.data == key){
            head = head.next;
            head.prev = null;
            return true;
        } else if (tail.data == key) {
            tail = tail.prev;
            tail.next = null;
            return true;
        } else {
            DoublyNode tempHead = head.next;
            DoublyNode tempTail = tail.prev;
            while(tempHead != tempTail && tempTail.next != tempHead.prev){
                if(tempHead.data == key){
                    tempHead.prev.next = tempHead.next;
                    tempHead.next.prev = tempHead.prev;
                    return true;
                } else if(tempTail.data == key){
                    tempTail.prev.next = tempTail.next;
                    tempTail.next.prev = tempTail.prev;
                    return true;
                }
                tempHead = tempHead.next;
                tempTail = tempTail.prev;
            }
        }
        return false;
    }

    // using another linked list
    public void assignment() {
        DoublyNode current = head;
        int position = 1;
        DoublyLinkedList li = new DoublyLinkedList();
        while (current.next != null) {
            if (position%2 == 0) {
                li.insertNodeAtFirst(current);
                current.next.prev = current.prev;
                current.prev.next = current.next;
            }
            current = current.next;
            position++;
        }

        current.next = li.head;
        li.head.prev = current;
        tail = li.tail;
    }

     public void insertNodeAtFirst(DoublyNode n) {
         if (head == null) {
             tail = n;
         } else {
             head.prev = n;
             n.next = head;
         }
         head = n;
     }

    // using just a node
     public void assignment2() {
         DoublyNode current = tail;
         DoublyNode move;
         int position = 1;
         while (current.prev != null) {
             if (position%2 == 0) {
                 move = current;
                 current.next.prev = current.prev;
                 current.prev.next = current.next;
                 current = current.prev;
                 tail.next = move;
                 move.prev = tail;
                 move.next = null;
                 tail = tail.next;
             } else {
                 current = current.prev;
             }
             position++;
         }
     }

     public void ass() {
         DoublyNode current = head;
         DoublyNode move;
         DoublyNode point = null;
         int position = 1;
         while (current.next != null) {
             if (position%2 == 0) {
                 move = current;
                 current.next.prev = current.prev;
                 current.prev.next = current.next;
                 current = current.next;
                 if (position > 2) {
                     point.prev.next = move;
                     move.prev = point.prev;
                     point.prev = move;
                     move.next = point;
                     point = point.prev;
//                     traverseList();
                 } else {
                     tail.next = move;
                     move.prev = tail;
                     tail = tail.next;
                     tail.next = null;
                     point = tail;
//                     traverseList();
                 }
             } else {
                 current = current.next;
             }
             position++;
         }

     }


     public void swapNodes(int x, int y) {
        DoublyNode current = head;
        DoublyNode current2 = tail;
        boolean flag1 = false;
        boolean flag2 = false;
        DoublyNode temp1 = null;
        DoublyNode temp2 = null;
        while(current.next != null) {
            if (current.data == x) {
                System.out.println("here");
                temp1 = current;
                flag1 = true;
                break;
            }
            current = current.next;
        }
         while(current2.prev != null) {
             if (current2.data == y) {
                 System.out.println("here 2");
                 temp2 = current2;
                 flag2 = true;
                 break;
             }
             current2 = current2.prev;
         }

         if (flag1 && flag2) {
//             current.prev.next = temp2;
//             current.next.prev = temp2;
//             temp2.prev = current.prev;
//             temp2.next = current.next;
//
//             current2.prev.next = temp1;
//             current2.next.prev = temp1;
//             temp1.prev = current2.prev;
//             temp1.next = current2.next;

             temp2.prev.next = temp1;
             temp2.next.prev = temp1;

             temp1.prev.next = temp2;
             temp1.next.prev = temp2;

             DoublyNode n1 = temp2.next;
             DoublyNode n2 = temp2.prev;

             temp2.next = temp1.next;
             temp2.prev = temp1.prev;

             temp1.next = n1;
             temp1.prev = n2;

         }
     }
}
