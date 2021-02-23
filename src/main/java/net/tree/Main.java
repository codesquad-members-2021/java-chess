package net.tree;

import net.tree.chess.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            Board board = new Board();
            board.initialize();
            while (true) {
                String inputMessage = sc.next();
                switch (inputMessage) {
                    case  "start" :
                        System.out.println("====게임을 시작합니다.====\n");
                        System.out.println(board.appendBoardWithPawns());
                        break;
                    case "exit" :
                        System.out.println("====게임을 종료합니다.====\n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("메시지를 입력하세요.");
                        break;
                }
            }
        }
    }

}
