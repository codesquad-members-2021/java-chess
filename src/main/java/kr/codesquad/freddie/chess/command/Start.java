package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.game.ChessGame;

public class Start implements Command {
    @Override
    public void execute(ChessGame chessGame) {
        chessGame.initialize();
    }
}
