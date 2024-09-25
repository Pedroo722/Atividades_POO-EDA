package exercises.list;

// class Node {
//     int value;
//     Node next;

//     public Node(int value) {
//         this.value = value;
//         this.next = null;
//     }
// }

public class CircularLinkedList {
    Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void appendFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            head.next = head; 
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head; 
            last.next = newNode; 
            head = newNode; 
        }
    }

    public void appendLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void appendAtIndex(int value, int index) {
        Node newNode = new Node(value);
    
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            if (index <= 0) {
                newNode.next = head;
                Node last = head;

                while (last.next != head) {
                    last = last.next;
                }

                last.next = newNode;
                head = newNode;
            } else { 
                Node current = head;
                int count = 0;

                while (count < index - 1 && current.next != head) {
                    current = current.next;
                    count++;
                }

                Node nextNode = current.next;
                current.next = newNode;
                newNode.next = nextNode;
            }
        }
    }
    
    public void removeFirst() {
        if (head == null) {
            return;
        }
    
        if (head.next == head) {
            head = null;
        } else {
            Node last = head;

            while (last.next != head) {
                last = last.next;
            }

            last.next = head.next;
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
    
        if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            Node previous = null;
    
            while (current.next != head) {
                previous = current;
                current = current.next;
            }
    
            previous.next = head;
        }
    }

    public void removeValue(int value) {
        if (head == null) {
            return;
        }
    
        Node current = head;
        Node previous = null;
    
        do {
            if (current.value == value) {
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    
        if (current == head) {
            if (head.next == head) {
                head = null;
            } else {
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
            }
        } else {
            previous.next = current.next;
        }
    }
    

    public void printar() {
        Node current = head;

        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.appendFirst(1);
        list.appendFirst(1);
        list.appendLast(2);
        list.appendFirst(3);
        list.appendLast(4);

        list.removeValue(1);

        list.appendAtIndex(15, 3);

        list.removeFirst();
        list.removeLast();

        System.out.println("Lista:");
        list.printar();
    }
}