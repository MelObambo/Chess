package objects;

import objects.pieces.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Board {
    private final Map<String, Piece> board = new LinkedHashMap<>();

    public Map<String, Piece> getBoard() {
        return board;
    }

    private void createEmptyBoard() {
        for (char i = 'a'; i <= 'h'; i++) {
            for (int j = 1; j <= 8; j++) {
                board.put((i + "" + j), null);
            }
        }
    }

    private void placePieces() {
        board.put("a1", new Rook(1, 0));
        board.put("h1", new Rook(2, 0));
        board.put("a8", new Rook(3, 1));
        board.put("h8", new Rook(4, 1));

        board.put("b1", new Knight(5, 0));
        board.put("g1", new Knight(6, 0));
        board.put("b8", new Knight(7, 1));
        board.put("g8", new Knight(8, 1));

        board.put("c1", new Bishop(9, 0));
        board.put("f1", new Bishop(10, 0));
        board.put("c8", new Bishop(11, 1));
        board.put("f8", new Bishop(12, 1));

        board.put("d1", new Queen(13, 0));
        board.put("d8", new Queen(14, 0));

        board.put("e1", new King(15, 0));
        board.put("e8", new King(16, 0));

        int id = 16;
        for (char i = 'a'; i <= 'h'; i++) {
            board.put(i + "" + 2, new Pawn(id++, 0));
            board.put(i + "" + 7, new Pawn(id++, 1));
        }
    }

    public Board() {
        createEmptyBoard();
        placePieces();
    }
}
