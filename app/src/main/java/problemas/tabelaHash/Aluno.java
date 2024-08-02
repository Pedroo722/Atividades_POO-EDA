package main.java.problemas.tabelaHash;

public class Aluno {
    private Integer matricula;
    private String nome;
    
    // Ja que a matricula não pode ser negativa
    // id = -1 marca que foi removido
    public static final Aluno REMOVIDO = new Aluno(-1, "REMOVIDO");

    public Aluno(Integer matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        if (nome == null) {
            return "Vazio";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                '}';
    }
}
