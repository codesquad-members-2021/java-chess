package chess;

import java.util.Scanner;

public class ChessStarter {
    public static void main(String[] args) {
        ChessStarter chessStarter = new ChessStarter();
        chessStarter.intro();
        chessStarter.start();
    }

    void intro() {
        System.out.println("< 체스 게임 >");
        System.out.println("start : 게임 시작");
        System.out.println("end : 게임 종료");
    }
    
    void start() {
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        goTo(input);
    }

    void goTo(String input) {
        switch(input) {
            case "start" :
                System.out.println("게임을 시작합니다.");
                Board board = new Board();
                board.initialize();
                board.print();
                break;
            case "end" :
                System.out.println("게임을 종료합니다.");
                System.exit(0);
                break;
            default :
                System.out.println("지정되지 않은 명령어입니다. 다시 입력해 주세요.");
                start();
                break;
        }
    }
}
