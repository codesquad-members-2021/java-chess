package net.Dong.chess;

import java.util.Scanner;

import static net.Dong.chess.Board.NEW_LINE;
public class Game {
    private static final String PROMPT = "J-chess>> ";
    private static final String HELP =
            " Command  |  description" + NEW_LINE +
            "-----------------------------" + NEW_LINE +
            " start   :  Java chess start" + NEW_LINE +
            " end     :  Java chess Terminate" + NEW_LINE +
            "-----------------------------";


    public static void main(String[] args) {
        System.out.println("==== Java chess started ===");
        System.out.println(HELP);


        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print(PROMPT);
                String command = scanner.nextLine();

                if (command.equals("start")) {
                    Board board = new Board();
                    board.initialize();
                    System.out.println(board.LayoutToString());
                }

                if (command.equals("end")) {
                    break;
                }
            }
        }
        System.out.println("==== Java chess ended ===");
    }
}
