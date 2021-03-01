package chess;

import java.util.Scanner;

public class ChessMain {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println("게임을 시작합니다. ");

        try (Scanner scanner = new Scanner(System.in)) {
            
            board.initialize();
            while (true) {
                System.out.println("명령어를 입력하세요:");
                System.out.print("시작: start 종료: end  >>> ");

                String command = scanner.nextLine();
                if (command.equals("start")) {
                    System.out.println(board.bringBoard());
                } else if (command.equals("end")) {
                    break;
                } else {
                    System.out.println("올바른 명령어를 입력해주세요 ");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
