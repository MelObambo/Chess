package objects.pieces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {
    private String name = "B";

    public Bishop(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // just have to make sure it browse every square
    public boolean walk(List<Map.Entry<Character, Integer>> position, List<Map.Entry<Character, Integer>> move) {
        Map<Character, Integer> available = new HashMap<>();
        char column = position.getFirst().getKey();
        int row = position.getFirst().getValue();

        for(int i = 0; i < 8; i++){
            available.put();
        }

        if (available.containsKey(move.getFirst().getKey()) && available.containsValue(move.getFirst().getValue())) {
            return true;
        }
        return false;
    }
}
