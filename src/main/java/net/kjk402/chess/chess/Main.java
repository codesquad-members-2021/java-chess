package net.kjk402.chess.chess;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = sc.nextLine();
            if (command.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.print();
            }
            if (command.equals("end")) {
                break;
            }
        }
    }
}
