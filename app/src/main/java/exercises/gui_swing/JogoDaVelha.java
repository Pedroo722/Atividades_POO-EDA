package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelha extends JFrame {
    private JButton[] buttons;
    private char currentPlayer;

    public JogoDaVelha() {
        setTitle("Jogo da Velha");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buttons = new JButton[9];
        currentPlayer = 'X';

        inicializarButtons();
        setLayout(new GridLayout(3, 3));
        setVisible(true);
    }

    private void inicializarButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 48));
            add(buttons[i]);
            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonClick(finalI);
                }
            });
        }
    }

    private void buttonClick(int index) {
        if (buttons[index].getText().equals("")) {
            buttons[index].setText(String.valueOf(currentPlayer));
            if (checarVitoria()) {
                JOptionPane.showMessageDialog(this, "Jogador " + currentPlayer + " venceu!");
                resetGame();
            } else if (isEmpate()) {
                JOptionPane.showMessageDialog(this, "Empate!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checarVitoria() {
        // Verificar linhas, colunas e diagonais para uma vitória
        return (checarLinhas() || checarColunas() || checarDiagonais());
    }

    private boolean checarLinhas() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i * 3].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i * 3 + 1].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i * 3 + 2].getText().equals(String.valueOf(currentPlayer)) ) {
                return true;
            }
        }
        return false;
    }

    private boolean checarColunas() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i + 3].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i + 6].getText().equals(String.valueOf(currentPlayer)) ) {
                return true;
            }
        }
        return false;
    }

    private boolean checarDiagonais() {
        return (buttons[0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[4].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[8].getText().equals(String.valueOf(currentPlayer)) ) ||
               (buttons[2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[4].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[6].getText().equals(String.valueOf(currentPlayer)));
    }

    private boolean isEmpate() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
