package net.kjk402.chess.chess;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(help());
        while (true) {
            System.out.print("> ");
            String command = sc.nextLine();
            if (command.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.print();
                continue;
            }
            if (command.equals("end")) {
                System.out.println("종료.");
                break;
            }
            System.out.println("올바르지 않은 명령어입니다.");
            System.out.print(help());
        }
        sc.close();
    }

    private static final String help() {
        StringBuilder help = new StringBuilder();
        help.append("시작명령어: start\n");
        help.append("종료명령어: end\n");
        return help.toString();
    }

}
