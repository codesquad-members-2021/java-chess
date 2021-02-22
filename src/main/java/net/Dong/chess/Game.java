package net.Dong.chess;

import java.util.Scanner;

public class Game {

    private static String[] JAVACHESSHELP = {
            " 명령어  |  기능",
            "-----------------------------",
            " start   :  게임을 시작합니다",
            " end     :  게임을 종료합니다",
            "-----------------------------"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== 체스게임을 시작합니다! ===");
        for (String str : JAVACHESSHELP) {
            System.out.println(str);
        }


        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equals("start")) {
                Board board = new Board();
                board.initialize();
                board.print();
            }

            if (cmd.equals("end")) {
                break;
            }
        }

        System.out.println("==== 체스게임을 종료합니다! ===");

    }
}
