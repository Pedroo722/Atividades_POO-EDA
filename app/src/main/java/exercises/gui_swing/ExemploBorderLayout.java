package exercises.gui_swing;

import javax.swing.*;
import java.awt.*;

public class ExemploBorderLayout extends JFrame {
    public ExemploBorderLayout() {
        setTitle("Exemplo paineis");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel1 = new JPanel();
        painel1.setBackground(new Color(0xE52F2F));
        JPanel painel2 = new JPanel();
        painel2.setBackground(new Color(0x2F41E5));
        JPanel painel3 = new JPanel();
        painel3.setBackground(new Color(0x2FE5C4));
        JPanel painel4 = new JPanel();
        painel4.setBackground(new Color(0xE5CD2F));
        JPanel painel5 = new JPanel();
        painel5.setBackground(new Color(0xE5992F));

        painel1.setPreferredSize(new Dimension(50, 50));
        painel2.setPreferredSize(new Dimension(50, 50));
        painel3.setPreferredSize(new Dimension(50, 50));
        painel4.setPreferredSize(new Dimension(50, 50));
        painel5.setPreferredSize(new Dimension(50, 50));

        add(painel1, BorderLayout.PAGE_START);
        add(painel2, BorderLayout.PAGE_END);
        add(painel3, BorderLayout.LINE_START);
        add(painel4, BorderLayout.LINE_END);
        add(painel5, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploBorderLayout();
    }
}