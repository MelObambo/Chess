import models.Board;
import models.Colour;
import models.pieces.Pawn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    Board board = new Board();
    Pawn whitePawn = new Pawn(1, Colour.WHITE);
    Pawn blackPawn = new Pawn(2, Colour.BLACK);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("b3", "b4"));

    ArrayList<String> moves2 = new ArrayList<>(List.of("b4"));

    ArrayList<String> moves3 = new ArrayList<>(Arrays.asList("b6", "b5"));

    ArrayList<String> moves4 = new ArrayList<>(List.of("b5"));

    @Test
    public void testMove() throws Exception {
        assertEquals(whitePawn.walk("b2", board.getEmptyBoard()), moves);
        assertEquals(whitePawn.walk("b3", board.getEmptyBoard()), moves2);
        assertEquals(blackPawn.walk("b7", board.getEmptyBoard()), moves3);
        assertEquals(blackPawn.walk("b6", board.getEmptyBoard()), moves4);
    }
}