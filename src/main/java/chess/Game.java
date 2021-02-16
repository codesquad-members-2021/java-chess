package chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean over = true;

        Board board;
        while (over){
            System.out.println("\n" + "cmd > start / end ");

            String cmd = sc.nextLine();

            if(cmd.equals("start")){
                board = new Board();
                board.initialize();
                board.print();
            }else if(cmd.equals("end")) {
                System.out.println("bye");
                over = false;
                sc.close();
            }else {
                System.out.println("invalid cmd");
            }

        }

    }
}
