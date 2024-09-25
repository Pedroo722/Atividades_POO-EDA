package exercises.trees.avltree;


public class Main {
    public static void main(String[] args) {
        AVLTree arvore = new AVLTree();

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(50);
        arvore.inserir(25);
        arvore.inserir(30);
        arvore.inserir(13);


        System.out.println("=== Àrvore Inicial ===");
        System.out.println(arvore.toString());


        System.out.println("Altura da raiz: " + arvore.calcularAltura(arvore.raiz));
        System.out.println("Fator de balanceamento da raiz: " + arvore.calcularFatorDeBalanceamento(arvore.raiz) + '\n');


        System.out.println("=== Inserção de Valores ===");
        System.out.println("Inserindo valores 30, 20, 10 para causar uma rotação à direita:");
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(10);
        System.out.println(arvore);
        
        System.out.println("Inserindo valores 10, 20, 30 para causar uma rotação à esquerda:");
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        System.out.println(arvore);

        System.out.println("=== Remoção de Valores ===");
        System.out.println("Removendo valor 20 da árvore AVL:");
        arvore.remover(20);
        System.out.println(arvore);

        System.out.println("Removendo o menor valor (primeiro):");
        System.out.println("Removendo o maior valor (último): ");


        System.out.println("\n=== Exibição Final da Àrvore ===");
        System.out.println(arvore.toString());


        System.err.println();
        System.out.println("=== Valores da Arvore imprimidos em Pré-Ordem ===");
        arvore.imprimirPreOrdem();

        System.out.println("\n\n=== Valores da Arvore imprimidos Em-Ordem ===");
        arvore.imprimirEmOrdem();

        System.out.println("\n\n=== Valores da Arvore imprimidos Pós-Ordem ===");
        arvore.imprimirPosOrdem();
    }    
}