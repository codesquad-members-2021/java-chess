package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.board.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();

        for (String command = br.readLine();
             !command.equals("end");
             command = br.readLine()) {
            if (command.equals("start")) {
                board.initialize();
                board.print();
            }
        }
    }
}
