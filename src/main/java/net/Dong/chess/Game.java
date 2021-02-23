package net.Dong.chess;

import java.util.Scanner;

public class Game {
    private static final String PROMPT = "J-chess>> ";
    private static final String[] HELP = {
            " Command  |  description",
            "-----------------------------",
            " start   :  Java chess start",
            " end     :  Java chess Terminate",
            "-----------------------------"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Java chess started ===");
        for (String str : HELP) {
            System.out.println(str);
        }


        while (true) {
            System.out.print(PROMPT);
            String cmd = scanner.nextLine();
            if (cmd.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.print();
            }

            if (cmd.equals("end")) {
                break;
            }
        }

        System.out.println("==== Java chess ended ===");
        scanner.close();
    }
}
