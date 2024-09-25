package exercises.trees.btree;

public class Main {
    public static void main(String[] args) {
        BTree arvore = new BTree(3);

        arvore.insert(10);
        arvore.insert(20);
        arvore.insert(5);
        arvore.insert(6);
        arvore.insert(12);
        arvore.insert(30);
        arvore.insert(7);
        arvore.insert(17);

        System.out.println("\n== Árvore B após inserções ==");
        arvore.printTree();

        System.out.println("\nPesquisando chave 12:");
        Node result = arvore.search(12);
        if (result != null) {
            System.out.println("Chave 12 encontrada no nó: " + result.getKeys());
        } else {
            System.out.println("Chave não encontrada.");
        }
    }
}
