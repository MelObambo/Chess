package test;

import objects.pieces.King;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    King king = new King(1);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("a1", "a2", "a3", "b1", "b3", "c1", "c2", "c3"));
    ArrayList<String> moves2 = new ArrayList<>(Arrays.asList("a1", "a2", "b2", "c1", "c2"));
    ArrayList<String> moves3 = new ArrayList<>(Arrays.asList( "a1", "a3", "b1", "b2", "b3"));
    ArrayList<String> moves4 = new ArrayList<>(Arrays.asList("a7", "a8", "b7", "c7", "c8"));
    ArrayList<String> moves5 = new ArrayList<>(Arrays.asList("g1", "g2", "g3", "h1", "h3"));

    @Test
    public void testMove() throws Exception {
        assertEquals(king.walk("b2", "white"), moves);
        assertEquals(king.walk("b1", "white"), moves2);
        assertEquals(king.walk("a2", "white"), moves3);
        assertEquals(king.walk("b8", "white"), moves4);
        assertEquals(king.walk("h2", "white"), moves5);
    }
}


