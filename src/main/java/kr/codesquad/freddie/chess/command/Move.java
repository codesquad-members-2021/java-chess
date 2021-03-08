package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.game.ChessGame;

import java.util.Arrays;

public class Move implements Command {
    private static final int COMMAND_LENGTH = 3;
    private String[] command;

    public Move(String[] command) {
        if (command.length != COMMAND_LENGTH) {
            throw new IllegalArgumentException("잘못된 입력입니다." + Arrays.toString(command));
        }
        this.command = command;
    }

    @Override
    public void execute(ChessGame chessGame) {
        chessGame.move(command[1], command[2]);
    }
}
