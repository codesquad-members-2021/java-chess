package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.command.Command;
import kr.codesquad.freddie.chess.game.ChessGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ChessGame chessGame = ChessGame.create();

            for (String command = br.readLine();
                 !command.equals("end");
                 command = br.readLine()) {
                try {
                    Command.create(command).execute(chessGame);
                    System.out.println(chessGame.getBoard().getRepresentation());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
