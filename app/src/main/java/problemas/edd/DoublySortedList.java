package main.java.problemas.edd;

import java.util.Scanner;

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

public class DoublySortedList {
    private Node head;

    public DoublySortedList() {
        head = null;
    }

    public Node getNodo(int index) {
        if (index < 0 || head == null) {
            return null;
        }

        Node current = head;
        for (int i = 0; current != null && i < index; i++) {
            current = current.next;
        }

        return current;
    }

    // Adicionar
    public void adicionar(int value) {
        Node newNode = new Node(value);

        if (head == null || head.value >= value) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null && current.next.value < value) {
                current = current.next;
            }

            newNode.next = current.next;

            if (current.next != null) {
                current.next.prev = newNode;
            }

            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Remover primeiro
    public int remover() {
        if (head == null) {
            return 1; // lista vazia
        }

        if (head.next == null) {
            head = null;
            return 0;
        }

        head = head.next;
        head.prev = null;
        return 0;
    }

    // Remover com base no Index
    public int remover(int index) {
        if (index < 0 || head == null)
            return 1;

        if (index == 0) {
            head = head.next;
            if (head != null)
                head.prev = null;
            return 0;
        }

        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            return 1;
        }

        current.next = current.next.next;
        if (current.next != null) {
            current.next.prev = current;
        }

        return 0;
    }

    public int tamanho() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void printarLista() {
        Node current = head;
        System.out.print("Lista Atual: [ ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublySortedList lista = new DoublySortedList();

        lista.adicionar(5);
        lista.adicionar(3);
        lista.adicionar(8);
        lista.adicionar(1);
        lista.adicionar(10);
        lista.adicionar(-1);

        Scanner scanner = new Scanner(System.in);
        boolean processamento = true;

        while (processamento) {

            System.out.println("\n===== Operações =====");    
            System.out.println("1 - Adicionar");    
            System.out.println("2 - Remover primeiro elemento");
            System.out.println("3 - Remover Nodo específico");
            System.out.println("4 - Buscar Nodo específico");

            System.out.println();
            lista.printarLista();
            System.out.println("Tamanho da lista: " + lista.tamanho());

            System.out.print("\nOpção: ");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("\nValor: ");
                    int value = scanner.nextInt();  
                    lista.adicionar(value);
                    break;

                case 2:
                    if (lista.remover() == 0) {
                        System.out.println("\nElemento removido com sucesso.");
                    } else if (lista.remover() == 1) {
                        System.out.println("\nFalha ao remover elemento.");
                    }
                    break;

                case 3:
                    System.out.print("\nIndice: ");
                    int indexRemove = scanner.nextInt();  

                    if (lista.remover(indexRemove) == 0) {
                        System.out.println("\nNodo removido com sucesso.");
                    } else if (lista.remover(indexRemove) == 1) {
                        System.out.println("\nFalha ao remover nodo.");
                    }
                    break;

                case 4:
                    System.out.print("\nÍndice do Nodo: ");
                    int indexSearch = scanner.nextInt();

                    Node nodo = lista.getNodo(indexSearch);

                    if (nodo != null) {
                        System.out.println("\nValor do Nodo: " + nodo.value);
                    } else {
                        System.out.println("\nNodo não encontrado.");
                    }                 
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
        }
        
        scanner.close();
    }
}
