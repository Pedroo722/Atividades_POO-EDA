package exercises.trees.avltree;

public class AVLTree {
    Node raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        Node novoNode = new Node(valor);
        if (raiz == null) {
            raiz = novoNode;
        } else {
            inserir(novoNode, raiz);
        }
        balancear(raiz);
    }

    private void inserir(Node novoNode, Node pai) {
        if (novoNode.valor < pai.valor) {
            if (pai.esquerda == null) {
                pai.esquerda = novoNode;
                novoNode.pai = pai;
            } else {
                inserir(novoNode, pai.esquerda);
            }
        } else if (novoNode.valor > pai.valor) {
            if (pai.direita == null) {
                pai.direita = novoNode;
                novoNode.pai = pai;
            } else {
                inserir(novoNode, pai.direita);
            }
        }
        balancear(pai);
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private Node remover(Node node, int valor) {
        if (node == null) {
            return node;
        }

        if (valor < node.valor) {
            node.esquerda = remover(node.esquerda, valor);
        } else if (valor > node.valor) {
            node.direita = remover(node.direita, valor);
        } else {
            if (node.esquerda == null || node.direita == null) {
                Node temp = (node.esquerda != null) ? node.esquerda : node.direita;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = obterMenorValor(node.direita);
                node.valor = temp.valor;
                node.direita = remover(node.direita, temp.valor);
            }
        }

        if (node == null) {
            return node;
        }

        balancear(node);
        return node;
    }

    private Node obterMenorValor(Node node) {
        Node atual = node;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void removerPrimeiro() {
        if (raiz != null) {
            raiz = removerPrimeiro(raiz, null);
        }
    }

    public Node removerPrimeiro(Node node, Node pai) {
        if (node.esquerda == null) {
            if (pai != null) {
                pai.esquerda = node.direita;
            } else {
                raiz = node.direita;
            }
            return node.direita;
        }
        node.esquerda = removerPrimeiro(node.esquerda, node);
        balancear(node);
        return node;
    }

    public void removerUltimo() {
        if (raiz != null) {
            raiz = removerUltimo(raiz, null);
        }
    }

    public Node removerUltimo(Node node, Node pai) {
        if (node.direita == null) {
            if (pai != null) {
                pai.direita = node.esquerda;
            } else {
                raiz = node.esquerda;
            }
            return node.esquerda;
        }
        node.direita = removerUltimo(node.direita, node);
        balancear(node);
        return node;
    }

    public int calcularAltura(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(calcularAltura(node.esquerda), calcularAltura(node.direita));
    }

    public int calcularFatorDeBalanceamento(Node node) {
        if (node == null) {
            return 0;
        }
        return calcularAltura(node.esquerda) - calcularAltura(node.direita);
    }

    private void rotacaoADireita(Node node) {
        Node novaRaiz = node.esquerda;
        node.esquerda = novaRaiz.direita;
        if (node.esquerda != null) {
            node.esquerda.pai = node;
        }
        novaRaiz.pai = node.pai;
        if (node.pai == null) {
            raiz = novaRaiz;
        } else if (node == node.pai.esquerda) {
            node.pai.esquerda = novaRaiz;
        } else {
            node.pai.direita = novaRaiz;
        }
        novaRaiz.direita = node;
        node.pai = novaRaiz;
    }

    private void rotacaoAEsquerda(Node node) {
        Node novaRaiz = node.direita;
        node.direita = novaRaiz.esquerda;
        if (node.direita != null) {
            node.direita.pai = node;
        }
        novaRaiz.pai = node.pai;
        if (node.pai == null) {
            raiz = novaRaiz;
        } else if (node == node.pai.direita) {
            node.pai.direita = novaRaiz;
        } else {
            node.pai.esquerda = novaRaiz;
        }
        novaRaiz.esquerda = node;
        node.pai = novaRaiz;
    }

    private void balancear(Node node) {
        int fatorBalanceamento = calcularFatorDeBalanceamento(node);

        if (fatorBalanceamento > 1) {
            if (calcularFatorDeBalanceamento(node.esquerda) < 0) {
                rotacaoAEsquerda(node.esquerda);
            }
            rotacaoADireita(node);
        } else if (fatorBalanceamento < -1) {
            if (calcularFatorDeBalanceamento(node.direita) > 0) {
                rotacaoADireita(node.direita);
            }
            rotacaoAEsquerda(node);
        }
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
            imprimirPreOrdem(node.esquerda);
            imprimirPreOrdem(node.direita);
        }
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
    }

    private void imprimirEmOrdem(Node node) {
        if (node != null) {
            imprimirEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            imprimirEmOrdem(node.direita);
        }
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdem(raiz);
    }

    private void imprimirPosOrdem(Node node) {
        if (node != null) {
            imprimirPosOrdem(node.esquerda);
            imprimirPosOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }
}
