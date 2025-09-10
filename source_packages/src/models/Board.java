package models;

import models.pieces.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Board {
    private final Map<String, Piece> board = new LinkedHashMap<>();

    public Board() {
        createEmptyBoard();
        placePieces();
    }

    public Map<String, Piece> getBoard() {
        return Collections.unmodifiableMap(board);
    }

    public Map<String, Piece> getEmptyBoard() {
        return Collections.unmodifiableMap(new LinkedHashMap<>());
    }

    private void createEmptyBoard() {
        for (char i = 'a'; i <= 'h'; i++) {
            for (int j = 1; j <= 8; j++) {
                board.put((i + "" + j), null);
            }
        }
    }

    private void placePieces() {
        board.put("a1", new Rook(1, Colour.WHITE));
        board.put("h1", new Rook(2, Colour.WHITE));
        board.put("a8", new Rook(3, Colour.BLACK));
        board.put("h8", new Rook(4, Colour.BLACK));

        board.put("b1", new Knight(5, Colour.WHITE));
        board.put("g1", new Knight(6, Colour.WHITE));
        board.put("b8", new Knight(7, Colour.BLACK));
        board.put("g8", new Knight(8, Colour.BLACK));

        board.put("c1", new Bishop(9, Colour.WHITE));
        board.put("f1", new Bishop(10, Colour.WHITE));
        board.put("c8", new Bishop(11, Colour.BLACK));
        board.put("f8", new Bishop(12, Colour.BLACK));

        board.put("d1", new Queen(13, Colour.WHITE));
        board.put("d8", new Queen(14, Colour.BLACK));

        board.put("e1", new King(15, Colour.WHITE));
        board.put("e8", new King(16, Colour.BLACK));

        int id = 16;
        for (char i = 'a'; i <= 'h'; i++) {
            board.put(i + "" + 2, new Pawn(id++, Colour.WHITE));
            board.put(i + "" + 7, new Pawn(id++, Colour.BLACK));
        }
    }

    public void setPiece(Piece piece, String formerPosition, String newPosition) {
        if (!board.containsKey(formerPosition) && !board.containsKey(newPosition))
            throw new IllegalArgumentException("Invalid position: " + formerPosition + " or " + newPosition);

        board.put(formerPosition, null);
        board.put(newPosition, piece);
    }
    public void setPieceEnPassant(Piece piece, String formerPosition, String newPosition, String enPassantPawn) {
        board.put(enPassantPawn, null);
        setPiece(piece, formerPosition, newPosition);
        System.out.println("last pawn: " + enPassantPawn);
    }
}
