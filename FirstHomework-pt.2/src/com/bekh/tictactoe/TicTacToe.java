package com.bekh.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private final char X_MARK = 'x';
    private final char O_MARK = 'o';
    private final char EMPTY = '-';

    private char[][] gameBoard;
    private Scanner scanner;
    private Random random;


    public TicTacToe() {
        this.gameBoard = new char[3][3];
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void playVsHuman() {
        clearGameField();
        while (true) {
            humanTurn(X_MARK);
            printGameField();
            if (checkForWin(X_MARK)) {
                System.out.println("Player 1 won!\n");
                break;
            }
            if (checkForFull()) {
                System.out.println("Game board is full, draw!\n");
                break;
            }
            humanTurn(O_MARK);
            printGameField();
            if (checkForWin(O_MARK)) {
                System.out.println("Player 2 won!\n");
                break;
            }
            if (checkForFull()) {
                System.out.println("Game board is full, draw!\n");
                break;
            }
        }
    }

    public void playVsAI() {
        clearGameField();
        while (true) {
            humanTurn(X_MARK);
            printGameField();
            if (checkForWin(X_MARK)) {
                System.out.println("Player 1 won!\n");
                break;
            }
            if (checkForFull()) {
                System.out.println("Game board is full, draw!\n");
                break;
            }
            AITurn();
            printGameField();
            if (checkForWin(O_MARK)) {
                System.out.println("AI won!\n");
                break;
            }
            if (checkForFull()) {
                System.out.println("Game board is full, draw!\n");
                break;
            }
        }
    }

    private void clearGameField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
        System.out.println("The game begins!");
    }

    private void printGameField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkCell(int row, int column) {
        return gameBoard[row][column] == EMPTY;
    }

    private boolean checkForWin(char mark) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == mark && gameBoard[i][1] == mark && gameBoard[i][2] == mark ||
                    gameBoard[0][i] == mark && gameBoard[1][i] == mark && gameBoard[2][i] == mark) {
                return true;
            }
        }
        if (gameBoard[0][0] == mark && gameBoard[1][1] == mark && gameBoard[2][2] == mark ||
                gameBoard[0][2] == mark && gameBoard[1][1] == mark && gameBoard[2][0] == mark) {
            return true;
        }
        return false;
    }

    private boolean checkForFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void humanTurn(char mark) {
        int row;
        int column;
        int playerNumber = mark == X_MARK ? 1 : 2;
        while (true) {
            try {
                System.out.println("Player " + playerNumber + ":");
                System.out.println("Please, enter row number(1-3): ");
                row = scanner.nextInt() - 1;
                System.out.println("Please, enter column number(1-3): ");
                column = scanner.nextInt() - 1;
                if (checkCell(row, column)) {
                    gameBoard[row][column] = mark;
                    break;
                } else {
                    System.out.println("This cell is not empty, select another one!");
                }
            } catch (Throwable e) {
                System.out.println("Invalid input;");
            }
        }
    }

    private void AITurn() {
        int row;
        int column;
        while (true) {
            try {
                row = random.nextInt(3);
                column = random.nextInt(3);
                if (checkCell(row, column)) {
                    gameBoard[row][column] = O_MARK;
                    break;
                }
            } catch (Throwable e) {

            }
        }
        System.out.println("AI made choice;");
    }

    //Not sure if its a good solution
    public void closeScanner(){
        scanner.close();
    }
}
