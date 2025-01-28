package test;

import objects.pieces.Queen;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {
    Queen queen = new Queen(1);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("a2", "b2", "c2", "e2", "f2", "g2", "h2", "d1", "d3", "d4", "d5", "d6", "d7", "d8", "c1", "e3", "f4", "g5", "h6", "a5", "b4", "c3", "e1"));

    @Test
    public void testWalk() {
        assertEquals(queen.walk("d2", "white"), moves);
    }
}
