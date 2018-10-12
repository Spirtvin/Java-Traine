package Helpers;

import javax.swing.*;
import java.awt.*;

public class Forms {

    public JFrame Create(Container panel, String title) {
        JFrame frame = new JFrame(title);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public void Show(JFrame frame) {
        frame.pack();
        frame.setVisible(true);
    }
}
