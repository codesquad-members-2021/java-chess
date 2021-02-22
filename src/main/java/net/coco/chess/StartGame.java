package net.coco.chess;

import net.coco.printer.PrintChess;

import java.util.Scanner;

public class StartGame {

    private static final String START = "start";
    private static final String END = "end";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            System.out.println("input > ");
            String input = sc.next();

            if (commandSwitch(board, input)) {
                sc.close();
                return;
            }

        }
    }

    private static boolean commandSwitch(Board board, String input) {
        switch (input) {
            case START:
                board.initializeWithPieces();
                PrintChess.printBoard(board);
                break;
            case END:
                System.out.println("게임을 종료");
                return true;
            default:
                System.out.println("알 수 없는 명령어");
        }
        return false;
    }

}
