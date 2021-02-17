package net.kjk402.chess.chess;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command = "";
        System.out.print(help());
        try (Scanner sc = new Scanner(System.in)) {
            while (!command.equals("end")) {
                System.out.print("> ");
                command = sc.nextLine();
                if (command.equals("start")) {
                    Board board = new Board();
                    board.initialize();
                    board.print();
                    continue;
                }
                if (command.equals("end")) {
                    System.out.println("종료합니다.");
                }
                if (command.equals("help")) {
                    System.out.println(help());
                }
            }
        }
    }

    private static final String help() {
        StringBuilder help = new StringBuilder();
        help.append("시작명령어: start\n");
        help.append("종료명령어: end\n");
        return help.toString();
    }

}
