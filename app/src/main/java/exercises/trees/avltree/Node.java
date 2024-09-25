package exercises.trees.avltree;


public class Node {
    int valor;
    Node esquerda;
    Node direita;
    Node pai;

    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    String toStringHelper(String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(isTail ? "└── " : "├── ");
        sb.append(valor).append("\n");

        if (esquerda != null) {
            sb.append(esquerda.toStringHelper(prefix + (isTail ? "    " : "│   "), direita == null));
        } else {
            sb.append(prefix).append(isTail ? "    └── vazio\n" : "│   ├── vazio\n");
        }

        if (direita != null) {
            sb.append(direita.toStringHelper(prefix + (isTail ? "    " : "│   "), true));
        } else {
            sb.append(prefix).append(isTail ? "    └── vazio\n" : "│   └── vazio\n");
        }

        return sb.toString();
    }
}
