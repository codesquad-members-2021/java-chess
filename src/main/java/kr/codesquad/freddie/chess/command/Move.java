package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.board.Board;

public class Move implements Command {
    private String[] command;

    public Move(String[] command) {
        this.command = command;
    }

    @Override
    public void execute(Board board) {
        board.move(command[1], command[2]);
    }
}
