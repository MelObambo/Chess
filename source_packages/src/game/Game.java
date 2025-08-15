package game;

public class Game {
    private final int id;
    private Move[] moves;
    private int increment = 0;

    public int getId() {
        return id;
    }

    public Move[] getMoves() {
        return moves;
    }
    public void setMove(Move move) {
        this.moves[increment] = move;
        this.increment++;
    }

    public Game(int id) {
        this.id = id;
        this.moves = new Move[200];
    }
}