package objects.pieces;

import java.util.List;
import java.util.Map;

public class Queen extends Piece {
    private String name = "Q";

    public Queen(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // public boolean walk(List<Map.Entry<Character, Integer>> position, List<Map.Entry<Character, Integer>> move) {}
}
