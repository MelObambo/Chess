package models.pieces;

import models.Colour;

import java.util.*;

public class Pawn extends Piece {

    @Override
    public ArrayList<String> walk(String position, Map<String, Piece> board) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        if (row == 1 || row == 8) {
            System.err.println("Warning at " + position + ": Pawn should have promoted");
            return available;
        }

        int direction = this.getColour() == Colour.WHITE ? 1 : -1;

        if (column > 'a') {
            String leftDiagonal = (char) (column - 1) + "" + (row + direction);
            Piece target = board.get(leftDiagonal);
            if (target != null && target.getColour() != this.getColour())
                available.add(leftDiagonal);
        }

        if (column < 'h') {
            String rightDiagonal = (char) (column + 1) + "" + (row + direction);
            Piece target = board.get(rightDiagonal);
            if (target != null && target.getColour() != this.getColour())
                available.add(rightDiagonal);
        }

        String stepOne = column + String.valueOf(row + direction);
        String stepTwo = column + String.valueOf(row + 2 * direction);
        if (board.get(stepOne) == null) {
            available.add(String.valueOf(column) + (row + direction));

            boolean isAtStartingPoint =
                    (row == 2 && this.getColour() == Colour.WHITE) ||
                    (row == 7 && this.getColour() == Colour.BLACK);

            if (isAtStartingPoint && (board.get(stepTwo) == null))
                available.add(stepTwo);
        }

        return available;
    }

    public Pawn(int id, Colour colour){
        super(id, colour);
    }
}






















