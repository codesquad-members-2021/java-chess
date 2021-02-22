package cooper.chess;

import java.util.Scanner;

public class ChessGame {
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";

    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();

    public void play() {
        boolean isPlaying = true;

        while(isPlaying) {
            String command = scanner.nextLine();

            if(isStartCommand(command)) {
                System.out.println(board.showBoard());
            }

            if(isEndCommand(command)) {
                isPlaying = false;
            }
        }

        scanner.close();
    }

    private boolean isStartCommand(String command) {
        return START_COMMAND.equalsIgnoreCase(command);
    }

    private boolean isEndCommand(String command) {
        return END_COMMAND.equalsIgnoreCase(command);
    }
}
