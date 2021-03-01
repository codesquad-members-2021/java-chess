package chess;

import java.util.Scanner;

public class ChessStarter {
    private static final String start = "start";
    private static final String end = "end";

    public static void main(String[] args) {
        ChessStarter chessStarter = new ChessStarter();
        chessStarter.intro();
        chessStarter.ready();
    }

    void intro() {
        System.out.println("< 체스 게임 >");
        System.out.println("start : 게임 시작");
        System.out.println("end : 게임 종료");
    }

    void ready() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String input = sc.nextLine();
                if (input.equals(start)) {
                    System.out.println("게임을 시작합니다.");
                    start();
                    break;
                }
                if (input.equals(end)) {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                System.out.println("지정되지 않은 명령어입니다. 다시 입력해 주세요.");
            }
        }
    }

    void start() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.makeBoard());
        ready();
    }

}
