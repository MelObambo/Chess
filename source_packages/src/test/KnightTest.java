package test;

import objects.pieces.Knight;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    Knight knight = new Knight(1);
    ArrayList<String> moves = new ArrayList<>(Arrays.asList("c3", "b4", "b6", "c7", "e7", "f6",  "f4", "e3"));
    ArrayList<String> moves1 = new ArrayList<>(Arrays.asList("b1", "b3", "c4", "e4", "f3", "f1"));

    @Test
    public void testMove() {
        assertEquals(knight.walk("d5", "white"), moves);
        assertEquals(knight.walk("d2", "white"), moves1);
    }
}
