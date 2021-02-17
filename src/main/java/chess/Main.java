package chess;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();

        System.out.println("명령어를 입력해주세요.");
        System.out.println("end를 입력하면 종료됩니다.");
        System.out.println(" start   |   end");
        System.out.print("> ");

        try (Scanner scanner = new Scanner(System.in)){
            String command = scanner.nextLine();

            while (!command.equals("end")) {
                if (command.equals("start")) {
                    board.initialize();
                    System.out.println(board.showBoard());
                }
                System.out.print("> ");
                command = scanner.nextLine();
            }

            System.out.println("게임이 종료되었습니다.");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
