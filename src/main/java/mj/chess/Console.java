package mj.chess;

import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            if (command.equals("start")) print();

            if (command.equals("end")) break;

        }

        System.out.print("Game Over");
        scanner.close();
    }

    private static void print() {
        System.out.println("Game Start");
    }
}
