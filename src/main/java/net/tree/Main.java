package net.tree;

import net.tree.chess.Board;

import java.util.Scanner;

public class Main {
<<<<<<< HEAD

    public static void main(String[] args) {
        try (
            Scanner sc = new Scanner(System.in);
        ){
            while (true) {
                Board board = new Board();
                String inputMessage = sc.next();
                switch (inputMessage) {
                    case  "start" :
                        System.out.println("====게임을 시작합니다.====\n");
                        board.initialize();
                        System.out.println(board.showBoard());
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

=======
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                String inputMessage = sc.next();
                switch (inputMessage) {
                    case  "start" :
                        System.out.println("====게임을 시작합니다.====\n");
                        Board board = new Board();
                        board.initialize();
                        board.print();
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
<<<<<<< HEAD
>>>>>>> a101753... feat : Do Mission3
=======

>>>>>>> a20eb16... kyu가 리뷰해준 내용 반영하였습니다.
}
