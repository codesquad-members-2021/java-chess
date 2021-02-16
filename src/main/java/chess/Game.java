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
                print(board);
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println(command + " not supported.");
            }
        }
    }

    static void print(Board board) {
        StringBuilder sb = new StringBuilder();
        sb.append("........\n");
        sb.append(board.getBlackPawnsResult()).append("\n");
        for (int i = 0; i < Board.BOARD_SIZE - 4; i++) {
            sb.append("........\n");
        }
        sb.append(board.getWhitePawnsResult()).append("\n");
        sb.append("........\n");

        System.out.println(sb.toString());
    }
}
