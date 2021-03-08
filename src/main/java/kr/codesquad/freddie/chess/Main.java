package kr.codesquad.freddie.chess;

import kr.codesquad.freddie.chess.command.Command;
import kr.codesquad.freddie.chess.game.ChessGame;
import kr.codesquad.freddie.chess.utils.ChessGamePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ChessGame chessGame = ChessGame.create();
            ChessGamePrinter chessGamePrinter = ChessGamePrinter.create(chessGame);

            chessGamePrinter.printBeforeExecuteMessage();
            for (String command = br.readLine(); !command.equals("end"); command = br.readLine()) {
                executeCommand(chessGame, command);
                chessGamePrinter.printAfterExecuteMessage();
            }
        }
    }

    private static void executeCommand(ChessGame chessGame, String command) {
        try {
            Command.create(command).execute(chessGame);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. command : " + command);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
