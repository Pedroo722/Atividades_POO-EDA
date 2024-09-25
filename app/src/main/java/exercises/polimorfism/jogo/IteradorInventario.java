package exercises.polimorfism.jogo;

import java.util.Iterator;

public class IteradorInventario implements Iterator<ItemJogo> {
    private Inventario inventario;
    private int indexcurrent = 0;

    public IteradorInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public boolean hasNext() {
        return indexcurrent < this.inventario.getTamanho();
    }

    @Override
    public ItemJogo next() {
        return this.inventario.getItem(indexcurrent++);
    }
}