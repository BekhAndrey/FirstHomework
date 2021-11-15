package com.bekh.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final int PLAY_VS_HUMAN = 1;
    private static final int PLAY_VS_AI = 2;
    private static final int EXIT = 3;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        while (true) {
            System.out.println("Please, enter game mode");
            System.out.println("1 - human vs human;");
            System.out.println("2 - human vs AI;");
            System.out.println("3 - exit");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case PLAY_VS_HUMAN:
                        ticTacToe.playVsHuman();
                        break;
                    case PLAY_VS_AI:
                        ticTacToe.playVsAI();
                        break;
                    case EXIT:
                        scanner.close();
                        ticTacToe.closeScanner();
                        System.exit(0);
                    default:
                        System.out.println("Invalid input;");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input;");
                scanner.nextLine();
            }

        }
    }
}
