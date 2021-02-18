package net.honux.chess;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 체스 게임을 시작하시려면 start, 끝내시려면 end 명령을 입력하세요.");

        while (true){
            String command = sc.nextLine();
            if (command.equals("start")){
                Board board = new Board();
                board.initialize();
                System.out.println(board.print());

            }else if (command.equals("end")) {
                System.out.println("Bye~");
                break;
            }

        }
        sc.close();

    }
}
