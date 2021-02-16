package chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작: start, 종료: end");

        String command = "";
        while (!command.equals("end")) {
            System.out.print("> ");
            command = sc.nextLine();
            if (command.equals("start")) {
                start();
            }
        }

        System.out.println("체스게임이 끝났습니다.");
        sc.close();
    }

    private static void start() {
        System.out.println("체스 게임을 시작합니다.");
        Board board = new Board();
        board.initialize();
        System.out.println(board.getResultToPrint());
    }
}

