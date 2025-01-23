package objects.pieces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece {

    public Pawn(int id, String name) {
        super(id);
    }

    public boolean walk(List<Map.Entry<Character, Integer>> position, List<Map.Entry<Character, Integer>> move, String color) {
        Map<Character, Integer> available = new HashMap<>();
        char column = position.getFirst().getKey();
        int row = position.getFirst().getValue();

        if (color == "white") {
            if (row == 2) {
                available.put(column, row+2);
            }
            available.put(column, row+1);
        } else {
            if (row == 7) {
                available.put(column, row-2);
            }
            available.put(column, row-1);
        }
        if (available.containsKey(move.getFirst().getKey()) && available.containsValue(move.getFirst().getValue())) {
            return true;
        }
        return false;
    }
}
