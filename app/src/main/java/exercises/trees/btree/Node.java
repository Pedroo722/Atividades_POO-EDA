package exercises.trees.btree;

import java.util.*;

public class Node {
    private List<Integer> keys;  
    private List<Node> children; 
    private boolean isLeaf;      

    public Node(boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public void setKeys(List<Integer> keys) {
        this.keys = keys;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void addKey(int key) {
        keys.add(key);
        keys.sort(Integer::compareTo);
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public boolean isFull() {
        return keys.size() == 3;  
    }
}
