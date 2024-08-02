package main.java.problemas.arvore;

public class Arvore {
    Node raiz;

    Arvore(int valor) {
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

    @Override
    public String toString() {
        return raiz.toStringHelper("", true);
    }
}
