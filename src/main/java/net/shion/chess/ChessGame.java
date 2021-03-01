package net.shion.chess;

import net.shion.chess.board.Board;
import net.shion.chess.pieces.Piece;

import java.util.Scanner;

public class ChessGame {

    private Board board;

    public ChessGame() {
        board = new Board();
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();

        chessGame.welcomeUser();

        try (Scanner scanner = new Scanner(System.in)) {
            String command = chessGame.getCommand(scanner);
            chessGame.proceedBy(command, scanner);
        }

        chessGame.sayGoodBye();
    }

    private void welcomeUser() {
        System.out.println("🎮 체스 게임에 오신걸 환영합니다 🎮");
        System.out.println("게임 시작은 start, 종료는 end를 입력하세요.");
    }

    private String getCommand(Scanner scanner) {
        System.out.print("> ");
        return scanner.nextLine();
    }

    private void proceedBy(String command, Scanner scanner) {
        if (command.equals("start")) {
            startGame();
            proceedGame(scanner);
        }
    }

    private void startGame() {
        showInitialBoard();
    }

    private void proceedGame(Scanner scanner) {
        String command = "";
        while(!command.equals("end")) {
            command = getCommand(scanner);
            Piece piece = board.findPiece(command);
            System.out.println("당신은 " + piece.getColor().name() + " " + piece.getType().name() + "을(를) 선택하였소.");
        }
    }

    private void showInitialBoard() {
        board.initialize();
        String chessBoard = board.showBoard();
        System.out.println(chessBoard);
    }

    private void sayGoodBye() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("다음에 만나요-⭐️");
    }
}
