package net.nas.core;

import net.nas.chess.Board;

import java.util.Scanner;

public class Main {
    private static final String START = "START";
    private static final String END = "END";

    private final Board board;
    private boolean isStarted = false;

    public Main() {
        board = new Board();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main mainOfGame = new Main();
        boolean isTerminated = false;
        System.out.print("게임을 시작하려면 start를 입력해주세요\n> ");
        while (!isTerminated) {
            String decision = scan.nextLine();
            switch (decision.toUpperCase()) {
                case START:
                    mainOfGame.startGame();
                    break;
                case END:
                    mainOfGame.endGame();
                    isTerminated = true;
                    break;
            }
            mainOfGame.print();
            if (!isTerminated)
                System.out.print("> ");
        }
    }

    public void startGame() {
        if (isStarted)
            return;
        System.out.println("게임을 시작합니다");
        board.initialize();
        isStarted = true;
    }

    public void print() {
        System.out.println(board.getRepresentationOfBoard());
    }

    public void endGame() {
        if (!isStarted)
            return;
        System.out.println("게임을 종료합니다");
        isStarted = false;
    }
}
