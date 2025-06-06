package objects.pieces;

import java.util.ArrayList;

public class Knight implements Piece {
    public final int id;
    public final String name;

    public ArrayList<String> walk(String position, String color) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        if (column > 'a' && row > 2)
            available.add(String.valueOf((char) (column - 1)) + (row - 2));

        if (column > 'b' && row > 1)
            available.add(String.valueOf((char) (column - 2)) + (row - 1));

        if (column > 'b' && row < 8)
            available.add(String.valueOf((char) (column - 2)) + (row + 1));

        if (column > 'a' && row < 7)
            available.add(String.valueOf((char) (column - 1)) + (row + 2));

        if (column < 'h' && row < 7)
            available.add(String.valueOf((char) (column + 1)) + (row + 2));

        if (column < 'g' && row < 8)
            available.add(String.valueOf((char) (column + 2)) + (row + 1));

        if (column < 'g' && row > 1)
            available.add(String.valueOf((char) (column + 2)) + (row - 1));

        if (column < 'h' && row > 2)
            available.add(String.valueOf((char) (column + 1)) + (row - 2));

        return available;
    }

    public Knight(int id){
        this.id = id;
        this.name = "R";
    }
}
