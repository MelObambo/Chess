package models.pieces;

import models.Colour;

import java.util.ArrayList;
import java.util.Map;

public class Knight extends Piece {
    public final String name;

    @Override
    public ArrayList<String> walk(String position, Map<String, Piece> board) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));
        int[][] moves = {
                {2, 1}, {2, -1},
                {-2, 1}, {-2, -1},
                {1, 2}, {1, -2},
                {-1, 2}, {-1, -2}
        };

        for (int[] move : moves) {
            int newRow = row + move[0];
            char newColumn = (char) (column + move[1]);

            if (newRow < 1 || newRow > 8 || newColumn < 'a' || newColumn > 'h')
                continue;

            Piece target = board.get(newColumn + "" + newRow);
            if (target == null || target.getColour() != this.getColour())
                available.add(newColumn + "" + newRow);
        }
        return available;
    }

    public Knight(int id, Colour colour){
        super(id, colour);
        this.name = "R";
    }
}
