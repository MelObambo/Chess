package models.pieces;

import models.Colour;

import java.util.ArrayList;
import java.util.Map;

public class Queen extends Piece {
    public final String name;

    @Override
    public ArrayList<String> walk(String position, Map<String, Piece> board) {
        ArrayList<String> available = new ArrayList<>();
        Rook rook = new Rook(40, super.getColour());
        ArrayList<String> file = rook.walk(position, board);

        Bishop bishop = new Bishop(41, super.getColour());
        ArrayList<String> diagonal = bishop.walk(position, board);

        available.addAll(file);
        available.addAll(diagonal);

        return available;
    }

    public Queen(int id, Colour colour) {
        super(id, colour);
        this.name = "Q";

    }
}
