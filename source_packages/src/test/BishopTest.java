package test;

import objects.pieces.Bishop;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    Bishop bishop = new Bishop(1);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("c1", "e3", "f4", "g5", "h6", "a5", "b4", "c3", "e1"));

    @Test
    public void testWalk() throws Exception {
        assertEquals(bishop.walk("d2", "white"), moves);
    }
}
