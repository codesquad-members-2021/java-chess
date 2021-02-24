package net.sky.chess;

import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Board board = new Board();
        board.initialize();

        gameStart(board, sc);
    }

    private static void gameStart(Board board, Scanner sc) {
        final String START = "start";
        final String END = "end";
        String command;

        while (true) {
            System.out.println("명령어를 입력해주세요. (start : 체스 게임 시작, end : 체스 게임 종료)");
            System.out.print("> ");
            command = sc.next();
            if (command.equals(END)) {
                System.out.println("체스 게임을 종료합니다.");
                break;
            }
            if (command.equals(START)) {
                board.print();
                continue;
            }
            System.out.println("잘못된 명령어 입니다. 다시 입력해주세요.");
        }
    }

}
