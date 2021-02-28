package net.woody.chess;

import net.woody.utils.CommandUtils;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean isContinued = true;
            Board board = Board.createInitBoard();
            do {
                CommandUtils.printMenu();
                String command = sc.nextLine();
                isContinued = CommandUtils.isGameContinued(command);
                if (isContinued) {
                    System.out.println(board);
                }
            } while (isContinued);
        }
    }
}
