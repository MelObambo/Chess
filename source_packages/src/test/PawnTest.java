package test;

import objects.pieces.Pawn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    Pawn pawn = new Pawn(1);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("b3", "b4"));

    ArrayList<String> moves2 = new ArrayList<>(List.of("b4"));

    ArrayList<String> moves3 = new ArrayList<>(Arrays.asList("b6", "b5"));

    ArrayList<String> moves4 = new ArrayList<>(List.of("b5"));

    @Test
    public void testMove() throws Exception {
        assertEquals(pawn.walk("b2", "white"), moves);
        assertEquals(pawn.walk("b3", "white"), moves2);
        assertEquals(pawn.walk("b7", "black"), moves3);
        assertEquals(pawn.walk("b6", "black"), moves4);
    }
}