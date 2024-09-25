package exercises.gui_swing;

public interface Jogo {
    void inicializarButtons(); // ininiciar os butões

    void buttonClick(int i); // Evento de Clicar, coloca um X ou 0 no botão baseado no turno

    boolean checarVitoria(); // Chama as 3 funções abaixo e checa se houve uma vitória

    boolean checarLinhas(); // Checa vitoria nas linhas
    boolean checkDiagonals(); // Checa vitoria nas diagonais
    boolean checarColunas(); // Checa vitoria nas colunas

    boolean isEmpate(); // Checa se todas as posições foram preenchidas, se sim houve um empate

    void resetGame(); // Resetar os quadrados quando acabar o jogo, para jogar novamente 
}