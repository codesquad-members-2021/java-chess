package chess;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        System.out.println("체스를 시작하시겠습니까? (y 또는 n을 입력하세요.)");
        getInput();
    }

    private static void getInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String input = sc.nextLine();
                if (input.equals("y")) {
                    startChess();
                }
                if (input.equals("n")) {
                    System.out.println("체스를 종료합니다.");
                    break;
                }
                if (!input.equals("y") && !input.equals("n")) {
                    throw new NoSuchElementException();
                }
            } catch (NoSuchElementException e) {
                System.out.println("잘못된 값입니다. y 또는 n을 입력해주세요.");
                sc = new Scanner(System.in);
            }
        }
        sc.close();
    }

    private static void startChess() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.showBoard());
    }
}
