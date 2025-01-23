package objects.pieces;

import java.util.List;
import java.util.Map;

public class Knight extends Piece {
    private String name = "N";

    Knight(int id, String name){
        super(id);
        this.name = name;
    }

    walk(List<Map.Entry<String, Integer>> position, List<Map.Entry<String, Integer>>[] move){}
}
