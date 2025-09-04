package graphics;

import models.Board;
import models.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class PieceButton extends JButton implements ActionListener {
    private final String position;
    private Piece piece;
    // As it is a reference and not the actual buttonMap calculated, it doesn't add much processing
    private Map<String, PieceButton> buttonMap;
    private static ArrayList<String> available = new ArrayList<>();
    private JFrame frame;
    private static PieceButton selectedPiece;
    private static Board logicalBoard;
    public BoardFrame boardFrame;

    protected void setPiece(Piece piece) {
        this.piece = piece;
        this.updateIcon();
    }

    protected Piece getPiece() {
        return this.piece;
    }

    public String getPosition() {
        return this.position;
    }

    private void updateIcon() {
        if (this.piece == null)
            setIcon(null);
        else {
            URL imgUrl = getClass().getResource("/resources/" + this.piece.getClass().getSimpleName().toLowerCase() + "_" + this.piece.getColour().name().toLowerCase() + ".png");
            ImageIcon icon = new ImageIcon(imgUrl);
            Image image = icon.getImage();
            Image resizedIcon = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(resizedIcon));
        }
    }

    private void resetSquareColour(String position) {
        Color darkSquare = new Color(255, 234, 230);
        Color lightSquare = new Color(250, 144, 120);

        int col = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));
        this.buttonMap.get(position).setBackground((col + row) % 2 == 0 ? lightSquare: darkSquare);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (available.isEmpty() && this.piece == null && selectedPiece == null)
            throw new IllegalArgumentException("Invalid action: empty square");


        if (available.isEmpty() && this.piece != null && this.piece.getColour() != this.boardFrame.getCurrentTurn())
            throw new IllegalArgumentException("Invalid action: other player's turn");

        if (available.isEmpty() && this.piece != null) {
            available = new ArrayList<>(this.piece.walk(this.position, logicalBoard.getBoard()));
            for (String s : available)
                this.buttonMap.get(s).setBackground(new Color(205, 92, 92));
            frame.repaint();

            selectedPiece = this;
        }
         else if (!available.isEmpty()) {
             if (selectedPiece != null && this.piece == selectedPiece.getPiece()) {
                 selectedPiece = null;
                 for (String position: available)
                     resetSquareColour(position);
                 available.clear();
                 throw new IllegalArgumentException("Move cancellation");
            }
            for (String position: available)
                resetSquareColour(position);
            this.frame.repaint();

            if (available.contains(this.position)) {
                logicalBoard.setPiece(selectedPiece.getPiece(), selectedPiece.position, this.position);

                this.setPiece(selectedPiece.getPiece());
                selectedPiece.setPiece(null);
                selectedPiece = null;
                boardFrame.switchCurrentTurn();
            } else
                throw new IllegalArgumentException("Invalid action: illegal move");
            available.clear();
        } else {
            throw new IllegalArgumentException("Invalid action: no piece selected");
        }
    }


    public PieceButton(String position, Map<String, PieceButton> buttonMap, JFrame frame, Board logicalBoard, BoardFrame boardFrame) {
        this.position = position;
        this.buttonMap = buttonMap;
        this.frame = frame;
        PieceButton.logicalBoard = logicalBoard;
        this.boardFrame = boardFrame;
        this.addActionListener(this);
    }
}
