package exercises.gui_swing;

import javax.swing.*;

public class OtherWindow extends JFrame {
    public OtherWindow() {
        setTitle("Outra janela");
        setSize(300, 200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        add(new JLabel("Texto"));
        setVisible(true);
    }
}