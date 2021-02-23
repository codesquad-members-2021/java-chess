package chess.controller;

import chess.domain.board.Board;
import chess.domain.board.BoardFactory;
import chess.view.BoardView;

import java.util.Scanner;

import static chess.controller.Command.END;
import static chess.controller.Command.START;

public class ChessGame {
    private ChessGame() {}

    public static void start() {
        printWelcome();
        try (Scanner scanner = new Scanner(System.in)) {
            play(scanner);
        }
    }

    private static void printWelcome() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");
    }

    private static void print(BoardView boardView) {
        System.out.println(boardView.getBoardRepresentation());
    }

    private static void play(Scanner scanner) {
        Command command = Command.getCommand(scanner);
        if (!command.equals(START)) {
            return;
        }

        Board board = BoardFactory.create();
        BoardView boardView = new BoardView(board);

        while (!command.equals(END)) {
            print(boardView);
            command = Command.getCommand(scanner);
        }
    }
}
