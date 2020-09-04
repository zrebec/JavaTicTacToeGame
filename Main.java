package com.ibm.study;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Do you want to play?
        boolean playableGame = true;

        // Define board
        char[][] board = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        // Define other variables
        char playerX = 'X';
        char playerO = 'O';
        int pauseSecsBetweenMoves = 2;
        Random randomPosition = new Random();
        int x = 0;
        int y = 0;
        char activePlayer = playerX;
        Scanner position = new Scanner(System.in);
        int playerPosition;

        drawGameBoard(board);
        System.out.println("Board created.");
        System.out.println("The game will start with player X");

        while (true) {
            // Move player
            if(playableGame && activePlayer == 'X') {
                System.out.print("Choose your position (1-9): ");
                playerPosition = position.nextInt();
            } else {
                playerPosition = randomPosition.nextInt(9) + 1;
                System.out.println("Player " + activePlayer + " chose position " + playerPosition);
            }

            switch (playerPosition) {
                case 1:
                    x = 0; y = 0;
                    break;
                case 2:
                    x = 2; y = 0;
                    break;
                case 3:
                    x = 4; y = 0;
                    break;
                case 4:
                    x = 0; y = 2;
                    break;
                case 5:
                    x = 2; y = 2;
                    break;
                case 6:
                    x = 4; y = 2;
                    break;
                case 7:
                    x = 0; y = 4;
                    break;
                case 8:
                    x = 2; y = 4;
                    break;
                case 9:
                    x = 4; y = 4;
                    break;
            }


            if(board[y][x] == ' ') {
                board[y][x] = activePlayer;
                drawGameBoard(board);
                // Wait for n milliseconds
                Thread.sleep(pauseSecsBetweenMoves * 1000);
            } else {
                continue;
            }

            // Check status of the game
            if (checkAnyPlayerWon(board, activePlayer)) {
                // Any player won
                System.out.println("Player " + activePlayer + " WON!");
                break;
            } else if (!checkFreePlayablePosition(board)) {
                // No free playable position
                System.out.println("The game ends with draw.");
                break;
            } else {
                // Continue with game

                // Change active player
                if(activePlayer == playerX) {
                    activePlayer = playerO;
                } else {
                    activePlayer = playerX;
                }
            }
        }

        // Draw final status of board
        drawGameBoard(board);
    }

    public static boolean checkFreePlayablePosition(char[][] board) {
        return board[0][0] == ' '
                || board[0][2] == ' '
                || board[0][4] == ' '
                || board[2][0] == ' '
                || board[2][2] == ' '
                || board[2][4] == ' '
                || board[4][0] == ' '
                || board[4][2] == ' '
                || board[4][4] == ' ';
    }

    public static boolean checkAnyPlayerWon(char[][] board, char player) {
        // First line won
        if((board[0][0] + board[2][0] + board[4][0]) == (player + player + player)) return true;

        // Second line won
        if((board[0][2] + board[2][2] + board[4][2]) == (player + player + player)) return true;

        // Third line won
        if((board[0][4] + board[2][4] + board[4][4]) == (player + player + player)) return true;

        // First column won
        if((board[0][0] + board[0][2] + board[0][4]) == (player + player + player)) return true;

        // Second column won
        if((board[2][0] + board[2][2] + board[2][4]) == (player + player + player)) return true;

        // Third column won
        if((board[4][0] + board[4][2] + board[4][4]) == (player + player + player)) return true;

        // First diagonal
        if((board[0][0] + board[2][2] + board[4][4]) == (player + player + player)) return true;

        // Second diagonal
        return (board[4][0] + board[2][2] + board[0][4]) == (player + player + player);
    }

    public static void drawGameBoard(char[][] board) {
        for (char[] columns : board) {
            for (char column : columns) {
                // Print board
                System.out.print(column);
            }
            // Print new line
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
