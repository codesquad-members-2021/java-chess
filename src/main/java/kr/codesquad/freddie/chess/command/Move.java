package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.game.ChessGame;

import java.util.Arrays;

public class Move implements Command {
    private String[] command;

    public Move(String[] command) {
        if (command.length != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다." + Arrays.toString(command));
        }
        this.command = command;
    }

    @Override
    public void execute(ChessGame chessGame) {
        chessGame.move(command[1], command[2]);
    }
}
