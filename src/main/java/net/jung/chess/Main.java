package net.jung.chess;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String start = "start";
        String end = "end";
        Board board = new Board();

        try( Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(">>");
                String input = sc.nextLine();
                if (end.equalsIgnoreCase(input)) {
                    break;
                }

                if (start.equalsIgnoreCase(input)) {
                    System.out.println("체스게임을 시작합니다.\n");
                    board.reset();
                    board.initialize();
                    System.out.print(board.print());
                    System.out.println();
                    continue;
                }
                System.out.println("start/end 중에서 정확히 입력해주세요.");
            }
            System.out.println("체스게임이 종료되었습니다. 다음에 만나요~");
        }
    }
}
