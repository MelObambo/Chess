package objects.pieces;

import java.util.*;

public class Pawn extends Piece {

    @Override
    public ArrayList<String> walk(String position, int color) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        if (row > 7)
            return available;

        if (Objects.equals(color, 0)) {
            available.add(String.valueOf(column) + (row + 1));
            if (row == 2)
                available.add(String.valueOf(column) + (row + 2));
        } else {
            available.add(String.valueOf(column) + (row - 1));
            if (row == 7)
                available.add(String.valueOf(column) + (row - 2));
        }
        return available;
    }

    public Pawn(int id, int color){
        super(id, color);
    }
}






















