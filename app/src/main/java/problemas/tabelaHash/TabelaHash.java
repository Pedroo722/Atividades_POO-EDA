package main.java.problemas.tabelaHash;

public class TabelaHash {
    private Aluno[] tabela;
    private int tamanho;
    private int contadorElementos;

    public TabelaHash(int tamanho) {
        tabela = new Aluno[tamanho];
        this.tamanho = tamanho;
        this.contadorElementos = 0;
    }

    public Aluno[] getLista() {
        return tabela;
    }

    private int calcularHash(Integer matricula) {
        return matricula % tabela.length;
    }

    public void redimensionar() {
        Aluno[] antigaTabela = this.tabela;
        int novoTamanho = tamanho * 2; 
        this.tabela = new Aluno[novoTamanho];
        this.tamanho = novoTamanho;
        this.contadorElementos = 0; 

        for (Aluno aluno : antigaTabela) {
            if (aluno != null && aluno != Aluno.REMOVIDO) {
                inserirValor(aluno);
            }
        }
    }

    public String pegarValor(int matricula) {
        int index = calcularHash(matricula);
        int startIndex = index;
        while (tabela[index] != null) {
            if (tabela[index].getMatricula().equals(matricula)) {
                return tabela[index].getNome();
            }
            index = (index + 1) % tamanho;
            if (index == startIndex) {
                break;
            }
        }
        return "Vazio";
    }

    public void inserirValor(Aluno aluno) {
        if (contadorElementos >= tamanho) {
            redimensionar();
        }

        int index = calcularHash(aluno.getMatricula());
        while (tabela[index] != null && tabela[index] != Aluno.REMOVIDO) {
            index = (index + 1) % tamanho;
        }
        
        tabela[index] = aluno;
        contadorElementos++;
    }

    public void removerValor(int matricula) {
        int index = calcularHash(matricula);
        int startIndex = index;
        while (tabela[index] != null) {
            if (tabela[index].getMatricula().equals(matricula)) {
                tabela[index] = Aluno.REMOVIDO;
                contadorElementos--;
                return;
            }
            index = (index + 1) % tamanho;
            if (index == startIndex) {
                break;
            }
        }
    }

    public String imprimirTabela() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tabela.length; i++) {
            sb.append("Índice ").append(i).append(": ");
            if (tabela[i] != null) {
                if (tabela[i] == Aluno.REMOVIDO) {
                    sb.append("REMOVIDO.");
                } else {
                    sb.append(tabela[i].getNome());
                }
            } else {
                sb.append("Vazio.");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
