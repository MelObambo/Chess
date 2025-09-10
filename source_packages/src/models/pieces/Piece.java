package models.pieces;

import models.Colour;

import java.util.ArrayList;
import java.util.Map;

public class Piece {
    public final int id;
    private Colour colour;
    private boolean enPassant;

    public Piece(int id, Colour colour) {
        this.id = id;
        this.colour = colour;
    }

    public int getId() {
        return this.id;
    }
    public Colour getColour() {
        return this.colour;
    }

    public  ArrayList<String> walk(String position, Map<String, Piece> board) {
        return null;
    }

    public boolean getEnPassant () {
        return false;
    }

    public void switchEnPassant() {
        enPassant = false;
    }

}
