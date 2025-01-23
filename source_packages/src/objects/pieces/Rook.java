package objects.pieces;

import java.util.List;
import java.util.Map;

public class Rook extends Piece {
    private String name = "R";

    public Rook(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean walk(List<Map.Entry<String, Integer>> position, List<Map.Entry<String, Integer>>[] move) {}
}
