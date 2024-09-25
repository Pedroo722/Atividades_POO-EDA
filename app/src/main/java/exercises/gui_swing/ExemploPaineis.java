package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploPaineis extends JFrame {
    JButton button1;
    JButton button2;
    public ExemploPaineis() {
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        JLabel label1 = new JLabel("Nome");
        JLabel label2 = new JLabel("Sobrenome");
        ImageIcon icone = new ImageIcon("checked.png");
        button1 = new JButton("Ok");
        button2 = new JButton("Cancelar");
        button1.setIcon(icone);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painel3.setVisible(!painel3.isVisible());
            }
        });
        button2.addActionListener(e -> {
            System.out.println("Botão Cancelar clicado");
        });
        painel1.setBackground(new Color(0xFFC6F9BF, true));
        painel1.setBounds(0, 0, 100, 100);
        painel2.setBackground(new Color(0xFF9BC8FF, true));
        painel2.setBounds(100, 0, 100, 100);
        painel3.setBackground(new Color(0xFFFF9BA3, true));
        painel3.setBounds(0, 100, 100, 100);

        painel1.add(label1);
        painel1.add(label2);
        painel2.add(button1);
        painel2.add(button2);

        add(painel1);
        add(painel2);
        add(painel3);

        setTitle("Exemplo paineis");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploPaineis();
    }
}