package objects.pieces;

import java.util.ArrayList;

public class King implements Piece {
    public final int id;
    public final String name;

    public ArrayList<String> walk(String position, String color) {
        ArrayList<String> available = new ArrayList<>();
        char column = position.charAt(0);
        int row = Character.getNumericValue(position.charAt(1));
        char col;
        int r;

        for (int i = -1; i < 2; i++){
            col = (char) (column + i);
            for (int j = - 1; j < 2; j++){
                r = row + j;
                if(col < 'a' || col > 'h' || r < 1 || r > 8 || (col == column && r == row))
                    continue;
                available.add(String.valueOf(col) + r);
            }
        }

        return available;
    }

    public King(int id) {
        this.id = id;
        this.name = "K";
    }
}









