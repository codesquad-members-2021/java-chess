package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.command.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Board board = new Board();

            for (String command = br.readLine();
                 !command.equals("end");
                 command = br.readLine()) {
                try {
                    Command.create(command).execute(board);
                    System.out.println(board.getRepresentation());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
