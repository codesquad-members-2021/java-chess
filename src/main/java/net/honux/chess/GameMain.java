package net.honux.chess;

import java.nio.channels.ClosedByInterruptException;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        System.out.println("> 체스 게임을 시작하시려면 start, 끝내시려면 end 명령을 입력하세요.");
        Board board = new Board();


        try (Scanner sc = new Scanner(System.in);) {
            String command;
            while (true) {
                command = sc.nextLine();
                if (command.equals("end")) {
                    System.out.println("Bye~");
                    break;
                }

                if (command.equals("start")) {
                    board.initialize();
                    System.out.println(board.showBoard());
                }
            }
        }
    }
}
