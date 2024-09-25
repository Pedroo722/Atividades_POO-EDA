package exercises.trees.rbtree;

public class Main {
    public static void main(String[] args) {
        RBTree tree = new RBTree(null);

        System.out.println("== Inserção de Nodos ==");
        int[] valuesInsert = {10, 20, 30, 15, 25, 5, 1};
        for (int value : valuesInsert) {
            tree.insertNode(value);
            System.out.println("Inserido: " + value);
        }

        System.out.println("\n== Árvore após inserção ==");
        printTree(tree.getRaiz(), "", true);

        System.out.println("\n== Busca Nodos ==");
        int[] valuesSearch = {10, 20, 25, 100};
        for (int value : valuesSearch ) {
            System.out.println("Procurando Node com valor: " + value);
        }

        System.out.println();
        for (int value : valuesSearch) {
            Node result = tree.searchNode(value);
            if (result != null) {
                System.out.println("Encontrado: " + result.getValor() + ", com cor " + (result.isCor() ? "Preto" : "Vermelho"));
            } else {
                System.out.println("Não encontrado: " + value);
            }
        }

        System.out.println("\n== Deletando Nodos ==");
        int[] valuesToDelete = {10, 20, 5};
        for (int value : valuesToDelete) {
            tree.deleteNode(value);
            System.out.println("\nDeletado: " + value);
            System.out.println("\nÁrvore após deleção:");
            printTree(tree.getRaiz(), "", true);
        }
    }

    private static void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.print(prefix);
            System.out.print(isTail ? "└── " : "├── ");
            System.out.println(node.getValor() + (node.isCor() ? "[B]" : "[R]"));
            printTree(node.getEsquerda(), prefix + (isTail ? "    " : "│   "), false);
            printTree(node.getDireita(), prefix + (isTail ? "    " : "│   "), true);
        }
    }
}