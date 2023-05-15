package org.example;

public class Board {
    private static final int SIZE = 15;
    private static final char EMPTY = '-';
    private static final char PLAYER1_SYMBOL = 'X';
    private static final char PLAYER2_SYMBOL = 'O';

    private char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];
        initializeGrid();
    }

    public void initializeGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = EMPTY;
            }
        }
    }

    public void printBoard() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        for (int row = 0; row < SIZE; row++) {
            System.out.print((row + 1) + "  ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == EMPTY;
    }

    public void setCell(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    public boolean isFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(char symbol) {
        // Check rows
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col <= SIZE - 5; col++) {
                if (grid[row][col] == symbol && grid[row][col + 1] == symbol &&
                        grid[row][col + 2] == symbol && grid[row][col + 3] == symbol &&
                        grid[row][col + 4] == symbol) {
                    return true;
                }
            }
        }

        // Check columns
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row <= SIZE - 5; row++) {
                if (grid[row][col] == symbol && grid[row + 1][col] == symbol &&
                        grid[row + 2][col] == symbol && grid[row + 3][col] == symbol &&
                        grid[row + 4][col] == symbol) {
                    return true;
                }
            }
        }

        return false;
    }
}
