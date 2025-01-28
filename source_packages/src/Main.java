import graphics.BoardFrame;
import objects.Board;
import objects.pieces.*;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        BoardFrame boardFrame = new BoardFrame();
        System.out.println(board.getBoard());

    }
}