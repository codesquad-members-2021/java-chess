package chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Play the chess!");
        System.out.println("To start, input \"start\" and \"end\" to quit.");

        process(scanner);

        System.out.println("Goodbye..");
        scanner.close();
    }

    static void process(Scanner scanner) {
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            command = command.toLowerCase();

            if (command.equals("start")) {
                Board board = new Board();
                board.initialize();
                System.out.println(board);
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println(command + " not supported.");
            }
        }
    }

}
