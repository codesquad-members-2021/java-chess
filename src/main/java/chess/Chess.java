package chess;

import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("체스를 시작하시겠습니까?\n시작하려면 y, 종료하려면 n을 입력하세요.");
            String input = sc.nextLine();
            if (input.equals("y")) {
                Board board = new Board();
                board.initialize();
                System.out.println(board.showBoard());
            }
            if (input.equals("n")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
