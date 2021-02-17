package mj.chess;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Console console = new Console();
        console.runConsole();
    }

    public void runConsole() {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("START")) {
                startGame();
            } else if (command.equalsIgnoreCase("END")) {
                endGame();
                break;
            } else System.out.println("Invalid Input");
        };

        scanner.close();
    }

    public void startGame() {
        Board board = new Board();
        board.initialize();
        board.print();
    }

    public void endGame() {
        System.out.print("Game Over");
    }
}
