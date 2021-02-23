package chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessMain {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println("게임을 시작합니다. ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("명령어를 입력하세요:");
                System.out.print("시작: start 종료: end  >>> ");

                String command = scanner.nextLine();
                if (command.equals("start")) {
                    board.initialize();
                    board.printBoard();

                } else if (command.equals("end")) {
                    break;
                } else {
                    System.out.println("올바른 명령어를 입력해주세요 ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("문자만 입력하여주세요!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
