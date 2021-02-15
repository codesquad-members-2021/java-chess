package net.coco.chess;

import java.util.Scanner;

public class StartGame {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Board board=new Board();
        while (true){
            System.out.println("input > ");
            String input = sc.next();

            if (commandSwitch(board, input)) return;
        }
    }

}
