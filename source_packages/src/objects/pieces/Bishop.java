package objects.pieces;

import java.util.ArrayList;

public class Bishop implements Piece {
    public final int id;
    public final String name;

    public ArrayList<String> walk(String position, String color) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));

        for (int offset = -7; offset < 8; offset++)
        {
            if(offset == 0)
                continue;

            char col = (char) (offset + column);

            int row1 = row + offset;
            if(col >= 'a' && col <= 'h' && row1 >= 1 && row1 <= 8)
                available.add(String.valueOf(col) + row1);
        }
        for (int offset = -7; offset < 8; offset++) {
            if (offset == 0)
                continue;

            char col = (char) (offset + column);
            int row2 = row - offset;
            if (col >= 'a' && col <= 'h' && row2 >= 1 && row2 <= 8)
                available.add(String.valueOf(col) + row2);
        }
        return available;
    }

    public Bishop(int id) {
        this.id = id;
        this.name = "B";
    }
}
