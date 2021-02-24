package net.Dong.chess;

import java.util.Scanner;

public class Game {
    private static final String PROMPT = "J-chess>> ";
    private static final String HELP =
            " Command  |  description\r\n" +
            "-----------------------------\r\n" +
            " start   :  Java chess start\r\n" +
            " end     :  Java chess Terminate\r\n" +
            "-----------------------------";


    public static void main(String[] args) {
        System.out.println("==== Java chess started ===");
        System.out.println(HELP);


        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print(PROMPT);
                String cmd = scanner.nextLine();
                if (cmd.equals("start")) {
                    Board board = new Board();
                    board.initialize();
                    System.out.println(board.print());
                }

                if (cmd.equals("end")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("==== Java chess ended ===");
    }
}
