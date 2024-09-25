package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowLayout extends JFrame {
    public ExemploFlowLayout() {
        setTitle("Exemplo paineis");
        setSize(400, 300);
        setLayout(new GridLayout(2, 4));
//        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        JButton button = new JButton("8");
        button.addActionListener(e -> {
            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        add(button);
//        add(new JButton("9"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploFlowLayout();
    }
}