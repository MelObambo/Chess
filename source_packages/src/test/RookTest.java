import models.Board;
import models.Colour;
import models.pieces.Rook;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    Board board = new Board();
    Rook rook = new Rook(1, Colour.WHITE);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList(
            "a2", "b2", "c2", "e2", "f2", "g2", "h2", "d1", "d3", "d4", "d5", "d6", "d7", "d8"
    ));

    @Test
    public void testWalk() throws Exception {
        assertEquals(rook.walk("d2", board.getEmptyBoard()), moves);
    }
}

























