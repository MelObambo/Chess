package graphics;

import models.Board;
import models.Colour;
import models.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class PieceButton extends JButton implements ActionListener {
    private String position;

    private Piece piece;
    private static PieceButton selectedPiece;
    private static PieceButton lastPieceMoved;

    private static ArrayList<String> available;

    private Map<String, PieceButton> buttonMap;
    private static Board logicalBoard;

    private JFrame frame;
    private BoardFrame boardFrame;

    public void setPosition(String position) { this.position = position; }
    public String getPosition() { return this.position; }

    protected void setPiece(Piece piece) {
        this.piece = piece;
        this.updateIcon();
    }
    protected Piece getPiece() { return this.piece; }


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


    private void checkEnPassant() {
        if (lastPieceMoved != null &&
                lastPieceMoved.piece.getClass().getSimpleName().equalsIgnoreCase("pawn") &&
                this.piece.getClass().getSimpleName().equalsIgnoreCase("pawn") &&
                lastPieceMoved.getPiece().getEnPassant())
        {
            int pieceColumn = Character.getNumericValue(this.position.charAt(0));
            int lastPieceColumn = Character.getNumericValue(lastPieceMoved.position.charAt(0));

            if (Math.abs(pieceColumn - lastPieceColumn) == 1 && position.charAt(1) == lastPieceMoved.position.charAt(1) && (this.position.charAt(0) == 'd' || this.position.charAt(0) == 'e')) {
                int direction = this.piece.getColour() == Colour.WHITE ? 1 : -1;
                available.add(lastPieceMoved.position.charAt(0) + "" + Character.getNumericValue(this.position.charAt(1) + direction));
                lastPieceMoved.getPiece().switchEnPassant();
            }
        }
    }
    private boolean onMoveEnPassant(Piece movingPiece) {
        if (lastPieceMoved != null && movingPiece.getClass().getSimpleName().equalsIgnoreCase("pawn")) {
            int direction = movingPiece.getColour() == Colour.WHITE ? 1 : -1;

            char lastCol = lastPieceMoved.position.charAt(0);
            int lastRow = Character.getNumericValue(lastPieceMoved.position.charAt(1));

            String target = "" + lastCol + (lastRow + direction);

            if (this.position.equals(target) && lastPieceMoved.getPiece().getEnPassant()) {
                logicalBoard.setPieceEnPassant(movingPiece, selectedPiece.position, this.position, lastPieceMoved.position);
                lastPieceMoved.setPiece(null);
                return true;
            }
        }
        return false;
    }
    private void onMovePiece() {
        Piece movingPiece = selectedPiece.getPiece();
        if (!onMoveEnPassant(movingPiece))
            logicalBoard.setPiece(movingPiece, selectedPiece.position, this.position);

        this.setPiece(selectedPiece.getPiece());
        selectedPiece.setPiece(null);
        selectedPiece = null;
        boardFrame.switchCurrentTurn();
        lastPieceMoved = new PieceButton();
        lastPieceMoved.setPiece(movingPiece);
        lastPieceMoved.setPosition(this.position);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (available.isEmpty() && this.piece == null && selectedPiece == null)
            throw new IllegalArgumentException("Invalid action: empty square");


        if (available.isEmpty() && this.piece != null && this.piece.getColour() != this.boardFrame.getCurrentTurn())
            throw new IllegalArgumentException("Invalid action: other player's turn");

        if (available.isEmpty() && this.piece != null) {
            available.addAll(this.piece.walk(this.position, logicalBoard.getBoard()));
            this.checkEnPassant();
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
                this.onMovePiece();
            } else {
                selectedPiece = null;
                available.clear();
                throw new IllegalArgumentException("Invalid action: illegal move");
            }
            selectedPiece = null;
            available.clear();
        } else {
            throw new IllegalArgumentException("Invalid action: no piece selected");
        }
    }

    public PieceButton() {}

    public PieceButton(String position, Map<String, PieceButton> buttonMap, JFrame frame, Board logicalBoard, BoardFrame boardFrame) {
        this.position = position;
        this.buttonMap = buttonMap;
        this.frame = frame;
        PieceButton.logicalBoard = logicalBoard;
        this.boardFrame = boardFrame;

        available = new ArrayList<>();
        this.addActionListener(this);
    }
}
