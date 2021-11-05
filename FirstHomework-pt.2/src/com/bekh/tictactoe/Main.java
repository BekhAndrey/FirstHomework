package com.bekh.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        while(true){
            System.out.println("Please, enter game mode");
            System.out.println("1 - human vs human;");
            System.out.println("2 - human vs AI;");
            System.out.println("3 - exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    ticTacToe.playVsHuman();
                    break;
                case 2:
                    ticTacToe.playVsAI();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid input;");
                    break;
            }

        }
    }
}
