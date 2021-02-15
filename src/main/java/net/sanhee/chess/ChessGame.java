package net.sanhee.chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {

        System.out.print("체스게임(start/end) > ");
        Scanner scanner = new Scanner(System.in);

        boolean endGame = false;
        while (!endGame) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "start":
                    Board board = new Board();
                    board.initialize();
                    System.out.println(board.print());
                    break;
                case "end":
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
