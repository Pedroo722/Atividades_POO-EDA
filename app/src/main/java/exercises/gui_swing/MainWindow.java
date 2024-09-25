package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private OtherWindow other;
    public MainWindow() {

        setTitle("Minha primeira janela");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
//        setContentPane(formPanel);
        setLocationRelativeTo(null);
        JButton button = new JButton("1");
        button.addActionListener(e -> {
            if (other == null || !other.isVisible()) {
                other = new OtherWindow();
            }
        });
        add(button);
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}