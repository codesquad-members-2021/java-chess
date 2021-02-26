package chess;

import pieces.Color;
import pieces.Piece;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final String START = "start";
    private static final String END = "end";
    private static final String SCORE = "score";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Play the chess!");
        System.out.println("To start, input \"start\" and \"end\" to quit.");

        process(scanner);

        System.out.println("Goodbye..");
        scanner.close();
    }

    static void process(Scanner scanner) {
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            command = command.toLowerCase();

            if (command.equals(Game.START)) {
                Board board = new Board();
                board.initialize();
                System.out.println(board);
                showScore(board);
            } else if (command.equals(Game.END)) {
                break;
            } else {
                System.out.println(command + " not supported.");
            }
        }
    }

    static void showScore(Board board) {
        double whiteScore = board.calculatePoint(Color.WHITE);
        double blackScore = board.calculatePoint(Color.BLACK);
        System.out.println("✓ White score : " + whiteScore);
        System.out.println("✓ Black score : " + blackScore);
        showScoreByPiece(board);
    }
    static void showScoreByPiece(Board board){
        List<Piece> whitePieces = board.findPiecesByColor(Color.WHITE);
        List<Piece> blackPieces = board.findPiecesByColor(Color.BLACK);
        Collections.sort(whitePieces);
        Collections.sort(blackPieces);
        System.out.println("\n[White Player's result]");
        for (Piece piece : whitePieces) {
            System.out.println(piece.getType() + " : " + piece.getType().getDefaultPoint());
        }
        System.out.println("\n[Black Player's result]");
        for (Piece piece : blackPieces) {
            System.out.println(piece.getType() + " : " + piece.getType().getDefaultPoint());
        }
    }

}
