package exercises.polimorfism.stack;

import java.util.ArrayList;

public class Pilha implements Stack {
    private int tamanho;
    private ArrayList<String> listaDeItens;

    public Pilha(int tamanho) {
        this.listaDeItens = new ArrayList<>(tamanho);
        this.tamanho = tamanho;
    }

    public Pilha() {
        this.listaDeItens = new ArrayList<>();
        this.tamanho = 10;
    }

    @Override
    public void push(String item) {
        this.listaDeItens.add(item);
    
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            return this.listaDeItens.remove(listaDeItens.size() - 1);
        } else {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
    }


    @Override
    public String peek() {
        if (!isEmpty()) {
            int tamanho = this.listaDeItens.size();
            if (tamanho >= 10) {
                return this.listaDeItens.get(9); // O 9 é igual ao 10-iesimo elemento da lista
            } else {
                return this.listaDeItens.get(tamanho - 1);
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return listaDeItens.isEmpty();
    }

    @Override
    public boolean isFull() {
        if (listaDeItens.size() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder apresentacao = new StringBuilder();

        for (String item : listaDeItens) {
            apresentacao.append(item).append(", ");
        }

        return apresentacao.toString();
    }

    public int getTamanho() {
        return tamanho;
    }
}


// Exceção

class PilhaVaziaException extends RuntimeException {
    public PilhaVaziaException(String message) {
        super(message);
    }
}

class PilhaCheiaException extends RuntimeException {
    public PilhaCheiaException(String message) {
        super(message);
    }
}