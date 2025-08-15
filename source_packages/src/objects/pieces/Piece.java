package objects.pieces;


import java.util.ArrayList;

public class Piece {
    public final int id;
    /**
     * int color
     *
     * If this parameter is equal to one it is white else, it is balck
     */
    public final int color;

    public int getId() {
        return this.id;
    }
    public int getColor() {
        return this.color;
    }

    public  ArrayList<String> walk(String position) {
        return null;
    }
    public  ArrayList<String> walk(String position, int color) {
        return null;
    }

    public Piece(int id, int color) {
        this.id = id;
        this.color = color;
    }
}
