package chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Play the chess!");
        System.out.println("To start, input \"start\" and \"end\" to quit.");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            command = command.toLowerCase();
            if (command.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.print();
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println(command + " not supported.");
            }
        }

        System.out.println("Goodbye..");
        scanner.close();
    }
}
