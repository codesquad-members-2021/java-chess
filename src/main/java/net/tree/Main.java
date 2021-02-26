package net.tree;

import net.tree.chess.Board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("=====체스 게임에 접속하셨습니다.=====");
            System.out.println("=====시작을 원하신다면, start를 입력해주세요.=====");
            System.out.println("게임 시작 : start / 게임 종료 : exit");

            while (true) {
                String inputMessage = sc.next();
                switch (inputMessage) {
                    case  "start" :
                        Board board = new Board();
                        board.initializeAllPieces();
                        System.out.println("====게임을 시작합니다.====\n");
                        System.out.println(board.showBoard());
                        break;
                    case "exit" :
                        System.out.println("====게임을 종료합니다.====\n");
                        System.exit(0);
                    default:
                        System.out.println("안내드린 명령어 내에서 입력해주세요.");
                        System.out.println("게임 시작 : start / 게임 종료 : exit");
                }
            }
        }
    }

}
