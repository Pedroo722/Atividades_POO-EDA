package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;

public class ExemploComponentes extends JFrame {
    public ExemploComponentes() {
        setTitle("Minha janela");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setResizable(false);

        JLabel jlNome = new JLabel("Nome");
        ImageIcon icone = new ImageIcon("checked.png");
        jlNome.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        jlNome.setForeground(new Color(0xCB5F5F));
        jlNome.setBackground(new Color(0xE0E0FF));
        jlNome.setIcon(icone);
        jlNome.setOpaque(true);
        jlNome.setVerticalAlignment(SwingConstants.TOP);
        add(jlNome);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploComponentes();
    }
}