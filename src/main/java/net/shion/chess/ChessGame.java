package net.shion.chess;

import net.shion.chess.board.Board;
import net.shion.chess.pieces.Piece;

import java.util.Scanner;

public class ChessGame {

    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();

        chessGame.welcomeUser();
        String command = chessGame.getCommand();
        chessGame.proceedBy(command);
        chessGame.printEndScreen();

    }

    private void welcomeUser() {
        System.out.println("🎮 체스 게임에 오신걸 환영합니다 🎮");
        System.out.println("게임 시작은 start, 종료는 end를 입력하세요.");
    }

    private String getCommand() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    private void proceedBy(String command) {
        if (command.equals("start")) {
            startGame();
        }
    }

    private void startGame() {
        showInitialBoard();
        proceedGame();
    }

    private void proceedGame() {
        String command = "";
        while(!command.equals("end")) {
            command = getCommand();
            Piece piece = board.findPiece(command);
            System.out.println("당신은 " + piece.getColor().name() + " " + piece.getType().name() + "을(를) 선택하였소.");
        }
    }

    private void showInitialBoard() {
        board.initialize();
        String chessBoard = board.showBoard();
        System.out.println(chessBoard);
    }

    private void printEndScreen() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("다음에 만나요-⭐️");
    }
}
