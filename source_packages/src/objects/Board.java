package objects;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Character, Integer> board = new HashMap<>();

    public Map<Character, Integer> getBoard() {
        return board;
    }

    Board() {
        char column;
        for (int row = 1; row <=8; row++) {
            column = 'a';
            for (int col = 1; col <=8; col++) {
                board.put(column, row);
                column+=1;
            }
        }
    }
}
