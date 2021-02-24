package net.woody.chess;

import net.woody.utils.CommandUtils;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
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
