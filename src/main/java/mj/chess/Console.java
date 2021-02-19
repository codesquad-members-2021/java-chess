package mj.chess;

import java.util.Scanner;

public class Console {
    private Board board;

    public static void main(String[] args) {
        Console console = new Console();
        console.runConsole();
    }

    private void runConsole() {

        String command;
        board = new Board();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("START")) {
                    startGame();
                } else if (command.equalsIgnoreCase("END")) {
                    endGame();
                    break;
                } else System.out.println("Invalid Input");
            }
        }
    }

    private void startGame() {
        board.initialize();
        printCellsOfBoard();
    }

    private void endGame() {
        System.out.print("Game Over");
    }

    private void printCellsOfBoard() {
        System.out.println(board.showBoard());
    }
}
