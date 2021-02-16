package chess;

import java.util.Scanner;

public class ChessGame {

    private Board board = new Board();

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        Scanner scanner = new Scanner(System.in);

        chessGame.printInitialScreen();

        String command = "";

        while (!command.equals("end")) {
            System.out.print("> ");

            command = scanner.nextLine();

            if (command.equals("start")) {
                chessGame.start();
            }
        }

        chessGame.printEndScreen();

        scanner.close();
    }
    private void printInitialScreen() {
        System.out.println("🎮 체스 게임에 오신걸 환영합니다. 🎮");
        System.out.println("게임 시작은 start, 종료는 end를 입력하세요.");
    }

    private void start() {
        board.initialize();
        String chessBoard = board.print();
        System.out.println(chessBoard);
    }

    private void printEndScreen() {
        System.out.println("다음에 만나요-⭐️");
    }
}
