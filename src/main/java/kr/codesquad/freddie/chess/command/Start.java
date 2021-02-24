package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.board.Board;

public class Start implements Command {
    @Override
    public void execute(Board board) {
        board.initialize();
    }
}
