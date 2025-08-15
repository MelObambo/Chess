package objects.pieces;

import java.util.ArrayList;

public class Rook extends Piece {
    public final String name;

    @Override
    public ArrayList<String> walk(String position) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        for (char col = 'a'; col <= 'h'; col++)
        {
            if(col != column)
                available.add(String.valueOf(col) + row);
        }
        for (int r = 1; r <= 8; r++)
        {
            if (r != row)
                available.add(String.valueOf(column) + r);
        }
        return available;
    }

    public Rook(int id, int color) {
        super(id, color);
        this.name = "R";
    }
}
