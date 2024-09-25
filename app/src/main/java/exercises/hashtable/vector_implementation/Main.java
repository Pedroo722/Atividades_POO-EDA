package exercises.hashtable.vector_implementation;

public class Main {
    public static void main(String[] args) {
         HashTable tabelaHash = new HashTable(10);

         tabelaHash.inserirValor(new Aluno(13, "Enzo"));
         tabelaHash.inserirValor(new Aluno(123, "Thiago"));
         tabelaHash.inserirValor(new Aluno(422, "Vinicius"));
         tabelaHash.inserirValor(new Aluno(689, "Raykkoner"));
         tabelaHash.inserirValor(new Aluno(122, "Joao"));
         tabelaHash.inserirValor(new Aluno(34, "Daniel"));
         tabelaHash.inserirValor(new Aluno(89, "Alan"));
         tabelaHash.inserirValor(new Aluno(9, "Eduardo"));
         tabelaHash.inserirValor(new Aluno(68, "Vitoria"));
         tabelaHash.inserirValor(new Aluno(789, "Cleiton"));

         System.out.println("=== Tabela Hash após inserções ===");
         System.out.println(tabelaHash.imprimirTabela());


         tabelaHash.inserirValor(new Aluno(7, "Emerson"));
         tabelaHash.inserirValor(new Aluno(27, "Cleverson"));
         tabelaHash.inserirValor(new Aluno(47, "Jefferson"));
         tabelaHash.inserirValor(new Aluno(67, "Diego"));
         System.out.println("=== Tabela Hash após adicionar alunos e redimensionar ===");
         System.out.println(tabelaHash.imprimirTabela());

         tabelaHash.removerValor(89);
         System.out.println("=== Tabela Hash após remorção ===");
         System.out.println(tabelaHash.imprimirTabela());
    }
}