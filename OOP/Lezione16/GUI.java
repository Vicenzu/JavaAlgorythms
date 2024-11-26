package Lezione16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Pippo");
        JToolBar toolBar = new JToolBar();
        JButton b1 = new JButton("Bestemmia 1");
        JButton b2 = new JButton("Bestemmia 2");
        toolBar.add(b1);
        toolBar.add(b2);

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 400));
        b1.addActionListener((e) -> textArea.append("Porcoddio\n"));
        b2.addActionListener((e) -> textArea.append("Porcamadonnaccia\n"));

        f.add(toolBar, BorderLayout.NORTH);
        f.add(new JScrollPane(textArea), BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }
}
