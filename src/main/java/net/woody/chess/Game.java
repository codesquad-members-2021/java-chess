package net.woody.chess;

import net.woody.utils.CommandUtils;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // TODO : ongoing 네이밍 변경
        try (Scanner sc = new Scanner(System.in)) {
            boolean ongoing = true;
            Board board = Board.createInitBoard();
            do {
                CommandUtils.printMenu();
                String command = sc.nextLine();
                ongoing = CommandUtils.isGameContinued(command);
                if (ongoing) {
                    System.out.println(board);
                }
            } while (ongoing);
        }
    }
}
