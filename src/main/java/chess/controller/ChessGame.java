package chess.controller;

import chess.domain.board.Board;
import chess.domain.board.BoardFactory;
import chess.view.BoardView;
import chess.view.ScannerView;

import static chess.controller.Command.*;

public class ChessGame {
    ScannerView scannerView;

    public void start() {
        printWelcome();

        scannerView = new ScannerView();
        Command command = getCommand();
        if (!command.equals(START)) {
            scannerView.close();
            return;
        }

        Board board = BoardFactory.create();
        BoardView boardView = new BoardView(board);

        while (!command.equals(END)) {
            print(boardView);
            command = getCommand();
        }

        scannerView.close();
    }

    private void printWelcome() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");
    }

    private void print(BoardView boardView) {
        System.out.println(boardView.getBoardRepresentation());
    }

    private Command getCommand() {
        try {
            return Command.valueOf(scannerView.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못 입력하셨습니다.");
            return BAD;
        }
    }
}
