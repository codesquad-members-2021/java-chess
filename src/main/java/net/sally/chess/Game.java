package net.sally.chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while(running) {
            System.out.println("명령을 입력하세요.");
            System.out.print("> ");

            String command = sc.nextLine();

            switch (command) {
                case "start":
                    Board board = new Board();
                    board.initialize();
                    board.print();
                    break;

                case "end":
                    running = false;
                    break;
            }
        }

        sc.close();
    }
}
