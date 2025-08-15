import objects.Board;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board = new Board();
    Map<String, Integer> boardMap = new LinkedHashMap<String, Integer>(){{
        put("a1", 1); put("b1", 2); put("c1", 3); put("d1", 4); put("e1", 5); put("f1", 6); put("g1", 7); put("h1", 8);

        put("a2", 9); put("b2", 10); put("c2", 11); put("d2", 12); put("e2", 13); put("f2", 14); put("g2", 15); put("h2", 16);

        put("a3", null); put("b3", null); put("c3", null); put("d3", null); put("e3", null); put("f3", null); put("g3", null); put("h3", null);

        put("a4", null); put("b4", null); put("c4", null); put("d4", null); put("e4", null); put("f4", null); put("g4", null); put("h4", null);

        put("a5", null); put("b5", null); put("c5", null); put("d5", null); put("e5", null); put("f5", null); put("g5", null); put("h5", null);

        put("a6", null); put("b6", null); put("c6", null); put("d6", null); put("e6", null); put("f6", null); put("g6", null); put("h6", null);

        put("a7", 17); put("b7", 18); put("c7", 19); put("d7", 20); put("e7", 21); put("f7", 22); put("g7", 23); put("h7", 24);

        put("a8", 25); put("b8", 26); put("c8", 27); put("d8", 28); put("e8", 29); put("f8", 30); put("g8", 31); put("h8", 32);
    }};

    @Test
    public void test() {
        assertEquals(board.getBoard(), boardMap);
    }
}
