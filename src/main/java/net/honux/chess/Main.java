package net.honux.chess;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String game;

            Board board = new Board();
            board.initialize();

            while (!(game = sc.nextLine()).equals("end")) {
                if (game.equals("start"))
                    System.out.println(board.showBoard());
            }
            System.exit(0);
        }
    }
}

