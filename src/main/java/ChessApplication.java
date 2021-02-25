import chess.ChessGame;

import java.util.Locale;
import java.util.Scanner;

public class ChessApplication {
    private static final String START = "start";
    private static final String END = "end";
    private static final String MOVE = "move";
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        System.out.println("시작: start, 종료: end");

        ChessGame chessGame = new ChessGame();
        try (Scanner sc = new Scanner(System.in)) {
            String command = "";
            while (true) {
                System.out.print(PROMPT);
                command = sc.nextLine().toLowerCase(Locale.ROOT);
                if (command.equals(START)) {
                    chessGame.start();
                    continue;
                }
                if (command.startsWith(MOVE)) {
                    String[] commands = command.split(" ");
                    chessGame.move(commands[1], commands[2]);
                    System.out.println(chessGame.getBoard().getResultToPrint());
                    continue;
                }
                if (command.equals(END)) {
                    System.out.println("체스게임이 끝났습니다.");
                    break;
                }
                System.out.println("명령어를 다시 입력해주세요.");
            }
        }
    }
}
