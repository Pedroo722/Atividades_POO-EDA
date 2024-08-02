package main.java.problemas.edd;

public class Node {
int value;
Node next;
Node prev;

public Node(int value) {
    this.value = value;
    this.next = null;
    this.prev = null;
}
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        if (index < 0) {
            System.out.println("O índice não pode ser negativo.");
        }
        
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
    
        if (current == null) {
            System.out.println("O índice está além do tamanho da lista.");
        }
    
        return current.value;
    }

    public int size() {
        Node current = head;
        int contador = 1;

        while (current.next != tail) {
            current = current.next;
            contador++;
        }

        return contador+1;
    }
    

    public void add(int valor, int index) {
        if (index < 0) {
            System.out.println("O índice não pode ser negativo.");
        }
            
        Node novoNodo = new Node(valor);

        if (index == 0) {
            addFirst(valor);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("O índice está além do tamanho da lista.");
            }

            novoNodo.next = current.next;
            current.next = novoNodo;

            if (novoNodo.next == null) {
                tail = novoNodo;
            }
        }
    }

    public void addFirst(int valor) {
        Node novoNodo = new Node(valor);

        if (head == null) {
            head = novoNodo;
            tail = novoNodo; 
        } else {
            novoNodo.next = head;
            head = novoNodo;
        }
    }

    public void addLast(int valor) {
        Node novoNodo = new Node(valor);

        if (tail == null) {
            head = novoNodo;
            tail = novoNodo; 
        } else {
            tail.next = novoNodo;
            tail = novoNodo;
        }
    }

    public void removeIndex(int index) {
        if (index < 0) {
            System.out.println("O índice não pode ser negativo.");
            return;
        }
        
        if (head == null) {
            System.out.println("Lista vazia, nenhum elemento para remover.");
            return;
        }
        
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        
        Node previous = null;
        Node current = head;
        int currentIndex = 0;
        
        while (current != null && currentIndex != index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
        
        if (current == null) {
            System.out.println("O índice está além do tamanho da lista.");
            return;
        }
        
        previous.next = current.next;
        if (current == tail) {
            tail = previous;
        }
    }
    

    public void removeFirst() {
        if (head == null) {
            return;
        }
    
        head = head.next;
    }

    public void removeLast() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        
        while (current.next != tail) {
            current = current.next;
        }
    
        current.next = null;
        tail = current;
    }

    public void printar() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("Head: " + head.value);
        System.out.println("Tail: " + tail.value);
    }

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();

        // Adicionando elementos à lista
        lista.addFirst(1);
        lista.addFirst(97);
        lista.addFirst(2);
        lista.addFirst(3);
        lista.addFirst(4);
        lista.addLast(12);
        lista.add(1, 3);
        lista.addFirst(97);

        lista.removeFirst();
        lista.removeLast();

        lista.removeIndex(2);


        // Exibindo os elementos da lista
        System.out.print("Lista Encadeada: ");
        lista.printar();
        System.err.println("Tamanho: " + lista.size());
    }
}
