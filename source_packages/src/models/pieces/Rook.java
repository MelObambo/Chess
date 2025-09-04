package models.pieces;

import models.Colour;

import java.util.ArrayList;
import java.util.Map;

public class Rook extends Piece {
    public final String name;

    @Override
    public ArrayList<String> walk(String position, Map<String, Piece> board) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            char newColumn = (char) (column + direction[1]);

            while (newRow >= 1 && newRow <= 8 && newColumn >= 'a' && newColumn <= 'h') {
                Piece target = board.get(newColumn + "" + newRow);
                if (target == null)
                    available.add(newColumn + "" + newRow);
                else {
                    if (target.getColour() != this.getColour())
                        available.add(newColumn + "" + newRow);
                    break;
                }
                newRow = newRow + direction[0];
                newColumn = (char) (newColumn + direction[1]);
            }
        }

        return available;
    }

    public Rook(int id, Colour colour) {
        super(id, colour);
        this.name = "R";
    }
}
