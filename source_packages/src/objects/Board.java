package objects;

import java.util.LinkedHashMap;
import java.util.Map;

public class Board {
    private Map<String, Integer> board = new LinkedHashMap<>();

    public Map<String, Integer> getBoard() {
        return board;
    }

    public void setPosition(int id, String position){
        board.values().remove(id);
        board.put(position, id);
    }

    public Board() {
        char column = 'a';
        int pieceId = 1;

        for (int i = 0; i <= 7; i++) {
            board.put(String.valueOf((char) (column + i)) + 1, pieceId);
            pieceId++;
        }
        for (int i = 0; i <= 7; i++) {
            board.put(String.valueOf((char) (column + i)) + 2, pieceId);
            pieceId++;
        }

        for (int row = 3; row < 7; row++) {
            for (int i = 0; i <= 7; i++) {
                board.put(String.valueOf((char) (column + i)) + row, null);
            }
        }

        for (int i = 0; i <= 7; i++) {
            board.put(String.valueOf((char) (column + i)) + 7, pieceId);
            pieceId++;
        }
        for (int i = 0; i <= 7; i++) {
            board.put(String.valueOf((char) (column + i)) + 8, pieceId);
            pieceId++;
        }
    }
}
