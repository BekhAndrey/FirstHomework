package com.bekh;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private final char X_MARK = 'x';
    private final char O_MARK = 'o';
    private final char EMPTY = '-';

    private char[][] gameField;
    private Scanner scanner;


    public TicTacToe() {
        this.gameField = new char[3][3];
        this.scanner = new Scanner(System.in);
    }

    public void playVsHuman() {
        clearGameField();
        while (true){
            humanTurn(X_MARK);
            if(checkForWin(X_MARK)){
                break;
            }
            printGameField();
            humanTurn(O_MARK);
            if(checkForWin(O_MARK)){
                break;
            }
            printGameField();
        }
    }

    public void playVsAI() {

    }

    private void clearGameField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = EMPTY;
            }
        }
        System.out.println("Game begins!");
    }

    private void printGameField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkCell(Integer row, Integer column) {
        if (gameField[row][column] == EMPTY) {
            return true;
        } else {
            System.out.println("This cell is not empty, select another one!");
            return false;
        }
    }

    private boolean checkForWin(char mark) {
        Integer playerNumber = mark == X_MARK ? 1 : 2;
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == mark && gameField[i][1]== mark && gameField[i][2]== mark ||
                    gameField[0][i] == mark && gameField[1][i]== mark && gameField[2][i]== mark) {
                System.out.println("Player " + playerNumber + " won!");
                return true;
            }
        }
        if(gameField[0][0]==mark && gameField[1][1] == mark && gameField[2][2] ==mark){
            System.out.println("Player " + playerNumber + " won!");
            return true;
        }
        return false;
    }

    private void humanTurn(char mark) {
        Integer row;
        Integer column;
        Integer playerNumber = mark == X_MARK ? 1 : 2;
        while (true) {
            try {
                System.out.println("(Player " + playerNumber + ")Please, enter row number(1-3): ");
                row = scanner.nextInt() - 1;
                System.out.println("(Player " + playerNumber + ")Please, enter column number(1-3): ");
                column = scanner.nextInt() - 1;
                if (checkCell(row, column)) {
                    gameField[row][column] = mark;
                    break;
                }
            } catch (Throwable e) {
                System.out.println("Invalid input;");
            }
        }
    }
}
