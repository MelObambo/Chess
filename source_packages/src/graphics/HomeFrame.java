package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Home");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JButton play = new JButton("Play");
        frame.add(play);
        frame.setVisible(true);

        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
