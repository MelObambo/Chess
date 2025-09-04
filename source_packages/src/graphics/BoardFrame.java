package graphics;

import models.Board;
import models.Colour;
import models.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoardFrame {

    private PieceButton[] buttons = new PieceButton[64];
    private Board board = new Board();
    private JFrame frame = new JFrame("Chess Board");
    private Colour currentTurn = Colour.WHITE;

    public BoardFrame() {
        int squareSize;
        Map<String, Piece> pieceMap = board.getBoard();
        String[] positions = generatePositionArray();

        Color darkSquare = new Color(255, 234, 230);
        Color lightSquare = new Color(250, 144, 120);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(8, 8);
        //TODO: change to GridBagLayout
        frame.setLayout(layout);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int size = Math.min(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
        squareSize = size/8;

        Map<String, PieceButton> pieceButtonMap = new HashMap<>();
        int i = 0;
        for (String position : positions) {
            Piece piece = pieceMap.get(position);
            PieceButton pieceButton = new PieceButton(position, pieceButtonMap, frame, board, this);
            pieceButton.setPiece(piece);
            pieceButtonMap.put(pieceButton.getPosition(), pieceButton);

            int row = i++ / 8;
            int col = i % 8;

            Color squareColor = (col + row) % 2 == 0 ? lightSquare: darkSquare;
            pieceButton.setBackground(squareColor);
            pieceButton.setBorderPainted(false);

            buttons[positionToIndex(position)] = pieceButton;
            frame.add(pieceButton);
        }

        frame.setSize(800, 800);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Colour getCurrentTurn() {
        return currentTurn;
    }

    public void switchCurrentTurn() {
        currentTurn = currentTurn == Colour.WHITE ? Colour.BLACK : Colour.WHITE;
    }

    private static String[] generatePositionArray() {
        String[] positions = new String[64];
        int index = 0;
        for (int col = 8; col > 0; col--) {
            for (char row = 'a'; row < 'i'; row++) {
                positions[index++] = "" + row + col;
            }
        }
        return positions;
    }

    private static int positionToIndex(String position) {
        char col = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        int colIndex = col - 'a';
        int rowIndex = 8 - row;

        // because it starts with a8 top left
        return rowIndex * 8 + colIndex;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BoardFrame());
    }
}