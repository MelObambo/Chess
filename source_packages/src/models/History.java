package models;

import game.Game;

public class History {
    private final int id;
    private final Player playerOne;
    private final Player playerTwo;
    private final Game game;

    public History(int id, Player playerOne, Player playerTwo, Game game) {
        this.id = id;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public Player getPlayerOne() {
        return playerOne;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }
    public Game getGame() {
        return game;
    }

}
