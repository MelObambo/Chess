package objects.pieces;

import java.util.HashMap;
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

    public boolean walk(List<Map.Entry<Character, Integer>> position, List<Map.Entry<Character, Integer>> move) {
        Map<Character, Integer> available = new HashMap<>();
        char column = position.getFirst().getKey();
        int row = position.getFirst().getValue();
        char col = 'a';

        for (int i = 1; i <= 8; i++) {
            available.put(column, i);
            available.put(col, row);
            col += 1;
        }
        if (available.containsKey(move.getFirst().getKey()) && available.containsValue(move.getFirst().getValue())) {
            return true;
        }
        return false;
    }
}
