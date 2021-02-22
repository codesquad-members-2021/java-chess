package mj.chess;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Console console = new Console();
        console.runConsole();
    }

    private void runConsole() {
        Board board = new Board();
        String command;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("START")) {
                    startGame(board);
                } else if (command.equalsIgnoreCase("END")) {
                    endGame();
                    break;
                } else System.out.println("Invalid Input");
            }
        }
    }

    private void startGame(Board board) {
        board.initialize();
        printLocationOfPieces(board);
    }

    private void endGame() {
        System.out.print("Game Over");
    }

    private void printLocationOfPieces(Board board) {
        System.out.println(board.getLocationOfPieces());
    }
}
