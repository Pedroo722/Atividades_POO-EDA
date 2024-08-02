package main.java.problemas.edd;

// class Node {
//     int value;
//     Node next;
//     Node prev;

//     public Node(int value) {
//         this.value = value;
//         this.next = null;
//         this.prev = null;
//     }
// }

public class CircularDoublyLinkedList {
    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void appendFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void appendLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    public void appendAtIndex(int value, int index) {
        if (index <= 0) {
            appendFirst(value);
        } else if (index >= size) {
            appendLast(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        }
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
        size--;
    }

    public void removeValue(int value) {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            if (current.value == value) {
                if (current == head) {
                    removeFirst();
                    return;
                } else if (current.next == head) {
                    removeLast();
                    return;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return;
                }
            }
            current = current.next;
        } while (current != head);
    }

    public void print() {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.appendFirst(1);
        list.appendFirst(1);
        list.appendLast(2);
        list.appendFirst(3);
        list.appendLast(4);

        list.removeValue(1);

        list.appendAtIndex(15, 2);

        list.removeFirst();
        list.removeLast();

        System.out.println("Lista:");
        list.print();
    }
}