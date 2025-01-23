package objects;

import objects.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Character, Integer> board =new HashMap<Character, Integer>;

    Board() {
        String c = 'a';
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <=8; i++) {
            board.put(c, i);
            c = result.append((String) c+1);
        }
    }
}
