package objects.pieces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class King extends Piece {
    private String name = "K";

    public King(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean walk(List<Map.Entry<Character, Integer>> position, List<Map.Entry<Character, Integer>> move) {
        Map<Character, Integer> available = new HashMap<>();
        char columnMinus = position.getFirst().getKey();
        char column = position.getFirst().getKey();
        char columnPlus = position.getFirst().getKey();
        int rowMinus = position.getFirst().getKey();
        int row = position.getFirst().getKey();
        int rowPlus = position.getFirst().getKey();
        columnMinus -=1;
        columnPlus +=1;
        rowMinus -=1;
        rowPlus +=1;
        available.put(columnMinus, rowPlus);
        available.put(column, rowPlus);
        available.put(columnPlus, rowPlus);
        available.put(columnMinus, row);
        available.put(column, row);
        available.put(columnPlus, row);
        available.put(columnMinus, rowMinus);
        available.put(column, rowMinus);
        available.put(columnPlus, row);

        if (available.containsKey(move.getFirst().getKey()) && available.containsKey(move.getFirst().getKey())) {
            return true;
        }
        return false;
    }
}
