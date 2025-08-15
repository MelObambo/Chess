package objects.pieces;

import java.util.ArrayList;

public class Queen extends Piece {
    public final String name;

    @Override
    public ArrayList<String> walk(String position) {
        ArrayList<String> available = new ArrayList<>();
        Rook rook = new Rook(40, super.color);
        ArrayList<String> file = rook.walk(position);

        Bishop bishop = new Bishop(41, super.color);
        ArrayList<String> diagonal = bishop.walk(position);

        available.addAll(file);
        available.addAll(diagonal);

        return available;
    }

    public Queen(int id, int color) {
        super(id, color);
        this.name = "Q";

    }
}
