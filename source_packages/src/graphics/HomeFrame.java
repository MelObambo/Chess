package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Home");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JLabel label = new JLabel(
        "Bonjour ! Voulez-vous commencer une partie ? J'espère pour vous que vous êtes meilleur que votre ami !"
        );
        JButton playButton = new JButton("Play");
        frame.add(label);
        frame.add(playButton);
        frame.setVisible(true);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
