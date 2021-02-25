package net.woody.utils;

public class CommandUtils {

    private CommandUtils() {
    }

    public static void printMenu() {
        System.out.println("< Command Menu >");
        System.out.println(" 'start' : game start ");
        System.out.println(" 'end'   : game end ");
        System.out.println("( case-insensitive 😊)");
        System.out.print("> ");
    }
   // TODO : isGameContinued 보다 isStart
    public static boolean isGameContinued(String command) {
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
