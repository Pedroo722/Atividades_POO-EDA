package exercises.polimorfism.jogo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Inventario implements InventarioIF {
    private int tamanho;
    private List<ItemJogo> inventario;

    public Inventario() {
        this.tamanho = 0;
        this.inventario = new ArrayList<>();
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void adicionarItem(ItemJogo item) throws InventarioCheioException {
        if (tamanho == inventario.size()) {
            throw new InventarioCheioException();
        }
        inventario.add(item);
    }

    @Override
    public void removerItem(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            inventario.remove(indice);
        }
    }

    @Override
    public boolean contemItem(ItemJogo item) {
        return inventario.contains(item);
    }

    @Override
    public List<ItemJogo> getInventario() {
        return inventario;
    }

    @Override
    public Iterator<ItemJogo> iterator() {
        return new IteradorInventario(this);
    }

    @Override
    public void forEach(Consumer<? super ItemJogo> action) {
        inventario.forEach(action);
    }

    @Override
    public Spliterator<ItemJogo> spliterator() {
        return inventario.spliterator();
    }

    public ItemJogo getItem(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            return inventario.get(indice);
        }
        return null;
    }
}
