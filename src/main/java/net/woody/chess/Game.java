package net.woody.chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean ongoing = true;
        Scanner sc = new Scanner(System.in);
        do {
            CommandUtil.printMenu();
            String command = sc.nextLine();
            ongoing = CommandUtil.readCommand(command);
        } while (ongoing);
        sc.close();
    }
}
