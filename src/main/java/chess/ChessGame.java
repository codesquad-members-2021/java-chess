package chess;

import java.util.Scanner;

public class ChessGame {

    private static boolean isStarted = false;
    private static final Board board = new Board();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showStartMessage();
        boolean endGame = false;
        while (!endGame) {
            String command = getCommand();
            if ("start".equals(command)) {
                start();
                System.out.println(board.showBoard());
                continue;
            }
            if ("end".equals(command)) {
                endGame = true;
                continue;
            }
            if ("help".equals(command)) {
                help();
                continue;
            }
            System.out.println("잘못된 명령어입니다.");
            help();
        }
    }

    public static String getCommand() {
        System.out.print("CMD> ");
        return scanner.nextLine();
    }

    public static void start() {
        if (isStarted) {
            System.out.println("이미 게임이 시작되었습니다.");
            return;
        }
        board.initialize();
        isStarted = true;
    }

    public static void showStartMessage() {
        System.out.println("체스 게임 시작");
        System.out.println("게임 시작은 start, 종료는 end를 입력하세요");
    }

    public static void help() {
        System.out.println("start : 게임 시작");
        System.out.println("end   : 게임 종료");
        System.out.println("help  : 도움말");
    }
}
