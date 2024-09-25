package exercises.trees.btree;

public class BTree {
    private Node raiz; 
    private int ordem;

    public BTree(int ordem) {
        this.raiz = new Node(true); 
        this.ordem = ordem;         
    }

    // Inserção

    public void insert(int key) {
        Node r = raiz;

        if (r.isFull()) {
            Node s = new Node(false); 
            raiz = s;
            s.addChild(r);            

            splitChild(s, 0, r);

            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.getKeys().size() - 1;
    
        if (node.isLeaf()) {
            node.addKey(key); 
        } else {
            while (i >= 0 && key < node.getKeys().get(i)) {
                i--;
            }
            i++;
    
            Node child = node.getChildren().get(i);
            if (child.isFull()) {
                splitChild(node, i, child);
                if (key > node.getKeys().get(i)) {
                    i++;
                }
            }
            insertNonFull(node.getChildren().get(i), key);
        }
    }
    

    private void splitChild(Node parent, int i, Node fullChild) {
        int t = (ordem + 1) / 2;
    
        Node newNode = new Node(fullChild.isLeaf()); 
        parent.getChildren().add(i + 1, newNode); 
    
        for (int j = 0; j < t - 1; j++) {
            newNode.getKeys().add(fullChild.getKeys().remove(t));
        }
    
        if (!fullChild.isLeaf()) {
            for (int j = 0; j < t; j++) {
                newNode.getChildren().add(fullChild.getChildren().remove(t));
            }
        }
    
        parent.getKeys().add(i, fullChild.getKeys().remove(t - 1));
    }

    // Pesquisa

    public Node search(int key) {
        return search(raiz, key);
    }
    
    private Node search(Node node, int key) {
        int i = 0;
        while (i < node.getKeys().size() && key > node.getKeys().get(i)) {
            i++;
        }
    
        if (i < node.getKeys().size() && key == node.getKeys().get(i)) {
            return node; 
        } else if (node.isLeaf()) {
            return null; 
        } else {
            return search(node.getChildren().get(i), key); 
        }
    }

    // Remorção

    public void remove(int key) {
    
    }

    // Apresentação
    
    public void printTree() {
        printTree(raiz, "", true);
    }
    
    private void printTree(Node node, String indent, boolean last) {
        System.out.print(indent);
        if (last) {
            System.out.print("└── ");
            indent += "    ";
        } else {
            System.out.print("├── ");
            indent += "|   ";
        }
    
        System.out.println(node.getKeys());
    
        for (int i = 0; i < node.getChildren().size(); i++) {
            printTree(node.getChildren().get(i), indent, i == node.getChildren().size() - 1);
        }
    }    
}
