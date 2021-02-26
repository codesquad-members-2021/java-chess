package net.jung.chess;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String START = "start";
        final String END = "end";
        Board board = new Board();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(">>");
                String input = sc.nextLine();
                if (END.equalsIgnoreCase(input)) {
                    break;
                }

                if (START.equalsIgnoreCase(input)) {
                    System.out.println("체스게임을 시작합니다.\n");
                    board.reset();
                    board.initialize();
                    System.out.print(board.boardLayoutToString());
                    System.out.println();
                    continue;
                }
                System.out.println("start/end 중에서 정확히 입력해주세요.");
            }
            System.out.println("체스게임이 종료되었습니다. 다음에 만나요~");
        }
    }
}
