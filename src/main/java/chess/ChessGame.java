package chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("체스 게임 시작");
        System.out.println("게임 시작은 start, 종료는 end를 입력하세요");

        boolean endGame = false;
        boolean started = false;
        Board board = null;
        while (!endGame) {
            System.out.print("CMD> ");
            String command = scanner.nextLine();
            if ("start".equals(command)) {
                if (!started) {
                    board = new Board();
                    board.initialize();
                    System.out.println(board.print());
                    started = true;
                } else {
                    System.out.println("이미 게임이 시작되었습니다.");
                    System.out.println(board.print());
                }
            } else if ("end".equals(command)) {
                endGame = true;
            } else if ("help".equals(command)) {
                help();
            } else {
                System.out.println("잘못된 명령어입니다.");
                help();
            }
        }
    }

    public static void help() {
        System.out.println("start : 게임 시작");
        System.out.println("end : 게임 종료");
        System.out.println("help : 도움말");
    }
}
