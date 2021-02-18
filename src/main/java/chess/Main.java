package chess;

import java.util.Scanner;

public class Main {
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init(){
        try (Scanner scanner = new Scanner(System.in)) {

            while(true) {
                System.out.println("명령어를 입력하세요 : start(게임 스타트), end(게임 끝내기)");
                String command = scanner.nextLine();
                if(command.equals(END_COMMAND)) {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                if(command.equals(START_COMMAND)) {
                    start();
                    continue;
                }
                System.out.println("명령어를 다시 입력하세요");
            }
        }
    }

    private void start() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.printBoard());
    }
}
