package exercises.polimorfism.jogo;


import java.util.List;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.Spliterator;

public interface InventarioIF extends Iterable<ItemJogo> {
    int getTamanho();
    void setTamanho(int tamanho);
    void adicionarItem(ItemJogo item) throws InventarioCheioException;

    void removerItem(int indice);

    boolean contemItem(ItemJogo item);

    List<ItemJogo> getInventario();

    @Override
    Iterator<ItemJogo> iterator();

    // Não é necessário implementar o método forEach
    // Deixe o corpo do método vazio
    @Override
    void forEach(Consumer<? super ItemJogo> action);

    // Não é necessário implementar o método spliterator
    // Deixe o corpo do método vazio e retorne null
    @Override
    Spliterator<ItemJogo> spliterator();
}