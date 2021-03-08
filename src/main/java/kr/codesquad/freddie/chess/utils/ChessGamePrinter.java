package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.BoardView;
import kr.codesquad.freddie.chess.game.ChessGame;

public class ChessGamePrinter {
    private BoardView boardView;

    private ChessGamePrinter(BoardView boardView) {
        this.boardView = boardView;
    }

    public static ChessGamePrinter create(ChessGame chessGame) {
        return new ChessGamePrinter(new BoardView(chessGame.getBoard()));
    }

    public void printBeforeExecuteMessage() {
        String message = System.lineSeparator() +
                "명령어를 입력해주세요" + System.lineSeparator() +
                "start : 게임 시작" + System.lineSeparator() +
                "move source target : source에서 target으로 이동 e.g. move a1 a2" + System.lineSeparator() +
                "end : 게임 종료" + System.lineSeparator() + "> ";

        System.out.print(message);
    }

    public void printAfterExecuteMessage() {
        System.out.println(boardView.getRepresentation());
    }
}
