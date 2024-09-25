package exercises.hashtable.array_implementation;

public class Node {
    Aluno aluno;
    Node next;
    Node previous;

    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.next = null;
        this.previous = null;
    }

    public Aluno getAluno() {
        return aluno;
    }
}

class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Aluno getAluno(int matricula) {
        Node current = this.head;

        while (current != null) {
            if (current.getAluno().getMatricula() == matricula) {
                return current.getAluno();
            }
            current = current.next;
        }

        return null;
    }

    public Aluno get(int index) {
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
    
        return current.aluno;
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

    public void adicionar(Aluno valor) {
        Node novoNodo = new Node(valor);

        if (head == null) {
            head = novoNodo;
            tail = novoNodo; 
        } else {
            tail.next = novoNodo;
            novoNodo.previous = tail;
            tail = novoNodo;
        }
    }

    public void addLast(Aluno valor) {
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

    public void remove(Aluno value) {
        Node current = head;
        int index = 0;

        if (current == null) {
            return;
        }

        while (current != null) {
            if (current.getAluno() == value) {
                removeIndex(index);
                return;
            }
            current = current.next;
            index++;
        }
    }
}

