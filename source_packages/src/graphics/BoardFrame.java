package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardFrame {

    public static void main(String[] args) {
        int size = 0;

        JFrame frame = new JFrame("Home");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        if(toolkit.getScreenSize().width > toolkit.getScreenSize().height)
            size = toolkit.getScreenSize().height/8;
        else
            size = toolkit.getScreenSize().width;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                // Square square = new Square
            }
        }
        JButton play = new JButton("Play");
        frame.add(play);
        frame.setVisible(true);
    }
}
