package chess.controller;

import java.util.Scanner;

enum Command {
    START, END, BAD;

    public static Command getCommand(Scanner scanner) {
        System.out.print("> ");
        try {
            return Command.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못 입력하셨습니다. start, end 명령어만 가능합니다.");
        }
        return BAD;
    }
}
