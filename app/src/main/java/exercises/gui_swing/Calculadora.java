package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField display;
    private double num1;
    private String operacao;
    private boolean novaOperacao = true;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField(10);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String botao : botoes) {
            JButton button = new JButton(botao);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            painelBotoes.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClick(e.getActionCommand());
                }
            });
        }

        add(painelBotoes, BorderLayout.CENTER);

        setVisible(true);
    }

    private void buttonClick(String command) {
        if (novaOperacao) {
            display.setText("");
            novaOperacao = false;
        }

        if (command.matches("[0-9.]")) {
            display.setText(display.getText() + command);
        } else if (command.equals("=")) {
            calcular();
        } else {
            if (!operacao.isEmpty()) {
                return;
            }
            num1 = Double.parseDouble(display.getText());
            operacao = command;
            novaOperacao = true;
        }
    }

    private void calcular() {
        if (!operacao.isEmpty()) {
            double num2 = Double.parseDouble(display.getText());
            double resultado = 0;

            switch (operacao) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        display.setText("Erro");
                        return;
                    }
                    break;
            }

            display.setText(Double.toString(resultado));
            operacao = "";
            novaOperacao = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora());
    }
}