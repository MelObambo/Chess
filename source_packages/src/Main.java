import graphics.BoardFrame;
import graphics.HomeFrame;
import models.Board;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeFrame::new);
        SwingUtilities.invokeLater(BoardFrame::new);
    }
}