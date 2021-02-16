package net.honux.chess;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();

        Scanner sc = new Scanner(System.in);
        String game = sc.nextLine();

        if (game.equals("start")) {
            while (true) {
                board.print();
                String move = sc.nextLine();
                if (move.equals("end")) {
                    System.exit(0);
                }
            }
        }
        if (game.equals("end")) {
            System.exit(0);
        }
    }
}

