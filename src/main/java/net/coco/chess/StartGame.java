package net.coco.chess;

import net.coco.Printer.PrintChess;
import net.coco.pieces.PawnEnum;

import java.util.Scanner;

public class StartGame {

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
            case "start":
                board.initialize();
                String blackPawns=board.getPawnsResult(PawnEnum.BLACK_COLOR);
                String whitePawns=board.getPawnsResult(PawnEnum.WHITE_COLOR);
                System.out.println(PrintChess.printBoard(blackPawns,whitePawns));
                break;
            case "end":
                System.out.println("게임을 종료");
                return true;
            default:
                throw new IllegalArgumentException("알 수 없는 명령어");
        }
        return false;
    }

}
