package chess;

import java.util.Scanner;

public class Game {
    private static final String START = "start";
    private static final String END = "end";

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

            if (command.equals(Game.START)) {
                Board board = new Board();
                board.initialize();
                System.out.println(board);
            } else if (command.equals(Game.END)) {
                break;
            } else {
                System.out.println(command + " not supported.");
            }
        }
    }

}
