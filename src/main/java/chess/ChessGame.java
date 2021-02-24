package chess;

import java.util.Locale;
import java.util.Scanner;

public class ChessGame {
    private static boolean gameOver = false;

    public static void main(String[] args) {
        System.out.println("시작: start, 종료: end");
        try (Scanner sc = new Scanner(System.in)) {
            String command = "";
            while (!gameOver) {
                System.out.print("> ");
                command = sc.nextLine().toLowerCase(Locale.ROOT);
                if (command.equals("start")) {
                    start();
                    continue;
                }
                if (command.equals("end")) {
                    end();
                    continue;
                }
                System.out.println("명령어를 다시 입력해주세요.");
            }
        }
    }

    private static void start() {
        System.out.println("체스 게임을 시작합니다.");
        Board board = new Board();
        System.out.println(board.getResultToPrint());
    }

    private static void end() {
        gameOver = true;
        System.out.println("체스게임이 끝났습니다.");
    }
}

