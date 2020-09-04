package com.ibm.study;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void PlayerXWon() {
        char[][] board = {
                {'X', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', 'X', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', 'X'}
        };

        Main game = new Main();
        boolean result = game.checkAnyPlayerWon(board, 'X');
        assertEquals(true, result);
    }

    @Test
    public void PlayerYWon() {
        char[][] board = {
                {'X', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {'Y', '|', 'Y', '|', 'Y'},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', 'X'}
        };

        Main game = new Main();
        boolean result = game.checkAnyPlayerWon(board, 'Y');
        assertEquals(true, result);
    }

    @Test
    public void StillPlayableGame() {
        char[][] board = {
                {'X', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {'Y', '|', 'Y', '|', 'Y'},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', 'X'}
        };

        Main game = new Main();
        boolean result = game.checkFreePlayablePosition(board);
        assertEquals(true, result);
    }

    @Test
    public void NotPlayableGame() {
        char[][] board = {
                {'X', '|', 'Y', '|', 'X'},
                {'-', '+', '-', '+', '-'},
                {'Y', '|', 'X', '|', 'Y'},
                {'-', '+', '-', '+', '-'},
                {'Y', '|', 'Y', '|', 'Y'}
        };

        Main game = new Main();
        boolean result = game.checkFreePlayablePosition(board);
        assertEquals(false, result);
    }

}
