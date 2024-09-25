package exercises.trees.rbtree;

public class RBTree {
    protected Node raiz;
    static final boolean VERMELHO = false;
    static final boolean PRETO = true;
  
    public RBTree(Node raiz) {
        this.raiz = raiz;
    }


    private static class NilNode extends Node {
      private NilNode() {
        super(0);
        this.cor = PRETO;
      }
    }

    // Metodos de Pesquisa e Getters

    public Node searchNode(int chave) {
      Node node = raiz;
      while (node != null) {
        if (chave == node.getValor()) {
          return node;
        } else if (chave < node.getValor()) {
          node = node.getEsquerda();
        } else {
          node = node.getDireita();
        }
      }
  
      return null;
    }

    public Node getRaiz() {
        return raiz;
    }

    private boolean isPRETO(Node node) {
        // Nodo nulls são considerados pretos
        return node == null || node.cor == PRETO;
    }
    
    private Node getSibling(Node node) {
        if (node == node.getPai().getEsquerda()) {
          return node.getPai().getDireita();
        } else if (node == node.getPai().getDireita()) {
          return node.getPai().getEsquerda();
        } else {
          throw new IllegalStateException("O nodo não é filho de seu pai");
        }
    }

    private Node getUncle(Node parent) {
      Node grandparent = parent.getPai();
      if (grandparent.getEsquerda() == parent) {
        return grandparent.getDireita();
      } else if (grandparent.getDireita() == parent) {
        return grandparent.getEsquerda();
      } else {
        throw new IllegalStateException("Pai não é um filho do Nodo Avo");
      }
  }

    private Node findMenorNode(Node node) {
      while (node.getEsquerda() != null) {
        node = node.getEsquerda();
      }
      return node;
    }

    // Metodos para Inserção

    public void insertNode(int chave) {
        Node node = raiz;
        Node parent = null;
    
        while (node != null) {
          parent = node;
          if (chave < node.getValor()) {
            node = node.getEsquerda();
          } else if (chave > node.getValor()) {
            node = node.getDireita();
          } else {
            throw new IllegalArgumentException("Árvore já contém um nodo com a chave: " + chave);
          }
        }
    
        Node newNode = new Node(chave);
        newNode.setCor(VERMELHO);
        if (parent == null) {
          raiz = newNode;
        } else if (chave < parent.getValor()) {
          parent.setEsquerda(newNode);
        } else {
          parent.setDireita(newNode);
        }
        newNode.setPai(parent);
    
        fixCoresAposInserir(newNode);
      }
    
    private void fixCoresAposInserir(Node node) {
        Node parent = node.getPai();
    
        // Caso 1: Pai é null, logo é a raiz
        // fim da recursão
        if (parent == null) {
          return;
        }
    
        if (parent.isCor() == PRETO) {
          return;
        }
    
        Node grandparent = parent.getPai();
    
        // Caso 2:
        // Se o pai do Nodo não tiver um pai, significa que o pai do Nodo é a raiz
        if (grandparent == null) {
          // Este método só vai ser chamado em Nodos vermelhos,
          // logo só precisamos colorir a raiz como preta.
          parent.setCor(PRETO);
          return;
        }
    
        Node uncle = getUncle(parent);
    
        // Caso 3: Se o tio for vermelho -> recolorir o pai, avô e tio
        if (uncle != null && uncle.isCor() == VERMELHO) {
          parent.setCor(PRETO);
          grandparent.setCor(VERMELHO);
          uncle.setCor(PRETO);

          fixCoresAposInserir(grandparent);
        }
    
        else if (parent == grandparent.getEsquerda()) {
          // Caso 4a: Tio é preto e o nodo é filho "interno" esquerdo-direito do avô
          if (node == parent.getDireita()) {
            rotacionarEsquerda(parent);
    
            // Deixa "parent" apontar para o novo nodo raiz da subárvore rotacionada.
            // Ele será recolorido no próximo passo, que vamos continuar.
            parent = node;
          }
    
          // Caso 5a: Tio é preto e o nodo é filho "externo" esquerdo-esquerdo do avô
          rotacionarDireita(grandparent);
    
          // Recolore o pai original e o avô
          parent.setCor(PRETO);
          grandparent.setCor(VERMELHO);
        }
    
        // Pai é filho direito do avô
        else {
          // Caso 4b: Tio é preto e o nodo é filho "interno" direito-esquerdo do avô
          if (node == parent.getEsquerda()) {
            rotacionarDireita(parent);
    
            // Deixa "parent" apontar para o novo nodo raiz da subárvore rotacionada.
            // Ele será recolorido no próximo passo, que vamos continuar.
            parent = node;
          }
    
          // Caso 5b: Tio é preto e o nodo é filho "externo" direito-direito do avô
          rotacionarEsquerda(grandparent);
    
          // Recolore o pai original e o avô
          parent.setCor(PRETO);
          grandparent.setCor(VERMELHO);
        }
    }
      
    // Metodos para Remoção
    
    public void deleteNode(int chave) {
        Node node = raiz;
    
        // Encontra o nodo a ser removido
        while (node != null && node.getValor() != chave) {
          // Percorre a árvore para a esquerda ou direita, dependendo da chave
          if (chave < node.getValor()) {
            node = node.getEsquerda();
          } else {
            node = node.getDireita();
          }
        }
    
        // Nodo não encontrado
        if (node == null) {
          return;
        }
    
        // a partir de aqui, variavel "node" é o nodo a ser removido
    
        // variável que armazenar o nodo no qual vamos começar a corrigir as
        // propriedades da árvore, após deletar um nodo.
        Node movedUpNode;
        boolean deletedNodeColor;
    
        // Nodo tem zero ou um filho
        if (node.getEsquerda() == null || node.getDireita() == null) {
          movedUpNode = deleteNodeWithZeroOrOneChild(node);
          deletedNodeColor = node.isCor();
        }
    
        // Nodo tem dois filhos
        else {
          // Encontra o nodo mínimo da subárvore direita
          // (sucessor em ordem do nodo atual)
          Node inOrderSuccessor = findMenorNode(node.getDireita());
    
          // Copia o valor do sucessor em ordem para o nodo atual
          // (mantém sua cor!)
          node.setValor(inOrderSuccessor.getValor());
    
          // Deleta o sucessor em ordem
          // da mesma forma que deletaria um nodo com 0 ou 1 filho
          movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
          deletedNodeColor = inOrderSuccessor.isCor();
        }
    
        if (deletedNodeColor == PRETO) {
          fixCoresAposRemover(movedUpNode);
    
          // Remove o nodo NIL temporário
          if (movedUpNode.getClass() == NilNode.class) {
            replaceParentsChild(movedUpNode.getPai(), movedUpNode, null);
          }
        }
    }
    
    private Node deleteNodeWithZeroOrOneChild(Node node) {
        if (node.getEsquerda() != null) {
          replaceParentsChild(node.getPai(), node, node.getEsquerda());
          return node.getEsquerda(); // nodo movido para cima
        }
    
        else if (node.getDireita() != null) {
          replaceParentsChild(node.getPai(), node, node.getDireita());
          return node.getDireita(); // nodo movido para cima
        }
    
        else {
          Node newChild = node.isCor() == PRETO ? new NilNode() : null;
          replaceParentsChild(node.getPai(), node, newChild);
          return newChild;
        }
    }
    
    private void fixCoresAposRemover(Node node) {
        // Caso 1: Nodo é a raiz, fim da recursão
        if (node == raiz) {
          return;
        }
    
        Node sibling = getSibling(node);
    
        // Caso 2: Irmão vermelho
        if (sibling.isCor() == VERMELHO) {
          handleIrmaoVermelho(node, sibling);
          sibling = getSibling(node); // Obtém o novo irmão para continuar nos casos 3-6
        }
    
        // Casos 3+4: Irmão preto com dois filhos pretos
        if (isPRETO(sibling.getEsquerda()) && isPRETO(sibling.getDireita())) {
          sibling.setCor(VERMELHO);
    
          // Caso 3: Irmão preto com dois filhos pretos + pai vermelho
          if (node.getPai().isCor() == VERMELHO) {
            node.getPai().setCor(PRETO);
          }
    
          // Caso 4: Irmão preto com dois filhos pretos + pai preto
          else {
            fixCoresAposRemover(node.getPai());
          }
        }
    
        // Caso 5+6: Irmão preto com pelo menos um filho vermelho
        else {
          handlePRETOSiblingWithAtLeastOneVERMELHOChild(node, sibling);
        }
    }
    
    private void handleIrmaoVermelho(Node node, Node sibling) {
        sibling.setCor(PRETO);
        node.getPai().setCor(VERMELHO);
    
        if (node == node.getPai().getEsquerda()) {
          rotacionarEsquerda(node.getPai());
        } else {
          rotacionarDireita(node.getPai());
        }
    }
    
    private void handlePRETOSiblingWithAtLeastOneVERMELHOChild(Node node, Node sibling) {
        boolean nodeIsLeftChild = node == node.getPai().getEsquerda();
    
        // Caso 5: Irmão preto com filho "interno" vermelho distante
        if (nodeIsLeftChild && isPRETO(sibling.getDireita())) {
          sibling.getEsquerda().setCor(PRETO);
          sibling.setCor(VERMELHO);
          rotacionarDireita(sibling);
          sibling = node.getPai().getDireita();
        }
        else if (!nodeIsLeftChild && isPRETO(sibling.getEsquerda())) {
          sibling.getDireita().setCor(PRETO);
          sibling.setCor(VERMELHO);
          rotacionarEsquerda(sibling);
          sibling = node.getPai().getEsquerda();
        }
    
        // Caso 6: Irmão preto com filho "externo" vermelho distante
        sibling.setCor(node.getPai().isCor());
        node.getPai().setCor(PRETO);
    
        if (nodeIsLeftChild) {
          sibling.getDireita().setCor(PRETO);
          rotacionarEsquerda(node.getPai());
        } else {
          sibling.getEsquerda().setCor(PRETO);
          rotacionarDireita(node.getPai());
        }
    }
        
    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
          raiz = newChild;
        } else if (parent.getEsquerda() == oldChild) {
          parent.setEsquerda(newChild);
        } else if (parent.getDireita() == oldChild) {
          parent.setDireita(newChild);
        } else {
          throw new IllegalStateException("Nodo a ser substituído não é filho do pai");
        }
    
        if (newChild != null) {
          newChild.setPai(parent);
        }
    }
    
    // Metodo de Rotações
    
    private void rotacionarEsquerda(Node node) {
        Node newParent = node.getDireita();
        replaceParentsChild(node.getPai(), node, newParent);
        node.setDireita(newParent.getEsquerda());;
        if (newParent.getEsquerda() != null) {
          newParent.getEsquerda().setPai(node);
        }
        newParent.setEsquerda(node);
        node.setPai(newParent);
    }
    
    private void rotacionarDireita(Node node) {
        Node newParent = node.getEsquerda();
        replaceParentsChild(node.getPai(), node, newParent);
        node.setEsquerda(newParent.getDireita());
        if (newParent.getDireita() != null) {
          newParent.getDireita().setPai(node);
        }
        newParent.setDireita(node);
        node.setPai(newParent);
    }
    
    // Métodos para imprimir a árvore
    
    public void printTree(Node node, String indent, boolean last) {
        if (node != null) {
          System.out.print(indent);
          if (last) {
            System.out.print("└─");
            indent += "  ";
          } else {
            System.out.print("├─");
            indent += "│ ";
          }
    
          System.out.println(node.getValor() + "(" + (node.isCor() == VERMELHO ? "R" : "B") + ")");
    
          printTree(node.getEsquerda(), indent, false);
          printTree(node.getDireita(), indent, true);
        }
    }
}

