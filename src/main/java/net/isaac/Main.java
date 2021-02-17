package net.isaac;

import net.isaac.chess.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        String command;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(!(command = reader.readLine()).equals("end")){
                if(command.equals("start"))
                    startChess();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Game end.");
    }

    private static void startChess(){
        Board board = new Board();
        board.initialize();
        System.out.println("New game started.");
        board.print();
    }
}
