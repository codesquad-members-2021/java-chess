package chess;

import piece.PositionNotMovableException;
import piece.attribute.Color;

import java.util.Locale;
import java.util.Scanner;


public class ChessGame {
    private final String START = "start";
    private final String END = "end";
    private final String MOVE = "move";
    private final String PROMPT = "> ";
    private final Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public void initialize() {
        board.initialize();
    }

    public void move(String before, String after) {
        board.move(new Position(before), new Position(after));
    }

    public double getPoint(Color color) {
        return board.calculatePoint(color);
    }

    public void runPrompt() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("시작: start, 종료: end");

        ChessView chessView = new ChessView();

        try (Scanner sc = new Scanner(System.in)) {
            String command = "";
            while (true) {
                System.out.print(PROMPT);
                command = sc.nextLine().toLowerCase(Locale.ROOT);
                if (command.equals(START)) {
                    initialize();
                    System.out.println(chessView.view(getBoard()));
                    continue;
                }
                if (command.startsWith(MOVE)) {
                    String[] commands = command.split(" ");
                    try {
                        move(commands[1], commands[2]);
                    } catch (PositionNotMovableException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(chessView.view(getBoard()));
                    continue;
                }
                if (command.equals(END)) {
                    System.out.println("WHITE TEAM : " + getPoint(Color.WHITE));
                    System.out.println("BLACK TEAM : " + getPoint(Color.BLACK));
                    System.out.println("Game Over");
                    break;
                }
                System.out.println("Please enter the command again.");
            }
        }
    }
}

