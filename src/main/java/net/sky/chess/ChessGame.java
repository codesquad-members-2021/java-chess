package net.sky.chess;

import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();

        Scanner sc = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("명령어를 입력해주세요. (start : 체스 게임 시작, end : 체스 게임 종료)");
            System.out.print("> ");
            command = sc.next();
            if (command.equals("end")) {
                System.out.println("체스 게임을 종료합니다.");
                break;
            } else if (command.equals("start")) {
                board.print();
            } else {
                System.out.println("잘못된 명령어 입니다. 다시 입력해주세요.");
            }
        }
    }

}
