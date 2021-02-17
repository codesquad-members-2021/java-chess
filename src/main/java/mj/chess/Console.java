package mj.chess;

import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        Board board = new Board();
        board.initialize();

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            if (command.equals("start")) board.print();

            if (command.equals("end")) break;

        }

        System.out.print("Game Over");
        scanner.close();
    }
}
