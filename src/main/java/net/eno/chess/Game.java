package net.eno.chess;

import net.eno.pieces.Color;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("> start를 입력하시면 체스 게임이 시작됩니다.");
        Scanner sc = new Scanner(System.in);
        String command;
        Board board;
        boolean check = false;

        while (true) {
            System.out.print("> ");
            command = sc.next();

            if (command.equals("start")) {
                System.out.println("> 체스 게임을 시작합니다.");
                board = new Board();
                board.initialize();
                System.out.println(board.showBoard(Color.WHITE));
                check = true;
            }

            if (check && command.equals("end")) {
                System.out.println("> 체스 게임을 종료합니다.");
                break;
            }
        }
    }

}
