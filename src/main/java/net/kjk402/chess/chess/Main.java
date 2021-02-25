package net.kjk402.chess.chess;

import static net.kjk402.chess.utils.StringUtils.appendNewLine;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command = "";
        StringBuilder help = new StringBuilder();
        help.append(appendNewLine("시작명령어: start"));
        help.append(appendNewLine("종료명령어: end"));

        System.out.print(help);
        try (Scanner sc = new Scanner(System.in)) {
            while (!command.equals("end")) {
                System.out.print("> ");
                command = sc.nextLine();
                if (command.equals("start")) {
                    Board board = new Board();
                    board.initialize();
                    System.out.println(board.showBoard());
                    continue;
                }
                if (command.equals("end")) {
                    System.out.println("종료합니다.");
                }
                if (command.equals("help")) {
                    System.out.println(help);
                }
                if (command.equals("test")){
                    Board board = new Board();
                    board.initialize();
                    //System.out.println(board.getLine());
                }
            }
        }
    }

}
