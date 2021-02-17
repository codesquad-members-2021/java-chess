package net.woody.chess;

public class CommandUtil {

    public static void printMenu() {
        System.out.println("< Command Menu >");
        System.out.println(" 'start' : game start ");
        System.out.println(" 'end'   : game end ");
        System.out.println("( not case-sensitive 😊)");
        System.out.print("> ");
    }

    public static boolean readCommand(String command) {
        switch (command.toLowerCase()) {
            case "start":
                return true;
            case "end":
                System.out.println("bye~!💨💨");
                return false;
            default:
                System.out.println("plz enter the command again, check the command menu!");
                return true;
        }
    }
}
