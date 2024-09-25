Atividade extra para a disciplina de Programação Orientada a Objetos

# Exercícios

## Exercício 1
Implemente a interface Stack, que define o contrato de uma estrutura de dados chamada pilha.

```java
public interface Stack {
  void push(String item);   // insere um item no topo
  String pop();             // remove um item do topo
  String peek();            // retorna um item do topo sem removê-lo
  boolean isEmpty();        // determina se a pilha está vazia
  boolean isFull();         // determina se a pilha está cheia
  String toString();        // retorna a representação da pilha em String
}
```

## Exercício 2
Implemente uma classe Inventario (implementa interface InventarioIF abaixo) que armazena itens encontrados pelo jogador durante o jogo. Além disso, implemente a interface Iterable e, consequentemente, implemente seu próprio Iterator.

```java
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
```
