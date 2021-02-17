package chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        System.out.println("체스게임을 시작합니다");
        System.out.println("시작하려면 start 종료는 end 를 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.print();
            } else if (command.equals("end")) {
                System.out.println("게임을 종료합니다");
                break;
            } else {
                System.out.println("올바른 명령어를 입력해 주세요");
            }
        }
    }
}
