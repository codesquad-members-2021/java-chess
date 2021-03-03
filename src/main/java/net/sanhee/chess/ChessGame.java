package net.sanhee.chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        final String START = "start";
        final String END = "end";
        System.out.print("체스게임(start/end) > ");
        Scanner scanner = new Scanner(System.in);

        boolean endGame = false;
        while (!endGame) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case START:
                    Board board = new Board();
                    board.initialize();
                    System.out.println(board.showBoard(0, 1).toString());
                    break;
                case END:
                    System.out.println("> 게임이 종료되었습니다.");
                    endGame = true;
                    break;
                default:
                    System.out.println("start/end 중 하나를 입력하세요.");
                    break;
            }

        }
        scanner.close();
    }
}
