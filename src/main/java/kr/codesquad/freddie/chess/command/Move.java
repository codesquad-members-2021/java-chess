package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.game.ChessGame;

public class Move implements Command {
    private String[] command;

    public Move(String[] command) {
        this.command = command;
    }

    @Override
    public void execute(ChessGame chessGame) {
        chessGame.move(command[1], command[2]);
    }
}
