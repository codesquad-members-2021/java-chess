package kr.codesquad.freddie.chess.command;

import kr.codesquad.freddie.chess.game.ChessGame;

public interface Command {
    static Command create(String command) {
        if (command.equals("start")) {
            return new Start();
        }

        if (command.startsWith("move")) {
            return new Move(command.split(" "));
        }

        throw new IllegalArgumentException("잘못된 명령어 입니다. command : " + command);
    }

    void execute(ChessGame chessGame);
}
