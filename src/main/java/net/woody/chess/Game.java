package net.woody.chess;

import net.woody.utils.CommandUtil;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean ongoing = true;
        Board board = new Board();
        Scanner sc = new Scanner(System.in);
        do {
            CommandUtil.printMenu();
            String command = sc.nextLine();
            ongoing = CommandUtil.readCommand(command);
            if (ongoing) {
                board.initialize();
                System.out.println(board.print());
            }
        } while (ongoing);
        sc.close();
    }
}
