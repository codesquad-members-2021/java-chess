package chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작: start, 종료: end");

        boolean gameOver = false;
        while (!gameOver) {
            System.out.print("> ");
            String command = sc.nextLine();
            switch (command) {
                case "start":
                    start();
                    break;
                case "end":
                    gameOver = true;
                    System.out.println("체스게임이 끝났습니다.");
                    break;
                default:
                    System.out.println("명령어를 다시 입력해주세요.");
            }
        }

        sc.close();
    }

    private static void start() {
        System.out.println("체스 게임을 시작합니다.");
        Board board = new Board();
        board.initialize();
        board.getResultToPrint();
    }
}

