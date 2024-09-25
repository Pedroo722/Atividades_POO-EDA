package exercises.hashtable.array_implementation;

import java.util.*;

public class HashTable {
    private ArrayList<LinkedList> tabela;

    public HashTable(Integer tamanho) {
        tabela = new ArrayList<>();
        for (Integer i = 0; i < tamanho; i++) {
            tabela.add(new LinkedList());
        }
    }

    private int calcularHash(Integer matricula) {
        return matricula % this.tabela.size();
    }
    
    public String pegarValor(int matricula) {
        int index = calcularHash(matricula);
        return tabela.get(index).getAluno(matricula).getNome();
    }

    public void inserirValor(Aluno aluno) {
        int index = calcularHash(aluno.getMatricula());
        tabela.get(index).adicionar(aluno);
    }

    public void removerValor(int matricula) {
        int index = calcularHash(matricula);
        Aluno alunoARemover = tabela.get(index).getAluno(matricula);

        System.out.println("\nAluno a ser removido: " + alunoARemover.getNome() + "\n");

        Node current = tabela.get(index).head;

        while (current != null) {
            if (current.getAluno().getMatricula() == matricula) {
                tabela.get(index).remove(alunoARemover);
            }
            current = current.next;
        }
    }

     public String imprimirTabela() {
         StringBuilder sb = new StringBuilder();
    
         for (int i = 0; i < tabela.size(); i++) {
             sb.append("Índice ").append(i).append(": ");
    
             LinkedList lista = tabela.get(i);
             Node current = lista.head;
    
             while (current != null) {
                 sb.append(current.getAluno().toString()).append(" -> ");
                 current = current.next;
             }
    
             sb.append("null\n");
         }
    
         return sb.toString();
     }
}

