package exercises.hashtable.array_implementation;

public class Main {
    public static void main(String[] args) {
         HashTable tabelaHash = new HashTable(10);

         tabelaHash.inserirValor(new Aluno(122, "Enzo"));
         tabelaHash.inserirValor(new Aluno(123, "Thiago"));
         tabelaHash.inserirValor(new Aluno(422, "Vinicius"));
         tabelaHash.inserirValor(new Aluno(789, "Raykkoner"));

         System.out.println("=== Tabela Hash após inserções ===");
         System.out.println(tabelaHash.imprimirTabela());
         System.out.println("\nAluno com matrícula 422: " + tabelaHash.pegarValor(422));

         tabelaHash.removerValor(422);

         System.out.println("=== Tabela Hash após remoção ===");
         System.out.println(tabelaHash.imprimirTabela());
    }
}