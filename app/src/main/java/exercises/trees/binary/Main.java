package exercises.trees.binary;

public class Main {
    public static void main(String[] args) {
        BinaryTree arvore = new BinaryTree(10);

        arvore.adicionarValor(5);
        arvore.adicionarValor(4);
        arvore.adicionarValor(6);
        arvore.adicionarValor(18);
        arvore.adicionarValor(100);
        arvore.adicionarValor(98);
        arvore.adicionarValor(101);

        System.out.println("=== Arvore após Adições ===");
        System.out.println(arvore.toString());

        
        arvore.removerPrimeiro(); // remove o menor: 4
        arvore.removerUltimo(); // removeo  maior: 101
        System.out.println("=== Arvore após Remoções ===");
        System.out.println(arvore.toString());
    }
}