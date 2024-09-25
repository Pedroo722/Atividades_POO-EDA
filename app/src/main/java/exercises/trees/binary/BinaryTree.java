package exercises.trees.binary;

public class BinaryTree {
    Node raiz;

    BinaryTree(int valor) {
        this.raiz = new Node(valor);
    }

    public void adicionarValor(int valor) {
        raiz.adicionarValor(valor);
    }

    public void removerPrimeiro() {
        if (raiz != null) {
            raiz = raiz.removerPrimeiro();
        }
    }

    public void removerUltimo() {
        if (raiz != null) {
            raiz = raiz.removerUltimo();
        }
    }

    public boolean buscarValor(int valor) {
        if (raiz == null) {
            return false;
        }
        return raiz.buscarValor(valor);
    }


    @Override
    public String toString() {
        return raiz.toStringHelper("", true);
    }

    public void imprimirPreOrdem() {
        imprimirPreOrdem(raiz);
    }

    private void imprimirPreOrdem(Node node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            imprimirPreOrdem(node.filhoEsquerdo);
            imprimirPreOrdem(node.filhoDireito);
        }
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
    }

    private void imprimirEmOrdem(Node node) {
        if (node != null) {
            imprimirEmOrdem(node.filhoEsquerdo);
            System.out.print(node.valor + " ");
            imprimirEmOrdem(node.filhoDireito);
        }
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdem(raiz);
    }

    private void imprimirPosOrdem(Node node) {
        if (node != null) {
            imprimirPosOrdem(node.filhoEsquerdo);
            imprimirPosOrdem(node.filhoDireito);
            System.out.print(node.valor + " ");
        }
    }
}
