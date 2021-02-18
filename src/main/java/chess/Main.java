package chess;

import java.util.Scanner;

public class Main {
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String notice = "명령어를 입력하세요 : start(게임 스타트), end(게임 끝내기)";
            System.out.println(notice);
            String command = scanner.nextLine();

            while (!command.equals(END_COMMAND)) {
                if (command.equals(START_COMMAND))
                    start();
                if (!command.equals(START_COMMAND)) {
                    System.out.println("올바른 명령어를 입력하세요");
                }
                System.out.println(notice);
                command = scanner.nextLine();
            }
            System.out.println("게임을 종료합니다.");
        }
    }

    private static void start() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.printBoard());
    }
}
