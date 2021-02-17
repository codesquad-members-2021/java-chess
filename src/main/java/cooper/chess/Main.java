package cooper.chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;

        Board board = new Board();
        board.initialize();

        while(isPlaying) {
            String command = scanner.nextLine();

            if(isStartCommand(command)) {
                System.out.println(board.getBoardStatus());
            }

            if(isEndCommand(command)) {
                isPlaying = false;
            }
        }

        scanner.close();
    }

    private static boolean isStartCommand(String command) {
        return command.equalsIgnoreCase("start");
    }

    private static boolean isEndCommand(String command) {
        return command.equalsIgnoreCase("end");
    }
}
