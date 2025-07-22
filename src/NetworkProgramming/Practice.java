package NetworkProgramming;

import javax.swing.*;
import java.awt.*;

public class Practice extends JFrame {
    Practice() {
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Advance Java");
        setBounds(100, 100, 450, 300);
        JLabel lblNewLabel = new JLabel("Advance Java");
        add(lblNewLabel);
        JTextField textField = new JTextField("Advance Java");
        add(textField);

        Graphics2D gd = (Graphics2D) this.getGraphics();

    }

    public static void main(String[] args) {
        new Practice();
    }
}

