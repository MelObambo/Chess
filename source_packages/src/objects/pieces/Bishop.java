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

    public boolean walk(List<Map.Entry<String, Integer>> position, List<Map.Entry<String, Integer>>[] move) {
        int moveNumber = 13;
        Map<String, Character> positions = new HashMap<String, Character>();

        if (
            position.get(1).getKey().equals("a") || position.get(1).getKey().equals("h")
            || position.get(1).getValue() == 1 || position.get(1).getValue() == 8
        ) {
            moveNumber = 7;
        } else if (
            position.get(1).getKey().equals("b") || position.get(1).getKey().equals("g")
            || position.get(1).getValue() == 2 || position.get(1).getValue() == 7
        ) {
            moveNumber = 9;
        } else if (
            position.get(1).getKey().equals("c") || position.get(1).getKey().equals("f")
            || position.get(1).getValue() == 3 || position.get(1).getValue() == 6
        ) {
            moveNumber = 11;
        }

        for(int i = 0; i < moveNumber; i++){
        }
    }
}
