package models.pieces;

import models.Colour;

import java.util.ArrayList;
import java.util.Map;

public class King extends Piece {
    public final String name;

    @Override
    public ArrayList<String> walk(String position, Map<String, Piece> board) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));
        char newColumn;
        int newRow;

        System.out.println(this.getColour());

        for (int i = -1; i < 2; i++){
            newColumn = (char) (column + i);
            for (int j = - 1; j < 2; j++){
                newRow = row + j;
                if(newColumn < 'a' || newColumn > 'h' || newRow < 1 || newRow > 8)
                    continue;

                if ((newColumn == column && newRow == row))
                    continue;

                String target = String.valueOf(newColumn) + String.valueOf(newRow);
                if (board.get(newColumn + "" + newRow) != null && board.get(target).getColour() == this.getColour())
                    continue;

                available.add(target);
            }
        }
        return available;
    }

    public King(int id, Colour colour) {
        super(id, colour);
        this.name = "K";
    }
}









