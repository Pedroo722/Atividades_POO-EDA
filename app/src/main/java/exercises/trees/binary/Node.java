package exercises.trees.binary;


public class Node {
    int valor;
    Node filhoEsquerdo;
    Node filhoDireito;

    Node(int valor) {
        this.valor = valor;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }

    public void adicionarValor(int novoValor) {
        if (novoValor > valor) {
            if (filhoDireito == null) {
                filhoDireito = new Node(novoValor);
            } else {
                filhoDireito.adicionarValor(novoValor);
            }
        } else if (novoValor < valor) {
            if (filhoEsquerdo == null) {
                filhoEsquerdo = new Node(novoValor);
            } else {
                filhoEsquerdo.adicionarValor(novoValor);
            }
        }
    }

    public Node removerPrimeiro() {
        if (filhoEsquerdo == null) {
            return filhoDireito;
        } else {
            filhoEsquerdo = filhoEsquerdo.removerPrimeiro();
            return this;
        }
    }

    public Node removerUltimo() {
        if (filhoDireito == null) {
            return filhoEsquerdo;
        } else {
            filhoDireito = filhoDireito.removerUltimo();
            return this;
        }
    }

    public boolean buscarValor(int valorBuscado) {
        if (valorBuscado == valor) {
            return true;
        } else if (valorBuscado < valor && filhoEsquerdo != null) {
            return filhoEsquerdo.buscarValor(valorBuscado);
        } else if (valorBuscado > valor && filhoDireito != null) {
            return filhoDireito.buscarValor(valorBuscado);
        }
        return false;
    }

    String toStringHelper(String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(isTail ? "└── " : "├── ");
        sb.append(valor).append("\n");

        if (filhoEsquerdo != null) {
            sb.append(filhoEsquerdo.toStringHelper(prefix + (isTail ? "    " : "│   "), filhoDireito == null));
        } else {
            sb.append(prefix).append(isTail ? "    └── vazio\n" : "│   ├── vazio\n");
        }

        if (filhoDireito != null) {
            sb.append(filhoDireito.toStringHelper(prefix + (isTail ? "    " : "│   "), true));
        } else {
            sb.append(prefix).append(isTail ? "    └── vazio\n" : "│   └── vazio\n");
        }

        return sb.toString();
    }
}