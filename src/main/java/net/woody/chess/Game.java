package net.woody.chess;

import net.woody.utils.CommandUtils;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // TODO : 초기화 부분은 try 블럭 안으로
        // TODO : ongoing 네이밍 변경
        boolean ongoing = true;
        Board board = new Board();
        try (Scanner sc = new Scanner(System.in)) {
            do {
                CommandUtils.printMenu();
                String command = sc.nextLine();
                ongoing = CommandUtils.isGameContinued(command);
                if (ongoing) {
                    board.initialize();
                    System.out.println(board.showBoard());
                }
            } while (ongoing);
        }
    }
}
