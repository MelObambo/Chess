package objects.pieces;

import java.util.ArrayList;

public class Queen implements Piece {
    public final int id;
    public final String name;

    public ArrayList<String> walk(String position, String color) {
        ArrayList<String> available = new ArrayList<>();
        Rook rook = new Rook(3);
        ArrayList<String> file = rook.walk(position, color);

        Bishop bishop = new Bishop(3);
        ArrayList<String> diagonal = bishop.walk(position, color);

        available.addAll(file);
        available.addAll(diagonal);

        return available;
    }

    public Queen(int id) {
        this.id = id;
        this.name = "Q";

    }
}
