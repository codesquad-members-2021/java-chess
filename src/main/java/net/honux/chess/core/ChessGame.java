package net.honux.chess.core;

import java.util.Scanner;

public class ChessGame {

    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();

    public void main() {
        String userInputCommand = "";
        boolean action = false;

        board.initialize();
        while (!userInputCommand.equals(COMMAND.END.name())) {
            userInputCommand = scanner.nextLine();
            if (validateStartCommand(userInputCommand)) {
                action = true;
            }
            if (action) {
                board.print();
            }
        }
    }

    private boolean validateStartCommand(String userInputCommand) {
        if (!userInputCommand.equals(COMMAND.START.name())) {
            System.out.println("start 가 아닙니다.");
            return false;
        }
        return true;
    }

    private enum COMMAND {START, END}
}
