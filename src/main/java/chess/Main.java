package chess;

import chess.board.Board;
import chess.view.BoardView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String command = getCommand(scanner);
        if (!command.equals("start")) {
            scanner.close();
            return;
        }

        Board board = new Board();
        board.initialize();
        BoardView boardView = new BoardView(board);

        while (!command.equals("end")) {
            System.out.println(boardView.getBoardRepresentation());
            command = getCommand(scanner);
        }

        scanner.close();
    }

    public static String getCommand(Scanner scanner) {
        System.out.print("> ");
        return scanner.nextLine();
    }
}
