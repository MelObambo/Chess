package models.pieces;

import models.Colour;

import java.util.*;

public class Pawn extends Piece {
    private boolean enPassant;

    public Pawn(int id, Colour colour){
        super(id, colour);
        enPassant = false;
    }

    @Override
    public boolean getEnPassant () {
        return enPassant;
    }

    @Override
    public void switchEnPassant(){
        this.enPassant = false;
    }

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
            System.out.println("left diagonal: " + leftDiagonal);
            Piece target = board.get(leftDiagonal);
            if (target != null && target.getColour() != this.getColour())
                available.add(leftDiagonal);
        }

        if (column < 'h') {
            String rightDiagonal = (char) (column + 1) + "" + (row + direction);
            Piece target = board.get(rightDiagonal);
            if (target != null)
                System.out.println("target: " + target.getColour());
            if (target != null && target.getColour() != this.getColour())
                available.add(rightDiagonal);
        }

        String stepOne = column + String.valueOf(row + direction);
        String stepTwo = column + String.valueOf(row + 2 * direction);
        if (board.get(stepOne) == null) {
            available.add(stepOne);

            boolean isAtStartingPoint =
                    (row == 2 && this.getColour() == Colour.WHITE) ||
                    (row == 7 && this.getColour() == Colour.BLACK);

            if (isAtStartingPoint && (board.get(stepTwo) == null)) {
                available.add(stepTwo);
                enPassant = true;
            } else
                enPassant = false;
        }

        return available;
    }
}






















